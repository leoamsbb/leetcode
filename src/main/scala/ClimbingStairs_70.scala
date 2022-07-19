import scala.annotation.tailrec

object ClimbingStairs_70 {

  def climbStairs(n: Int): Int = {
    val (_, result) = (1 to n)
      .foldLeft((0, 0)) {
        case ((_, _), 1) => (0, 1)
        case ((_, _), 2) => (0, 2)
        case ((_, current), 3) => (current, 3)
        case ((prev, current), _) => (current, prev + current)
      }

    result
  }

  def main(args: Array[String]): Unit = {
    assert(climbStairs(1) == 1)
    assert(climbStairs(2) == 2)
    assert(climbStairs(3) == 3)
    assert(climbStairs(4) == 5)
    assert(climbStairs(5) == 8)
    assert(climbStairs(6) == 13)
  }
}
