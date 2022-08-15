package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// https://leetcode.com/problems/binary-tree-inorder-traversal/
public class BinaryTreeInorderTraversal94 {

    public List<Integer> inorderTraversalRecursive(TreeNode root) {
        var result = new ArrayList<Integer>();
        addNode(root, result);
        return result;
    }

    private void addNode(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        } else {
            addNode(node.left, result);
            result.add(node.val);
            addNode(node.right, result);
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        var result = new ArrayList<Integer>();
        var stack = new Stack<TreeNode>();

        var node = root;

        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if (!stack.isEmpty()) {
                node = stack.pop();
                result.add(node.val);
                node = node.right;
            }
        }

        return result;
    }

}
