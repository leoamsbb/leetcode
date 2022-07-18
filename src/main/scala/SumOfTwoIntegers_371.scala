
// https://leetcode.com/problems/sum-of-two-integers/
object SumOfTwoIntegers_371 {

  def getSum(a: Int, b: Int): Int = {
    b match {
      case 0 => a
      case _ => getSum(a ^ b, (a & b) << 1)
    }
  }

  def main(args: Array[String]): Unit = {
    assert(getSum(1, 2) == 3)
    assert(getSum(2, 3) == 5)
  }
}
