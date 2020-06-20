package problemC
import math._

object methods {
  def solver(): Unit = {

    val tempList: Seq[Seq[String]] = {
      for (line <- io.Source.stdin.getLines()) yield {
        line.split(' ').toSeq
      }
    }.toSeq
    val X: Int = tempList(0)(0).toInt
    val N: Int = tempList(0)(1).toInt

    val numList: Seq[Int] = if(N != 0) {
      tempList(1).map(_.toInt)
    } else {
      Seq()
    }

    // 0~101までで正数列が含まれない集合を求める
    val rangeList: Set[Int] = Range(0, 102).toList.toSet //これで0から101
    val diffRange: List[Int] = rangeList.diff(numList.toSet).toList
    val diffAbsRange: List[Int] = diffRange.map(x => (x-X).abs)
    val minIndex: Int = diffAbsRange.indexOf(diffAbsRange.min)
    val minOfRange: Int = diffRange(minIndex)


    println(minOfRange)
  }
}
