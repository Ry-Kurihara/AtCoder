package problemB

import scala.math._

object methods {
  def solver: Unit = {

    val tempList: Seq[Seq[String]] = {
      for(line <- io.Source.stdin.getLines()) yield {
        line.split(' ').toSeq
      }
    }.toSeq

    val X: Int = tempList(0)(0).toInt
    val Y: Int = tempList(0)(1).toInt
    var judge: Boolean = true

    if(Y % 2 != 0) println("No")
    else {
      val turtleNum = Y/2 -X
      if (turtleNum < 0) println("No")
      else {
        if(turtleNum > X) println("No")
        else println("Yes")
      }
    }

  }
}
