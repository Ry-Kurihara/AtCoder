val words = "dkdk??"

val wordsList: List[String] = words.toList.map{_.toString}

val cntMap = wordsList.groupBy(identity).mapValues(_.size)

cntMap("k")

wordsList.reverse

for(x <- 1 to 4; y<- 3 to 6){
  println(s"x_is_${x}")
  println(s"y_is_${y}")
}
