val words = "dkdk??"

val wordsList: List[String] = words.toList.map{_.toString}

val cntMap = wordsList.groupBy(identity).mapValues(_.size)

cntMap("k")

println(
  """|3
     |0 1 1 2
     |""".stripMargin)