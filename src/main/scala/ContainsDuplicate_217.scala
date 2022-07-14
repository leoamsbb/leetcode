

// https://leetcode.com/problems/contains-duplicate/
object ContainsDuplicate_217 {
  import scala.annotation.tailrec

  def containsDuplicate(nums: Array[Int]): Boolean = {

    @tailrec
    def loop(head: Int, tail: Array[Int], acc: Map[Int, Boolean]): Boolean = {
      if (acc.contains(head))
        true
      else if (tail.isEmpty)
        false
      else
        loop (tail.head, tail.tail, acc + (head -> true))
    }

    loop (nums.head, nums.tail, Map())
  }

  def main(args: Array[String]): Unit = {
    assert(containsDuplicate(Array(1, 2, 3, 1)))
    assert(!containsDuplicate(Array(1, 2, 3, 4)))
    assert(containsDuplicate(Array(1,1,1,3,3,4,3,2,4,2)))
  }
}
