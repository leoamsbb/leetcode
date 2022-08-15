package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// https://leetcode.com/problems/binary-tree-preorder-traversal/
public class BinaryTreePreorderTraversal144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        var result = new ArrayList<Integer>();
        var stack = new Stack<TreeNode>();

        var node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                result.add(node.val);
                stack.push(node);
                node = node.left;
            }
            if (!stack.isEmpty()) {
                node = stack.pop().right;
            }
        }

        return result;
    }

    public List<Integer> preorderTraversalRecursive(TreeNode root) {
        var result = new ArrayList<Integer>();
        addNode(root, result);
        return result;
    }

    public void addNode(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        } else {
            result.add(node.val);
            addNode(node.left, result);
            addNode(node.right, result);
        }
    }
}
