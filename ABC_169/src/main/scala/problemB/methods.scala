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
    val ASeq: Seq[Long] = tempList(1).map(_.toLong)

    var i = 0
    var Multiple: Long = 1L
    var zeroFlag: Boolean = false
    var rangeFlag: Boolean = false
    while(i < N){
      if(!(Multiple <= Multiple*ASeq(i) && Multiple*ASeq(i) < pow(10, 18))) rangeFlag = true
      Multiple = Multiple * ASeq(i)
      if(ASeq(i) == 0) zeroFlag = true
      i += 1
    }

    if(Multiple <= pow(10, 18) && !zeroFlag && !rangeFlag) println(Multiple) else if(zeroFlag) 0 else if(rangeFlag && !zeroFlag) println(-1) else println(-1)

  }
}
