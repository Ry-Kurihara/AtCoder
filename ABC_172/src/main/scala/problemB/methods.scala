package problemB

import scala.math._

object methods {
  def solver: Unit = {

    val tempList: Seq[Seq[String]] = {
      for(line <- io.Source.stdin.getLines()) yield {
        line.split(' ').toSeq
      }
    }.toSeq

    val S: String = tempList(0)(0)
    val T: String = tempList(1)(0)

    var i = 0
    var notSame: Int = 0
    while(i < S.size){
      if(S(i) != T(i)) notSame += 1
      i += 1
    }

    println(notSame)

  }
}
