package problemD

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object methods {
  def solver(): Unit = {

    val tempList: Seq[Seq[String]] = {
      for (line <- io.Source.stdin.getLines()) yield {
        line.split(' ').toSeq
      }
    }.toSeq
    val N: Int = tempList(0)(0).toInt
    val numList: Seq[Int] = tempList(1).map(_.toInt)

    println(itar(numList, N))
  }

  //itareeeeさんの解法
  def itar(numList: Seq[Int], N: Int): Int = {
    val rangeMax: Int = numList.max + 1
    val numMax: Int = numList.max
    val buffer: ArrayBuffer[Int] = mutable.ArrayBuffer.fill(rangeMax)(0)
    for(i <- 0 until N){
      if(buffer(numList(i)) > 0) {
        buffer(numList(i)) = 2
      }else {
        numList(i).to(numMax).by(numList(i)).foreach(multiple => buffer(multiple) += 1)
      }
    }
    val ans = numList.count{x => buffer(x) == 1}
    ans
  }

  //愚直な解法
  def naive(numList: Seq[Int], N: Int): Int = {
    //一旦愚直にやってみるO(N*(N-1))
    var allCounter: Int = 0
    numList.zipWithIndex.foreach{v =>
      var i: Int = 0
      var counter: Int = 0
      while(i < N){//iが自分自身のインデックス以外で、割り切れなかったとき
        if(i != v._2 && v._1 % numList(i) != 0) counter += 1
        //任意の値で割り切れなかったとき、counterはN-1になるはず
        if(counter == N-1) allCounter += 1
        i += 1
      }
    }
    allCounter
  }

  //調和級数を用いた解法
  def harmonySeries(numList: Seq[Int], N: Int): Int = {
    val rangeMax: Int = numList.max + 1
    val numMax: Int = numList.max //重要！！x.to(numList.max)とするとだいぶ時間がかかる
    val buffer: ArrayBuffer[Int] = mutable.ArrayBuffer.fill(rangeMax)(0)

    //記録：O(A*logA)
    numList.distinct.foreach {x =>
      x.to(numMax).by(x).toList.foreach(v => if(buffer(v) <= 1) buffer(v) += 1)
      //for(v <- x.to(numMax).by(x)){if(v != x && buffer(v) == false) buffer(v) = true}
    }//ここまで600sでできてるのでClear！下が冗長すぎた

    //値が1のインデックスを集計：リスト内の割り切れない数or割り切れない数の倍数：普通にやればO(A)、これはO(A*A*A)なってる？
    val includeMultipleIndexSet: Set[Int] = buffer.zipWithIndex.filter(x => x._1 <= 1).map(x => x._2).toSet
    val indexSet: Set[Int] = includeMultipleIndexSet.intersect(numList.toSet)
    //重複数字の集合を作りたい
    val duplicateNum: Set[Int] = numList.groupBy(identity).mapValues(_.size).map{
      case (key, value) => {
        if(value >= 2) key
        else 0
      }
    }.toSet

    val indivisibleList: List[Int] = indexSet.diff(duplicateNum).toList
    indivisibleList.length
  }
}
