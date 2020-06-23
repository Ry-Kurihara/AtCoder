import java.io.{ByteArrayInputStream, FileInputStream}
import java.nio.charset.StandardCharsets

import problemA.{methods => methods1}
import problemB.{methods => methods2}
import problemC.{methods => methods3}
import problemD.{methods => methods4}

object Main extends App{

  val str =
    """|31
       |4 1 5 9 2 6 5 3 5 8 9 7 9 3 2 3 8 4 6 2 6 4 3 3 8 3 2 7 9 5 0
       |""".stripMargin

  // 外部ファイルを読み込んで、その内容を渡す場合
  System.setIn(new ByteArrayInputStream(str.getBytes(StandardCharsets.UTF_8)))
  //System.setIn(new FileInputStream("D/in/01-Handmade-03"))

  val start = System.currentTimeMillis
  methods2.solver
  val processTime = System.currentTimeMillis - start
  println(s"処理時間${processTime}：ms")
}
