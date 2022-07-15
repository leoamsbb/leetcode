
// https://leetcode.com/problems/find-pivot-index/
object FindPivotIndex_724 {

  def pivotIndex_doesntWorkForNegativeArrays(nums: Array[Int]): Int = {
    var mid = nums.length / 2
    val (left, right) = nums.splitAt(mid)
    var leftSum = left.sum
    var rightSum = right.drop(1).sum
    var l = mid - 1
    var r = mid + 1

    while (l >= 0 && r < nums.length) {
      if (leftSum == rightSum)
        return mid
      else if (rightSum > leftSum) {
        mid = mid + 1
        rightSum = rightSum - nums(mid)
        l += 1
        leftSum = leftSum + nums(l)
        r += 1
      } else {
        mid = mid - 1
        leftSum = leftSum - nums(mid)
        r -= 1
        rightSum = rightSum + nums(r)
        l -= 1
      }
    }

    if (leftSum == rightSum) mid else -1
  }

  import scala.annotation.tailrec

  // Using Hint
  def pivotIndex(nums: Array[Int]): Int = {

    val prefixSum = nums.foldLeft(List.empty[Int]) {
      case (Nil, elem) => elem :: Nil
      case (acc, elem) => acc.head + elem :: acc
    }.reverse

    val lastIndex = nums.length - 1

    @tailrec
    def loop(index: Int): Int = {
      if (index < 0 || index > lastIndex)
        return -1

      val left = if (index == 0) 0 else prefixSum(index - 1)
      val right = if(index == lastIndex) 0 else prefixSum(lastIndex) - prefixSum(index)

      if (left == right)
        index
      else
        loop(index + 1)
    }

    loop(0)
  }

  def main(args: Array[String]): Unit = {
    assert(pivotIndex(Array(-1,-1,-1,1,1,1)) == -1)
    assert(pivotIndex(Array(-1,-1,-1,-1,-1,0)) == 2)
    assert(pivotIndex(Array(2, 1, -1)) == 0)
    assert(pivotIndex(Array(1, -1, 4)) == 2)
    assert(pivotIndex(Array(1, 7, 3, 6, 5, 6)) == 3)
    assert(pivotIndex(Array(2, 3, -1, 8, 4)) == 3)
    assert(pivotIndex(Array(2, 5)) == -1)
    assert(pivotIndex(Array(1,2,3)) == -1)
  }
}
