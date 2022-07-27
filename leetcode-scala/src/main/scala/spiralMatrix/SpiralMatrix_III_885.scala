package spiralMatrix

object SpiralMatrix_III_885 {

  def spiralMatrixIII(rows: Int, cols: Int, rStart: Int, cStart: Int): Array[Array[Int]] = {


    var r = rStart
    var c = cStart
    var inc = 1
    val toCover = rows * cols
    var coveredTillNow = 0

    var result = Array(Array(rStart, cStart))
    var rem = 0
    while (coveredTillNow < toCover) {

      println(s"Incrementer: $inc")

      for {
        i <- 1 to inc
        if (c + 1) < cols
      } {
        println(s"Enter i:$i  r:$r  c:$c")
        c += 1
        result = result :+ Array(r, c)
        println(s"First Loop: ${arrayToString(result)}")
        coveredTillNow += 1
        r = if (c + 1 >= cols && i <= inc) r + inc - 1 else r
        c = if (c + 1 >= cols && i <= inc) cols - 1 else c
        println(s"Exit i:$i  r:$r  c:$c")
      }

      for {
        i <- 1 to inc
        if (r + 1) < rows
      } {
        r += 1
        result = result :+ Array(r, c)
        println(s"Second Loop: ${arrayToString(result)}")

        coveredTillNow += 1
      }

      r = if (r >= rows) rows - 1 else r

      inc += 1

      for {
        _ <- 1 to inc
        if (c - 1) >= 0
      } {
        c -= 1
        result = result :+ Array(r, c)
        println(s"Third Loop: ${arrayToString(result)}")
        coveredTillNow += 1
      }

      c = if (c < 0) 0 else c

      for {
        _ <- 1 to inc
        if (r - 1) >= 0
      } {
        r -= 1
        result = result :+ Array(r, c)
        println(s"Forth Loop: ${arrayToString(result)}")
        coveredTillNow += 1
      }

      r = if (r < 0) 0 else r

      inc += 1
    }

    result

  }

  def main(args: Array[String]): Unit = {
    /*val result1 = arrayToString(spiralMatrixIII(1, 4, 0, 0))
    println(s"Ans1: $result1")
    assert(result1 == "[[0,0],[0,1],[0,2],[0,3]]")*/

    val result2 = arrayToString(spiralMatrixIII(rows = 5, cols = 6, rStart = 1, cStart = 4))
    println(s"Ans2: $result2")
    assert(result2 == "[[1,4],[1,5],[2,5],[2,4],[2,3],[1,3],[0,3],[0,4],[0,5],[3,5],[3,4],[3,3],[3,2],[2,2],[1,2],[0,2],[4,5],[4,4],[4,3],[4,2],[4,1],[3,1],[2,1],[1,1],[0,1],[4,0],[3,0],[2,0],[1,0],[0,0]]")
  }

  def arrayToString: Array[Array[Int]] => String = arr => arr.map(_.mkString("[", ",", "]")).mkString("[", ",", "]")
}
