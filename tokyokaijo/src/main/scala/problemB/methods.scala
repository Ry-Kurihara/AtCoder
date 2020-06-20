package problemB

import scala.math._

object methods {
  def solver: Unit = {

    val tempList: Seq[Seq[String]] = {
      for(line <- io.Source.stdin.getLines()) yield {
        line.split(' ').toSeq
      }
    }.toSeq

    //Intの範囲から出ていたのでLongに修正
    val aInfo = tempList(0).map(_.toLong)
    val bInfo = tempList(1).map(_.toLong)
    val timeLimit = tempList(2)(0).toLong

    //AとBの速度差: -ならその時点でNO
    val diffSpeed = aInfo(1) - bInfo(1)
    //T秒で縮められる距離
    val diffInSec = diffSpeed*timeLimit
    //AとBの距離
    val distance = abs(aInfo(0) - bInfo(0))

    if(diffInSec >= distance) println("YES")
    else println("NO")
  }
}
