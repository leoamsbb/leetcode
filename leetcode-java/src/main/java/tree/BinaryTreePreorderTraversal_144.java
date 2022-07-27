package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;
import java.util.stream.Collectors;

// https://leetcode.com/problems/binary-tree-preorder-traversal/
public class BinaryTreePreorderTraversal_144 {

    static public class TreeNode {
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

    public static void main(String[] args) {
        var instance = new BinaryTreePreorderTraversal_144();

        var root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        assert ("1,2,3".equals(toStr(instance.preorderTraversalRecursive(root))));

        root = new BinaryTreePreorderTraversal_144.TreeNode(2, new TreeNode(3, new TreeNode(1), null), null);
        assert ("2,3,1".equals(toStr(instance.preorderTraversalRecursive(root))));

        root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        assert ("1,2,3".equals(toStr(instance.preorderTraversal(root))));

        root = new BinaryTreePreorderTraversal_144.TreeNode(2, new TreeNode(3, new TreeNode(1), null), null);
        assert ("2,3,1".equals(toStr(instance.preorderTraversal(root))));
    }

    private static String toStr(List<Integer> result) {
        return result.stream().map(Objects::toString).collect(Collectors.joining(","));
    }
}
