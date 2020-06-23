package problemA

object methods {
  def solver: Unit = {
    val scanner = new java.util.Scanner(System.in)
    val tempList: Seq[Seq[String]] = {
      for(line <- io.Source.stdin.getLines()) yield {
        line.split(' ').toSeq
      }
    }.toSeq

    val numList: Seq[Int] = tempList(0).map(_.toInt)
    //最初の3要素を抽出
    val zeroIndex: Int = numList.indexOf(0)

    println(zeroIndex + 1)
  }
}
