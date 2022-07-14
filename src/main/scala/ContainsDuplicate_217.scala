

// https://leetcode.com/problems/contains-duplicate/
object ContainsDuplicate_217 {

  import scala.collection.mutable

  def containsDuplicate(nums: Array[Int]): Boolean = {

    var left = 0
    var right = nums.length - 1
    val map = mutable.Map.empty[Int, Boolean]

    while (left <= right) {
      if (left == right)
        return map.contains(nums(left))

      val l = nums(left)
      val r = nums(right)
      if (l == r)
        return true
      else if (map.contains(l) || map.contains(r))
        return true
      else {
        map.put(l, true)
        map.put(r, true)
      }

      left += 1
      right -= 1
    }

    false
  }

  def main(args: Array[String]): Unit = {
    assert(containsDuplicate(Array(1, 2, 3, 1)))
    assert(!containsDuplicate(Array(1, 2, 3, 4)))
    assert(containsDuplicate(Array(1, 1, 1, 3, 3, 4, 3, 2, 4, 2)))
    assert(containsDuplicate(Array(1000000000, 1000000000, 11)))
  }
}
