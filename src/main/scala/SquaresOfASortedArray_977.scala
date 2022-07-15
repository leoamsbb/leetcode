

// https://leetcode.com/problems/squares-of-a-sorted-array/
object SquaresOfASortedArray_977 {
  import scala.annotation.tailrec

  def sortedSquares(nums: Array[Int]): Array[Int] = {

    nums.map(x => x * x).sorted
    /*@tailrec
    def loop(left: Int, right: Int, acc: List[Int]): Array[Int] = {
      if (left > right) {
        acc.toArray
      } else {
        val leftNum = math.abs(nums(left))
        val rightNum = nums(right)

        if (leftNum == rightNum && left == right) {
          loop(left + 1, right - 1, leftNum * rightNum :: acc)
        } else if (leftNum == rightNum) {
          val square = leftNum * rightNum
          loop(left + 1, right - 1, square :: square :: acc)
        } else if (leftNum < rightNum) {
          loop(left, right - 1, rightNum * rightNum :: acc)
        } else {
          val square = leftNum * leftNum
          loop(left + 1, right, square :: acc)
        }
      }
    }

    loop(0, nums.length - 1, Nil)*/
  }

  def main(args: Array[String]): Unit = {
    assert(sortedSquares(Array(-4, -1, 0, 3, 10)).mkString(",") == "0,1,9,16,100")
    assert(sortedSquares(Array(-7, -3, 2, 3, 11)).mkString(",") == "4,9,9,49,121")
    assert(sortedSquares(Array(-5, -3, -2, -1)).mkString(",") == "1,4,9,25")
    assert(sortedSquares(Array(0, 2)).mkString(",") == "0,4")
  }
}
