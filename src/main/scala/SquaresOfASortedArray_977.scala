// https://leetcode.com/problems/squares-of-a-sorted-array/
object SquaresOfASortedArray_977 {

  def sortedSquares(nums: Array[Int]): Array[Int] = {

    val indexOfZero = nums.lastIndexWhere(_ <= 0)
    var left = indexOfZero
    var right = indexOfZero + 1
    var result = Array.empty[Int]

    while (left >= 0 && right < nums.length) {
      val leftNum = math.abs(nums(left))
      val rightNum = nums(right)

      if (leftNum == rightNum) {
        val square = leftNum * rightNum
        result = result ++ Array.fill(2)(square)
        left -= 1
        right += 1
      } else if (leftNum < rightNum) {
        val leftSquare = leftNum * leftNum
        result = result :+ leftSquare
        left -= 1
      } else {
        val rightSquare = rightNum * rightNum
        result = result :+ rightSquare
        right += 1
      }
    }

    while (left >= 0) {
      val leftNum = nums(left)
      val leftSquare = leftNum * leftNum
      result = result :+ leftSquare
      left -= 1
    }

    while (right < nums.length) {
      val rightNum = nums(right)
      val rightSquare = rightNum * rightNum
      result = result :+ rightSquare
      right += 1
    }

    println(result.mkString(","))
    result
  }

  def main(args: Array[String]): Unit = {
    assert(sortedSquares(Array(-4,-1,0,3,10)).mkString(",") == "0,1,9,16,100")
    assert(sortedSquares(Array(-7,-3,2,3,11)).mkString(",") == "4,9,9,49,121")
  }
}
