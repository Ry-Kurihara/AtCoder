import java.io.ByteArrayInputStream
import java.nio.charset.StandardCharsets

import problemA.{methods => methods1}
import problemB.{methods => methods2}
import problemC.{methods => methods3}

object Main extends App{

  val str =
    """|5 2
       |1 0 0 1 0
       |""".stripMargin

  System.setIn(new ByteArrayInputStream(str.getBytes(StandardCharsets.UTF_8)))

  methods3.solver
}
