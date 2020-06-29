package problemA

object methods {
  def solver: Unit = {
    val scanner = new java.util.Scanner(System.in)
    val tempList: Seq[Seq[String]] = {
      for(line <- io.Source.stdin.getLines()) yield {
        line.split(' ').toSeq
      }
    }.toSeq

    val X: String = tempList(0)(0)
    val u = X.toCharArray
    val ui: Array[Boolean] = u.map(_.isUpper)

    if(ui(0)) println("A") else println("a")
  }
}
