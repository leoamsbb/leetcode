
// https://leetcode.com/problems/merge-two-sorted-lists/
object MergeTwoSortedLists_21 {

  class ListNode(_x: Int = 0, _next: ListNode = null) {
    var next: ListNode = _next
    var x: Int = _x
  }


  def mergeTwoLists(list1: ListNode, list2: ListNode): ListNode = {

    (list1, list2) match {
      case (null, null) => null
      case (_, null) => list1
      case (null, _) => list2
      case _ =>
        val resultHead = if (list1.x <= list2.x) list1 else list2
        var result = resultHead

        var head1 = if (list1.x <= list2.x) list1.next else list1
        var head2 = if (list1.x > list2.x) list2.next else list2

        while (head1 != null && head2 != null) {
          if (head1.x <= head2.x) {
            result.next = head1
            head1 = head1.next
            result = result.next
          } else {
            result.next = head2
            head2 = head2.next
            result = result.next
          }
        }

        while (head1 != null) {
          result.next = head1
          head1 = head1.next
          result = result.next
        }

        while (head2 != null) {
          result.next = head2
          head2 = head2.next
          result = result.next
        }

        resultHead
    }

  }

  def main(args: Array[String]): Unit = {
    assert(listToString(mergeTwoLists(getList(1,2,4), getList(1,3,4))) == "1,1,2,3,4,4")
    assert(listToString(mergeTwoLists(getList(), getList())) == "")
    assert(listToString(mergeTwoLists(getList(), getList(1,2,3,4))) == "1,2,3,4")
    assert(listToString(mergeTwoLists(getList(5,6,7,8), getList())) == "5,6,7,8")
    assert(listToString(mergeTwoLists(getList(5,6,7,8), getList(1,2,3,4))) == "1,2,3,4,5,6,7,8")
  }

  private def getList(args: Int *) = {
    args.foldRight[ListNode](null) {
      case (elem, acc) => new ListNode(elem, acc)
    }
  }

  private def listToString(head: ListNode): String = {
    List.unfold[Int, ListNode](head) {
      case h if h == null => None
      case node => Some(node.x, node.next)
    }.mkString(",")
  }
}
