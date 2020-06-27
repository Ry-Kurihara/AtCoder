package problemC
import math._

object methods {
  def solver(): Unit = {

    val tempList: Seq[Seq[String]] = {
      for (line <- io.Source.stdin.getLines()) yield {
        line.split(' ').toSeq
      }
    }.toSeq
    val N: Int = tempList(0)(0).toInt
    val M: Int = tempList(0)(1).toInt
    val K: Int = tempList(0)(2).toInt
    val ASeq: Seq[Int] = tempList(1).map(_.toInt)
    val BSeq: Seq[Int] = tempList(2).map(_.toInt)

    val reading: Int = readBook(ASeq, BSeq, K) //readNum = 0が初期値なので省略
    println(reading)
  }

  def readBook(bookA: Seq[Int], bookB: Seq[Int], K: Int, readNum: Int = 0): Int = {
    var timeLimit: Int = K
    var whichBook: String = "A"
    if(bookA.size == 0 && bookB.size == 0) readNum
    else if(bookA.size == 0){
      if(bookB.head <= timeLimit) {
        timeLimit -= bookB.head
        readBook(bookA, bookB.tail, timeLimit, readNum+1)
      } else readNum
    }
    else if(bookB.size == 0){
      if(bookA.head <= timeLimit) {
        timeLimit -= bookA.head
        readBook(bookA.tail, bookB, timeLimit, readNum+1)
      } else readNum
    }
    else if (timeLimit < bookA.head && timeLimit < bookB.head) readNum
    else {
      val changedBook: Seq[Int] = {
        if (bookA.head <= bookB.head) {
          timeLimit -= bookA.head
          whichBook = "A"
          bookA.tail
        } else {
          timeLimit -= bookB.head
          whichBook = "B"
          bookB.tail
        }
      }
      if(whichBook == "A") readBook(changedBook, bookB, timeLimit, readNum+1)
      else readBook(bookA, changedBook, timeLimit, readNum+1)
    } //else締め
  }
}
