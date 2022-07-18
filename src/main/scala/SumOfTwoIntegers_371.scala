
// https://leetcode.com/problems/sum-of-two-integers/
object SumOfTwoIntegers_371 {

  def getSum(a: Int, b: Int): Int = {
    var num1 = a
    var num2 = b
    var temp = num1
    while (num2 != 0) {
      temp = num1 ^ num2
      num2 = (num1 & num2) << 1
      num1 = temp
    }
    num1
  }

  def main(args: Array[String]): Unit = {
    assert(getSum(1, 2) == 3)
    assert(getSum(2, 3) == 5)
  }
}
