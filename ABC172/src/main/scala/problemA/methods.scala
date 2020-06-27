package problemA

object methods {
  def solver: Unit = {
    val scanner = new java.util.Scanner(System.in)
    val tempList: Seq[Seq[String]] = {
      for(line <- io.Source.stdin.getLines()) yield {
        line.split(' ').toSeq
      }
    }.toSeq

    val num: Int = tempList(0)(0).toInt

    val calc: Int = num + num*num + num*num*num


    println(calc)
  }
}
