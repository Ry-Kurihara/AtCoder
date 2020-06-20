package problemA

object methods {
  def solver: Unit = {
    val scanner = new java.util.Scanner(System.in)
    val line = scanner.nextLine

    val lineList: List[String] = line.toList.map(_.toString)
    //最初の3要素を抽出
    val nickName: String = lineList.take(3).mkString

    println(nickName)
  }
}
