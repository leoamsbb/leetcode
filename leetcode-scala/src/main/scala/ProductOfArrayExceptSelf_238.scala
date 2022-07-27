
// https://leetcode.com/problems/product-of-array-except-self/
object ProductOfArrayExceptSelf_238 {

  def productExceptSelf(nums: Array[Int]): Array[Int] = {

    val leftPass = nums.scanLeft(1)(_ * _).dropRight(1)
    val rightPass = nums.scanRight(1)(_ * _).tail

    leftPass.zip(rightPass).map{
      case (a,b) => a * b
    }
  }

  def main(args: Array[String]): Unit = {
    println(productExceptSelf(Array(1,2,3,4)).mkString(","))
  }
}
