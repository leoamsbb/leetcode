package spiralMatrix

object SpiralMatrix_54 {

  def spiralOrder(matrix: Array[Array[Int]]): List[Int] = {

    var lowestRow = 0
    var highestRow = matrix.length - 1
    var lowestCol = 0
    var highestCol = matrix(0).length - 1

    var result = List.empty[Int]
    while (lowestRow <= highestRow && lowestCol <= highestCol) {
      for {
        col <- lowestCol to highestCol
        if lowestRow <= highestRow
      } {
        result = result :+ matrix(lowestRow)(col)
      }
      lowestRow += 1

      for {
        row <- lowestRow to highestRow
        if lowestCol <= highestCol
      } {
        result = result :+ matrix(row)(highestCol)
      }
      highestCol -= 1

      for {
        col <- highestCol to lowestCol by -1
        if lowestRow <= highestRow
      } {
        result = result :+ matrix(highestRow)(col)
      }
      highestRow -= 1

      for {
        row <- highestRow to lowestRow by -1
        if lowestCol <= highestCol
      } {
        result = result :+ matrix(row)(lowestCol)
      }
      lowestCol += 1
    }
    result
  }

  def main(args: Array[String]): Unit = {
    assert(spiralOrder(Array(Array(1))).mkString(",") == "1")
    assert(spiralOrder(Array(Array(1,2,3))).mkString(",") == "1,2,3")
    assert(spiralOrder(Array(Array(1,2), Array(3,4), Array(5,6), Array(7,8))).mkString(",") == "1,2,4,6,8,7,5,3")
    assert(spiralOrder(Array(Array(1,2,3),Array(4,5,6),Array(7,8,9))).mkString(",") == "1,2,3,6,9,8,7,4,5")
    assert(spiralOrder(Array(Array(1,2,3,4),Array(5,6,7,8),Array(9,10,11,12))).mkString(",") == "1,2,3,4,8,12,11,10,9,5,6,7")
    assert(spiralOrder(Array(Array(1,2,3),Array(4,5,6),Array(7,8,9), Array(10,11,12))).mkString(",") == "1,2,3,6,9,12,11,10,7,4,5,8")
  }
}
