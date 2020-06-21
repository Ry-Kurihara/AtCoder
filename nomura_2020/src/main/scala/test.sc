val words = "dkdk??"

val wordsList: List[String] = words.toList.map{_.toString}

val cntMap = wordsList.groupBy(identity).mapValues(_.size)

cntMap("k")

wordsList.reverse

val lo: Long = 250012613050149995L
