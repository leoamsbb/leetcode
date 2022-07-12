
// https://leetcode.com/problems/flatten-nested-list-iterator/
object FlattenNestedListIterator_341 {

}

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * trait NestedInteger {
 *
 *   // Return true if this NestedInteger holds a single integer, rather than a nested list.
 *   def isInteger: Boolean
 *
 *   // Return the single integer that this NestedInteger holds, if it holds a single integer.
 *   def getInteger: Int
 *
 *   // Set this NestedInteger to hold a single integer.
 *   def setInteger(i: Int): Unit
 *
 *   // Return the nested list that this NestedInteger holds, if it holds a nested list.
 *   def getList: Array[NestedInteger]
 *
 *   // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *   def add(ni: NestedInteger): Unit
 * }
 */

trait NestedInteger {
  def isInteger : Boolean

  def getInteger: Int

  def setInteger(i:Int): Unit

  def getList:Array[NestedInteger]

  def add(ni: NestedInteger): Unit
}

class NestedIterator(_nestedList: List[NestedInteger]) {
  import scala.annotation.tailrec

  @tailrec
  final def advance(list: List[NestedInteger]): Option[(Int, List[NestedInteger])] = {
    list match {
      case Nil => None
      case h :: t if h.isInteger => Some(h.getInteger, t)
      case h :: t => advance(h.getList.toList ++ t)
    }
  }

  private[this] val iterator = Iterator.unfold(_nestedList)(advance)


  def next() : Int = iterator.next()

  def hasNext() : Boolean = iterator.hasNext
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * var obj = new NestedIterator(nestedList)
 * var param_1 = obj.next()
 * var param_2 = obj.hasNext()
 */