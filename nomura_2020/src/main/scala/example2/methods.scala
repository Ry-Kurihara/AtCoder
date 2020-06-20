package example2

import scala.Char

object methods {
  def solver: Unit = {
    val scanner = new java.util.Scanner(System.in)
    val words = scanner.nextLine.map(_.toString).map { x =>
      if(x == "?"){
        "D"
      } else{
        x
      }
    }.mkString("")

    //val cntMap = wordsList.groupBy(identity).mapValues(_.size)

    println(words)
  }
}
