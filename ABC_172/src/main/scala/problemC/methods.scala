package problemC
import math._

object methods {
  def solver(): Unit = {

    val Array(n, m, k) = scala.io.StdIn.readLine().split(" ").map(_.toLong)
    val A: Seq[Long] = scala.io.StdIn.readLine().split(" ").map(_.toLong)
    val B: Seq[Long] = scala.io.StdIn.readLine().split(" ").map(_.toLong)

    //累積和の求め方ここで必要な計算量はO(N+M)
    val cumA: Seq[Long] = A.scanLeft(0L)((x, y) => x + y)
    val cumB: Seq[Long] = B.scanLeft(0L)((x, y) => x + y)

    //Aから1冊ずつ取っていく
    var max: Long = 0L
    for((cumNum, i) <- cumA.zipWithIndex; if(cumNum < k)){
      println(s"Aは${i}冊、残り時間${k-cumNum}、Bは${binarySearch(cumB.tail, k -cumNum)}冊")
      if(max < i + binarySearch(cumB.tail, k - cumNum)) max = i + binarySearch(cumB.tail, k - cumNum)
    }

    println(max)

  }

  //ターゲットに対する2分探索：型パラメータを後々使おう
  //このアルゴリズムの場合、何冊読めるかを返す
  def binarySearch(A: Seq[Long], target: Long): Long = {
    var low: Long = 0L
    var high: Long = A.size.toLong - 1L
    var mid: Long = {(low + high)/2L}.floor.toLong
    var flag: Boolean = false
    while(low <= high && !flag){ // low = highになっても終了：残りが1要素の場合
      mid = {(low + high)/2L}.floor.toLong
      var guess: Long = A(mid.toInt)
      if (guess == target) flag = true
      else if (guess > target) high = mid - 1
      else low = mid + 1
    }
    // TODO:1冊ちょうど読める時と、1冊も読めない時の返り値が一緒になっている
    if (low > high && mid.toInt == 0) 0L
    else if(low > high) mid
    else mid + 1L
  }

}
