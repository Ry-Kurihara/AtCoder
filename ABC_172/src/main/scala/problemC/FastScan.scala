package problemC

object FastScan {
  def solver(): Unit = {
    val sc = new FastScanner(System.in)
    val n, m = sc.nextInt()
    var k = sc.nextInt()
    val a = Array.fill(n)(sc.nextLong())
    val b = Array.fill(m)(sc.nextLong())

    println(s"aの長さ${a.size}、bの長さ${b.size}")
  }
}


class FastScanner(source: java.io.InputStream) {
  val buf = new Array[Byte](1024)
  var now, end = 0

  def isPrintable(b: Byte): Boolean = 33 <= b && b <= 126
  def isNum(b: Byte): Boolean = 48 <= b && b <= 57

  def hasNextByte: Boolean = {
    if(now < end) {
      true
    } else {
      now = 0
      end = source.read(buf)
      end > 0
    }
  }
  def nextByte(): Byte = {
    if (hasNextByte) {
      val b = buf(now)
      now += 1
      b
    } else {
      -1
    }
  }

  def hasNext: Boolean = {
    while (hasNextByte && !isPrintable(buf(now))) {
      now += 1
    }
    hasNextByte
  }

  def next(): String = {
    if (hasNext) {
      val sb = new StringBuilder()
      var b = nextByte()
      while (isPrintable(b)) {
        sb += b.toChar
        b = nextByte()
      }
      sb.toString
    } else {
      throw new NoSuchElementException()
    }
  }

  def nextInt(): Int = {
    nextLong().toInt
  }

  def nextLong(): Long = {
    if (hasNext) {
      var b = nextByte()
      var sign = 1
      var n = 0L
      if (b == '-') {
        sign = -1
        b = nextByte()
      }
      while (isNum(b)) {
        n = n * 10 + (b - 48)
        b = nextByte()
      }
      sign * n
    } else {
      throw new NoSuchElementException()
    }
  }

  def nextDouble(): Double = next().toDouble
}