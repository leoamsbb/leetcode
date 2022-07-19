import scala.annotation.tailrec

object ClimbingStairs_70 {

  def climbStairs(n: Int): Int = {

    val allOnes = 1
    val allTwos = if (n % 2 == 0) 1 else 0
    val until = if (n % 2 == 0) (n / 2 - 1) else (n /2)
    val rest = (1 to until)
      .map(numberOfTwos => {
        val numberOfOnes = n - (numberOfTwos * 2)
        numberOfOnes + numberOfTwos
      }).sum

    allOnes + allTwos + rest
  }

  def main(args: Array[String]): Unit = {
    assert(climbStairs(6) == 13)
    assert(climbStairs(2) == 2)
    assert(climbStairs(3) == 3)
    assert(climbStairs(4) == 5)
    assert(climbStairs(5) == 8)
  }
}
