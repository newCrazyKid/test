package leetcode.tree.binarytree;

public class Solution1325 {
    private int flag;
    public BinaryTreeNode removeLeafNodes(BinaryTreeNode root, int target) {
        flag = target;
        BinaryTreeNode dummy = new BinaryTreeNode(-1);
        dummy.left = root;
        dfs(dummy, root, true);
        return dummy.left;
    }

    public void dfs(BinaryTreeNode parent, BinaryTreeNode node, Boolean isLeft) {
        if(node == null) {
            return;
        }
        dfs(node, node.left, true);
        dfs(node, node.right, false);
        if(node.val == flag && node.left == null && node.right == null) {
            if(isLeft) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }
    }
}
