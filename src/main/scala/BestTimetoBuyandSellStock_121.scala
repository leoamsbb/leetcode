
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
object BestTimetoBuyandSellStock_121 {

  def maxProfit(prices: Array[Int]): Int = {
    import scala.math.{max, min}

    val (_, maxProfit) = prices.foldLeft((Int.MaxValue, 0)) {
      case ((minElemTillNow, maxProfitTillNow), elem) =>
        val nextMin = min(minElemTillNow, elem)
        val nextProfit = max(maxProfitTillNow, elem - nextMin)
        (nextMin, nextProfit)
    }

    maxProfit
  }


  def main(args: Array[String]): Unit = {
    assert(maxProfit(Array(7, 1, 5, 3, 6, 4)) == 5)
    assert(maxProfit(Array(1)) == 0)
    assert(maxProfit(Array(7, 6, 4, 3, 1)) == 0)
  }
}
