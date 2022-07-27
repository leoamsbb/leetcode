import scala.annotation.tailrec

// https://leetcode.com/problems/two-sum/
object TwoSum_01 {
  def main(args: Array[String]): Unit = {
    twoSum(Array (2,7,11,15), 9)
    twoSum(Array (3,2,4), 6)
    twoSum(Array (3,3), 6)
  }

  private def twoSum(nums: Array[Int], target: Int): Array[Int] = {

    @tailrec
    def loop(current: (Int, Int), remaining: Seq[(Int, Int)]):Array[Int] = {
      val intendedNumber = target - current._1
      val containsResult = remaining.find(t => t._1 == intendedNumber)
      if (containsResult.nonEmpty) {
        Array(current._2, containsResult.get._2);
      } else {
        loop(remaining.head, remaining.tail)
      }
    }

    val input = nums.zipWithIndex
    val result = loop(input.head, input.tail)
    println(s"result: $result")
    result
  }
}
