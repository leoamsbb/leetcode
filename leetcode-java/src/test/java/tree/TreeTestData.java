package tree;

public class TreeTestData {

    public static TreeNode getTreeFour() {
        TreeNode leaf_twentyFour = new TreeNode(24);
        TreeNode leaf_eighteen = new TreeNode(18);
        TreeNode twentyTwo = new TreeNode(22, leaf_eighteen, leaf_twentyFour);
        TreeNode leaf_twelve = new TreeNode(12);
        TreeNode leaf_four = new TreeNode(4);
        TreeNode ten = new TreeNode(10, leaf_four, leaf_twelve);
        var fifteen = new TreeNode(15, ten, twentyTwo);

        TreeNode leaf_ninety = new TreeNode(90);
        TreeNode leaf_sixtySix = new TreeNode(66);
        TreeNode seventy = new TreeNode(70, leaf_sixtySix, leaf_ninety);
        TreeNode leaf_fortyFour = new TreeNode(44);
        TreeNode leaf_thirtyOne = new TreeNode(31);
        TreeNode thirtyFive = new TreeNode(35, leaf_thirtyOne, leaf_fortyFour);
        var fifty = new TreeNode(50, thirtyFive, seventy);

        var twenty_five = new TreeNode(25, fifteen, fifty);

        return twenty_five;
    }

    public static TreeNode getTreeThree() {
        var three = new TreeNode(3);
        var five = new TreeNode(5);
        var four = new TreeNode(4);
        var two = new TreeNode(2, four, five);
        var one = new TreeNode(1, two, three);

        return one;
    }

    public static TreeNode getTreeTwo() {
        var one = new TreeNode(1);
        var three = new TreeNode(3, one, null);
        var two = new TreeNode(2, three, null);

        return two;
    }

    public static TreeNode getTreeOne() {
        var three = new TreeNode(3);
        var two = new TreeNode(2, three, null);
        var one = new TreeNode(1, null, two);

        return one;
    }

}
