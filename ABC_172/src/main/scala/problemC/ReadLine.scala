package problemC

object ReadLine {
  def solver(): Unit = {
    val Array(n, m, k) = scala.io.StdIn.readLine().split(" ").map(_.toLong)
    val A = scala.io.StdIn.readLine().split(" ").map(_.toLong)
    val B = scala.io.StdIn.readLine().split(" ").map(_.toLong)

    println(s"aの長さ${A.size}、bの長さ${B.size}")
  }
}
