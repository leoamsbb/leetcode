package tree;

import java.util.ArrayList;
import java.util.List;

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

    public List<Integer> inorderTraversal(TreeNode root) {
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

    public static void main(String[] args) {
        var instance = new BinaryTreeInorderTraversal_94();

        var three = new TreeNode(3, null, null);
        var two = new TreeNode(2, three, null);
        var root = new TreeNode(1, null, two);
        instance.inorderTraversal(root).forEach(System.out::println);
    }

}
