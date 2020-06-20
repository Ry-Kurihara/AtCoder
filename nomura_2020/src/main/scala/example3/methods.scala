package example3

object methods {
  def solver(): Unit = {
    //val scanner = new java.util.Scanner(System.in)

    //標準入力から変数の決定
    val tempList: Seq[Seq[String]] = {
      for(line <- io.Source.stdin.getLines()) yield {
        line.split(' ').toSeq
      }
    }.toSeq
    val N: Int = tempList(0)(0).toInt
    val dSeq: Seq[String] = tempList(1)

    //計算部分：varを使わない方法があれば知りたい.breakも欲しいのに・・・scalaには標準では実装されていない
    var currentLeaf: Int = 1
    var currentSumLeaf: Int = 1
    var checkMinus: Boolean = false
    for(notBranchLeaf <- dSeq){
      currentLeaf = calcCreateLeafNum(currentLeaf, notBranchLeaf.toInt)
      currentSumLeaf += currentLeaf
      //生成される葉の数がマイナスにはなりえない
      if (currentLeaf < 0) checkMinus = true
      println(currentLeaf)
    }

    //結果の表示
    if (checkMinus) println(-1)
    else println(currentSumLeaf)

  }

  def calcCreateLeafNum(currentLeaf: Int, notBranchLeaf: Int): Int = {
    val cutNum = 2 //2分木だから
    val createdLeaf: Int = (currentLeaf - notBranchLeaf) * cutNum
    createdLeaf
  }

}
