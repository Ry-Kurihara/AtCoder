val words = "dkdk??"

val intSeq: Array[Int] = Seq(3, 4, 5).toArray

intSeq.zipWithIndex.foreach{
  case(v: Int, i: Int) => {
    if(i <= 1){
      intSeq(i) = v + 1
    }
  }
}

println(intSeq.mkString)