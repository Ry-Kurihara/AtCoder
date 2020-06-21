import java.io.{ByteArrayInputStream, FileInputStream}
import java.nio.charset.StandardCharsets

import problemA.{methods => methods1}
import problemB.{methods => methods2}
import problemC.{methods => methods3}

object Main extends App{

  val str =
    """|10
       |0 0 1 1 2 3 5 8 13 21 34
       |""".stripMargin

  //System.setIn(new ByteArrayInputStream(str.getBytes(StandardCharsets.UTF_8)))
  System.setIn(new FileInputStream("testcase/C/in/15.txt"))

  val start = System.currentTimeMillis
  methods3.solver
  val processTime = System.currentTimeMillis - start
  println(s"処理時間${processTime}：ms")
}
