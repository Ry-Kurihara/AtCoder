import scala.collection.mutable

val words = "dkdk??"

val intSeq: Array[Int] = Seq(3, 4, 5).toArray

val rangeList: Set[Int] = Range(0, 5).toList.toSet

val cnt = mutable.ArrayBuffer.fill(12)(0)

//2.until(10, 5).toList

2.to(10).by(1).toList

val lister: List[Int] = List(2,3,6,7,2,3)
lister.groupBy(identity).mapValues(_.size).map{
  case (key, value) => {
    if(value >= 2) key
    else 0
  }
}

val ui = 9