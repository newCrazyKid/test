package leetcode.tree.binarytree;

public class SubTreeSum {
    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(0);
        BinaryTreeNode n1 = new BinaryTreeNode(1);
        BinaryTreeNode n2 = new BinaryTreeNode(2);
        root.left = n1;
        root.right = n2;
        BinaryTreeNode n3 = new BinaryTreeNode(3);
        BinaryTreeNode n4 = new BinaryTreeNode(4);
        n1.left = n3;
        n1.right = n4;
        BinaryTreeNode n5 = new BinaryTreeNode(5);
        BinaryTreeNode n6 = new BinaryTreeNode(6);
        n2.left = n5;
        n2.right = n6;

        System.out.println(getSubTreeSum(root));
    }

    public static int getSubTreeSum(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        return root.val + getSubTreeSum(root.left) + getSubTreeSum(root.right);
    }
}
