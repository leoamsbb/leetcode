package tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/binary-tree-postorder-traversal/
public class BinaryTreePostorderTraversal145 {
    public List<Integer> postorderTraversalRecursive(TreeNode root) {
        var result = new ArrayList<Integer>();
        addNode(root, result);
        return result;
    }

    private void addNode(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        } else {
            addNode(node.left, result);
            addNode(node.right, result);
            result.add(node.val);
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        var result = new ArrayList<Integer>();
        var stack1 = new ArrayDeque<TreeNode>();
        var stack2 = new ArrayDeque<TreeNode>();

        if (root != null) stack1.push(root);
        while (!stack1.isEmpty()) {
            var temp = stack1.pop();
            stack2.push(temp);
            if (temp.left != null) stack1.push(temp.left);
            if (temp.right != null) stack1.push(temp.right);
        }

        while (!stack2.isEmpty()) {
            result.add(stack2.pop().val);
        }
        return result;
    }
}
