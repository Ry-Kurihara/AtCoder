package problemC

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

    //存在するかしないかの判定
    val use = underPossibility(dSeq)
    if(!(use(0)(0)<= 1 && use(0)(1) >= 1)) println(-1)
    else {
      val reality = topPossibility(dSeq, use)
      println(reality.sum)
      //println(reality.mkString)
      //println(use.map(_.mkString).mkString(","))
    }

  }

  def underPossibility(dSeq: Seq[String]): Array[Array[Int]] = {
    val N: Int = dSeq.length -1
    val dSeqRev: Seq[Int] = dSeq.reverse.map(_.toInt)
    val possibility: Array[Array[Int]] = Array.fill(N + 1)(Array(0, 0))
    possibility(0) = Array(dSeqRev.head, dSeqRev.head)

    var i: Int = 0
    while(i < N) {
      //最小、最大を求める（round：切り捨て、floor：切り捨て、ceil：切り上げ）
      val lowerLimit: Int = (possibility(i)(0)/2.0).ceil.toInt + dSeqRev(i + 1)
      val upperLimit: Int = possibility(i)(1) + dSeqRev(i + 1)
      possibility(i + 1) = Array(lowerLimit, upperLimit)
      i += 1
    }
    possibility.reverse
  }

  def topPossibility(dSeq: Seq[String], underPossibility: Array[Array[Int]]): Array[Int] = {
    val N: Int = dSeq.length -1

    val reality: Array[Int] = Array.fill(N + 1)(0)
    reality(0) = 1

    var i = 0
    while(i < N){
      val maxReality = (reality(i) - dSeq(i).toInt) * 2
      val realMax = if(maxReality < underPossibility(i+1)(1)) maxReality else underPossibility(i+1)(1)
      reality(i + 1) = realMax
      i += 1
    }
    reality
  }
}
