// https://leetcode.com/problems/squares-of-a-sorted-array/
object SquaresOfASortedArray_977 {

  def sortedSquares(nums: Array[Int]): Array[Int] = {

    var left = 0
    var right = nums.length-1
    var resultIndex = nums.length-1
    val result = Array.ofDim[Int](nums.length)
    while (left <= right) {
      val leftNum = math.abs(nums(left))
      val rightNum = nums(right)

      if (leftNum == rightNum && left == right) {
        val square = leftNum * rightNum
        result(resultIndex) = square
        left += 1
        right -= 1
      } else if (leftNum == rightNum) {
        val square = leftNum * rightNum
        result(resultIndex) = square
        result(resultIndex - 1) = square
        resultIndex -= 2
        left += 1
        right -= 1
      }
      else if (leftNum < rightNum) {
        val rightSquare = rightNum * rightNum
        result(resultIndex) = rightSquare
        resultIndex -= 1
        right -= 1
      } else {
        val leftSquare = leftNum * leftNum
        result(resultIndex) = leftSquare
        resultIndex -= 1
        left += 1
      }
    }

    result
  }

  def main(args: Array[String]): Unit = {
    assert(sortedSquares(Array(-4,-1,0,3,10)).mkString(",") == "0,1,9,16,100")
    assert(sortedSquares(Array(-7,-3,2,3,11)).mkString(",") == "4,9,9,49,121")
    assert(sortedSquares(Array(-5,-3,-2,-1)).mkString(",") == "1,4,9,25")
    assert(sortedSquares(Array(0, 2)).mkString(",") == "0,4")
  }
}
