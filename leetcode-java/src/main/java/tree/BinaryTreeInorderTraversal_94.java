package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;
import java.util.stream.Collectors;

// https://leetcode.com/problems/binary-tree-inorder-traversal/
public class BinaryTreeInorderTraversal_94 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

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
            }
            node = node.right;
        }

        return result;
    }

    public static void main(String[] args) {
        var instance = new BinaryTreeInorderTraversal_94();

        var root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        System.out.println(toStr(instance.inorderTraversal(root)));


        root = new TreeNode(2, new TreeNode(3, new TreeNode(1),null), null);
        System.out.println(toStr(instance.inorderTraversal(root)));
    }

    private static String toStr(List<Integer> result) {
        return result.stream().map(Objects::toString).collect(Collectors.joining(","));
    }

}
