
// https://leetcode.com/problems/median-of-two-sorted-arrays/
object MedianOfTwoSortedArrays_04 {
  private def findMedianSortedArrays(nums1: Array[Int], nums2: Array[Int]): Double = {

    def toNext(seq: Seq[Int]): Seq[Int] = seq match {
      case Nil => Nil
      case _ => seq.tail
    }

    def loop(n1: Seq[Int], n2: Seq[Int], merged: List[Int]): List[Int] = {
      (n1.headOption, n2.headOption) match {
        case (None, None) => merged
        case (Some(h1), None) =>
          loop(toNext(n1), toNext(n2), h1 :: merged)
        case (None, Some(h2)) =>
          loop(toNext(n1), toNext(n2), h2 :: merged)
        case (Some(h1), Some(h2)) if h1 < h2 =>
          loop(toNext(n1), n2, h1 :: merged)
        case (Some(h1), Some(h2)) if h1 > h2 =>
          loop(n1, toNext(n2), h2 :: merged)
        case (Some(h1), Some(h2)) if h1 == h2 =>
          loop(toNext(n1), toNext(n2), h1 :: h2 :: merged)
        case _ => merged
      }
    }

    val merged = loop(nums1, nums2, Nil)
    val length = merged.length
    val index = length / 2
    if (length % 2 == 0)
      (merged(index - 1) + merged(index)).toDouble / 2
    else
      merged(index)
  }

  def main(args: Array[String]): Unit = {
    assert(findMedianSortedArrays(Array(1, 3), Array(2)) == 2.0)
    println("--------------------------------------------------------------------------------")
    assert(findMedianSortedArrays(Array(1, 2), Array(3, 4)) == 2.5)
  }
}
