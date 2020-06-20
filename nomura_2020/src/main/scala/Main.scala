import java.io.ByteArrayInputStream
import java.nio.charset.StandardCharsets

import example1.{methods => methods1}
import example2.{methods => methods2}
import example3.{methods => methods3}

object Main extends App{

  val str =
    """|4
       |0 0 1 0 2
       |""".stripMargin

  System.setIn(new ByteArrayInputStream(str.getBytes(StandardCharsets.UTF_8)))

  methods3.solver
}
