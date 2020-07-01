import java.io.{ByteArrayInputStream, FileInputStream}
import java.nio.charset.StandardCharsets

import problemA.{methods => methods1}
import problemB.{methods => methods2}
import problemC.{methods => methods3, FastScan => fast, ReadLine => ln}
import problemD.{methods => methods4}

object Main extends App{

  val str =
    """|3 4 240
       |60 90 120
       |80 150 80 150
       |""".stripMargin

  // 外部ファイルを読み込んで、その内容を渡す場合
  System.setIn(new ByteArrayInputStream(str.getBytes(StandardCharsets.UTF_8)))
  //System.setIn(new FileInputStream("testcase/C/in/b06.txt"))

  val start = System.currentTimeMillis
  methods3.solver
  val processTime = System.currentTimeMillis - start
  println(s"処理時間${processTime}：ms")
}
