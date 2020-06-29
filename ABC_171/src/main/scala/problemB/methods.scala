package problemB

import scala.math._

object methods {
  def solver: Unit = {

    val tempList: Seq[Seq[String]] = {
      for(line <- io.Source.stdin.getLines()) yield {
        line.split(' ').toSeq
      }
    }.toSeq

    val N: Int = tempList(0)(0).toInt
    val K: Int = tempList(0)(1).toInt
    val priceSeqSorted: Seq[Int] = tempList(1).map(_.toInt).sorted

    val kTakePrice: Seq[Int] = priceSeqSorted.take(K)
    val kTakePriceSum: Int = kTakePrice.sum

    println(kTakePriceSum)
  }
}
