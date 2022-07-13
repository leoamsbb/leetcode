
// https://leetcode.com/problems/container-with-most-water/
object ContainerWithMostWater_11 {

  def maxArea(height: Array[Int]): Int = {
    var left = 0
    var right = height.length - 1

    var maxArea = 0
    while (left < right) {
      val minHeight = math.min(height(left), height(right))
      val distance = right - left
      maxArea = math.max(maxArea, minHeight * distance)

      if (height(left) > height(right)) {
        right -= 1
      } else
        left += 1
    }
    maxArea
  }

  def main(args: Array[String]): Unit = {
    assert(maxArea(Array(1,8,6,2,5,4,8,3,7) ) == 49)
    assert(maxArea(Array(1,1) ) == 1)
    assert(maxArea(Array(1,2,1) ) == 2)
  }
}
