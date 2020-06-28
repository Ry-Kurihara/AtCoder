package problemC
import math._

object methods {
  def solver(): Unit = {

    val tempList: Seq[Seq[String]] = {
      for (line <- io.Source.stdin.getLines()) yield {
        line.split(' ').toSeq
      }
    }.toSeq
    val N: Long = tempList(0)(0).toLong
    val alphaList: List[String] = List("z", "a", "b", "c", "d", "e", "f", "g",
    "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u",
    "v", "w", "x", "y")

    val lst = divide(List(N))
    val lstInit = lst.init.reverse
    val lstInitStr: List[String] = lstInit.map(x => alphaList(x.toInt))

    println(lstInitStr.mkString)
  }

  def divide(nList: List[Long]): List[Long] = {
    val nDivide: Long = nList.last

    val rest: Long = nDivide % 26L
    val restList: List[Long] = nList.init :+ rest

    val sho: Long = nDivide / 26L
    val shoList: List[Long] = if(rest == 0L) restList :+ (sho - 1L) else restList :+ sho

    if(shoList.last == 0L) shoList
    else divide(shoList)
  }

}
