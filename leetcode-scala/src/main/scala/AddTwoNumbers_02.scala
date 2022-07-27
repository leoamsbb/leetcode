import scala.annotation.tailrec

// https://leetcode.com/problems/add-two-numbers/
object AddTwoNumbers_02 {

  def main(args: Array[String]): Unit = {

    val l1 = new ListNode(9)
    l1.next = new ListNode(9)
    l1.next.next = new ListNode(9)
    l1.next.next.next = new ListNode(9)
    l1.next.next.next.next = new ListNode(9)
    l1.next.next.next.next.next = new ListNode(9)
    l1.next.next.next.next.next.next = new ListNode(9)

    val l2 = new ListNode(9)
    l2.next = new ListNode(9)
    l2.next.next = new ListNode(9)
    l2.next.next.next = new ListNode(9)

    val ans = addTwoNumbers(l1, l2)

    var it = ans
    while(it != null) {
      print(it.x)
      it = it.next
    }
  }

  class ListNode(_x: Int = 0, _next: ListNode = null) {
    var next: ListNode = _next
    var x: Int = _x
  }

  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
    def toValue(node: ListNode) = if (node == null) 0 else node.x
    def nextNode(node: ListNode) = if (node == null) null else node.next

    def sum(n1: Int, n2: Int, carriage: Int): (Int, Int) = {
      val sum = n1 + n2 + carriage
      if (sum >= 10) (sum%10, 1)
      else (sum, 0)
    }

    @tailrec
    def loop(l1: ListNode, l2: ListNode, acc:Seq[Int], carriage: Int): Seq[Int] =  (l1, l2) match {
      case (null, null) =>
        if (carriage == 1) acc :+ 1
        else acc
      case _ =>
        val (ans, carr) = sum(toValue(l1), toValue(l2), carriage)
        loop(nextNode(l1), nextNode(l2), acc :+ ans, carr)
    }
    def collect(n:Int, tail:ListNode) = new ListNode(n, tail)
    loop(l1, l2, Seq.empty[Int], 0)
      .foldRight[ListNode](null)(collect)

  }
}
