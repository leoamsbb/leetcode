
// https://leetcode.com/problems/palindrome-linked-list/
object PalindromeLinkedList_234 {

  class ListNode(_x: Int = 0, _next: ListNode = null) {
    var next: ListNode = _next
    var x: Int = _x
  }

  def isPalindrome(head: ListNode): Boolean = {

    true
  }

  def main(args: Array[String]): Unit = {
    assert(isPalindrome(getList(1, 2, 2, 1)))
    assert(!isPalindrome(getList(1, 2)))
  }

  private def getList(args: Int *) = {
    args.foldRight[ListNode](null) {
      case (elem, acc) => new ListNode(elem, acc)
    }
  }
}
