package tree

object BinaryTreeInorderTraversal_94 {
  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
  }

  def inorderTraversal(root: TreeNode): List[Int] = {
    var list = List.empty[Int]

    def loop(node: TreeNode): List[Any] = {
      if (node == null) {
        Nil
      } else {

        list = list :+ node.value

        list = list :+ loop(node.left)
        list = list :+ loop(node.right)
      }
    }


  loop(root).flatMap(_)

  }

}
