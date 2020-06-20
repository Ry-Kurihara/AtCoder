import java.io.{ByteArrayInputStream, FileInputStream}
import java.nio.charset.StandardCharsets

import problemA.{methods => methods1}
import problemB.{methods => methods2}
import problemC.{methods => methods3}
import problemD.{methods => methods4}

object Main extends App{

  val str =
    """|10
       |33 18 45 28 8 19 89 86 2 4
       |""".stripMargin

  // 外部ファイルを読み込んで、その内容を渡す場合
  //System.setIn(new ByteArrayInputStream(str.getBytes(StandardCharsets.UTF_8)))
  System.setIn(new FileInputStream("D/in/01-Handmade-03"))

  val start = System.currentTimeMillis
  methods4.solver
  val processTime = System.currentTimeMillis - start
  println(s"処理時間${processTime}：ms")
}
