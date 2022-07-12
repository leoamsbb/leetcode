package spiralMatrix

object SpiralMatrixII_59 {

  def generateMatrix(n: Int): Array[Array[Int]] = {
    var lowestRow = 0
    var highestRow = n - 1
    var lowestCol = 0
    var highestCol = n - 1

    val valueIt = Iterator.from(1)

    val result = Array.ofDim[Int](n, n)

    while (lowestRow <= highestRow && lowestCol <= highestCol) {
      for (col <- lowestCol to highestCol) {
        result(lowestRow)(col) = valueIt.next()
      }
      lowestRow += 1

      for (row <- lowestRow to highestRow) {
        result(row)(highestCol) = valueIt.next()
      }
      highestCol -= 1

      for (col <- highestCol to lowestCol by -1) {
        result(highestRow)(col) = valueIt.next()
      }
      highestRow -= 1

      for (row <- highestRow to lowestRow by -1) {
        result(row)(lowestCol) = valueIt.next()
      }
      lowestCol += 1
    }
    result
  }

  def main(args: Array[String]): Unit = {
    assert(generateMatrix(1).map(_.mkString(", ")).mkString(", ") == "1");
    assert(generateMatrix(3).map(_.mkString(", ")).mkString(", ") == "1, 2, 3, 8, 9, 4, 7, 6, 5");
    assert(generateMatrix(4).map(_.mkString(", ")).mkString(", ") == "1, 2, 3, 4, 12, 13, 14, 5, 11, 16, 15, 6, 10, 9, 8, 7");
  }
}
