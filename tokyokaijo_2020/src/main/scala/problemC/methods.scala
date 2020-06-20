package problemC

object methods {
  def solver(): Unit = {

    val tempList: Seq[Seq[String]] = {
      for (line <- io.Source.stdin.getLines()) yield {
        line.split(' ').toSeq
      }
    }.toSeq
    val N: Int = tempList(0)(0).toInt //電球の個数
    val K: Int = tempList(0)(1).toInt //操作回数
    val initBrightness: Seq[Int] = tempList(1).map(_.toInt)

    //K回更新：いもす法ならこの関数でO((N+N)*K)：ナイーブな解法ならO(N*N*K)
    val kUpBrightness: Seq[Int] = loop(1, K, N, initBrightness)

    //val kUpBrightness: Seq[Int] = UpdateBrightness(N, initBrightness)：いもす法では累積和が答え
    println(kUpBrightness.mkString(" "))
  }

  //K回この操作をする: 照らしている個数のシーケンスを返す
  def UpdateBrightness(N: Int, BrightSeq: Seq[Int]): Seq[Int] = {
    val illuminateNum: Array[Int] = Seq.fill(N)(0).toArray[Int]

    //Mapとかでもできそう。時間制限にひっかかるなら改良
    var i = 0
    while (i < N) {
      //照らす範囲下部分
      val illuminateBottom: Int = {
        if (i - BrightSeq(i) < 0) 0
        else i - BrightSeq(i)
      }
      val illuminateTop: Int = {
        if(i + BrightSeq(i) > BrightSeq.length) BrightSeq.length
        else i + BrightSeq(i)
      }

      //この操作でO(N*N)を作り出している
      illuminateNum.zipWithIndex.foreach{
        case (v, i) => if(illuminateBottom <= i && i <= illuminateTop) illuminateNum(i) = v + 1
      }
      i += 1
    }//while締め
    //illuminateNum Arrayからseqへの暗黙の型変換は非推奨：warningが出る
    illuminateNum.toSeq
  }

  //累積和を使った計算（いもす法）：ランプの左始点に+1ランプの右切れ端に-1
  def UpdateByCumulativeSum(N: Int, BrightSeq: Seq[Int]): Seq[Int] = {
    //記録
    val illuminateNumCount: Array[Int] = Seq.fill(N)(0).toArray[Int]
    var i = 0
    var count: Boolean = true
    while (i < N) {
      val illuminateStart: Int = {
        if (i - BrightSeq(i) < 0) 0
        else i - BrightSeq(i)
      }
      val illuminateOut: Int = {
        if (i + BrightSeq(i) + 1 > BrightSeq.length -1) { //インデックス最大値よりも.lengthは1多い
          count = false
          BrightSeq.length
        } else {
          count = true
          i + BrightSeq(i) + 1
        }
      }
      illuminateNumCount(illuminateStart) += 1
      if (count) illuminateNumCount(illuminateOut) -= 1
      i += 1
    }
    //計測：ここで計算量はO(N+N)
    val cumulativeIlluminateNum: Seq[Int] = illuminateNumCount.scanLeft(0)((x, y) => x+y).toSeq
    cumulativeIlluminateNum.drop(1) //累積和の一番最初はいらないのでそれを覗いたSeqを返す
  }

  def loop(k: Int, K: Int, N: Int, Brightness: Seq[Int]): Seq[Int] = {
    val CurrentBrightness = UpdateByCumulativeSum(N, Brightness)

    // 計算時間エラー起こった：O(logN)回の操作で収束するらしい。なにそれってかんじだが41回を上限とする
    if(k < K && k < 42) loop(k+1, K, N, CurrentBrightness)
    else CurrentBrightness
  }

}
