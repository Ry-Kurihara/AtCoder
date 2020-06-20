package example1

object methods {
  def solver: Unit = {
    val scanner = new java.util.Scanner(System.in)
    val line = scanner.nextLine

    val lst: Array[Int] = line.split(" ").map{_.toInt}
    //一応配列の要素数を取得
    val listNum: Int = lst.length

    // わかりやすさのためにいったんすべて変数に代入する
    val wakeUpH: Int = lst(0)
    val wakeUpM: Int = lst(1)
    val sleepH: Int = lst(2)
    val sleepM: Int = lst(3)
    val studyM: Int = lst(4)

    val diffH: Int = sleepH - wakeUpH
    val diffM: Int = sleepM - wakeUpM
    //勉強できる時間
    val canStudyTime: Int = diffH*60 + diffM - studyM

    println(canStudyTime)
  }
}
