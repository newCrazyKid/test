package leetcode.tree.binarytree;

import java.util.LinkedList;
import java.util.List;

public class TreePathSum {

    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(BinaryTreeNode root, int target) {
        if (root == null) {
            return res;
        }
        path.offerLast(root.val);
        target -= root.val;
        if (root.left == null && root.right == null && target == 0) {
            res.add(new LinkedList<>(path));
        }
        pathSum(root.left, target);
        pathSum(root.right, target);
        path.pollLast(); // 回溯

        return res;
    }

    public static void main(String[] args) {

    }
}
