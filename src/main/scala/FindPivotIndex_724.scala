
// https://leetcode.com/problems/find-pivot-index/
object FindPivotIndex_724 {

  def pivotIndex(nums: Array[Int]): Int = {
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

  def main(args: Array[String]): Unit = {
    assert(pivotIndex(Array(2, 1, -1)) == 0)
    assert(pivotIndex(Array(1, -1, 4)) == 2)
    assert(pivotIndex(Array(1, 7, 3, 6, 5, 6)) == 3)
    assert(pivotIndex(Array(2, 3, -1, 8, 4)) == 3)
    assert(pivotIndex(Array(2, 5)) == -1)
    assert(pivotIndex(Array(1,2,3)) == -1)
  }
}
