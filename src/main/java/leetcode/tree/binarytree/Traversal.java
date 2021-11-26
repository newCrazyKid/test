package leetcode.tree.binarytree;

import java.lang.reflect.Array;
import java.util.*;

class BinaryTreeNode {
    int val;
    BinaryTreeNode left;
    BinaryTreeNode right;

    public BinaryTreeNode(int val) {
        this.val = val;
    }

    public BinaryTreeNode(int val, BinaryTreeNode left, BinaryTreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Traversal {

    public static void preOrderRecursion(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrderRecursion(root.left);
        preOrderRecursion(root.right);
    }

    public static void preOrderByMark(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        LinkedList<BinaryTreeNode> stack = new LinkedList<>();
        LinkedList<Boolean> mark = new LinkedList<>();
        stack.push(root);
        mark.push(false);
        while (!stack.isEmpty()) {
            BinaryTreeNode node = stack.pop();
            Boolean isMark = mark.pop();
            if (node == null) {
                continue;
            }
            if (!isMark) {
                stack.push(node.right);
                mark.push(false);
                stack.push(node.left);
                mark.push(false);
                stack.push(node);
                mark.push(true);
            } else {
                System.out.print(node.val + " ");
            }
        }
    }

    public static void preOrederByMarkNew(BinaryTreeNode root) {
        Stack<AbstractMap.SimpleEntry<BinaryTreeNode, Boolean>> stack = new Stack<>();
        stack.push(new AbstractMap.SimpleEntry<>(root, false));
        while (!stack.isEmpty()) {
            BinaryTreeNode node = stack.peek().getKey();
            Boolean flag = stack.pop().getValue();
            if (node == null) { // 已遍历到叶子结点的下一层，需要弹出其父结点
                continue;
            }
            if (!flag) { // 该结点未访问过
                stack.push(new AbstractMap.SimpleEntry<>(node.right, false));
                stack.push(new AbstractMap.SimpleEntry<>(node.left, false));
                stack.push(new AbstractMap.SimpleEntry<>(node, true));
            } else {
                System.out.print(node.val + " ");
            }
        }
    }

    /**
     * 标记法改进
     * @param root
     */
    public static void midOrderByMarkNew(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        Stack<AbstractMap.SimpleEntry<BinaryTreeNode, Boolean>> stack = new Stack<>();
        stack.push(new AbstractMap.SimpleEntry<>(root, false));
        while (!stack.isEmpty()) {
            AbstractMap.SimpleEntry<BinaryTreeNode, Boolean> nodeAndFlag = stack.pop();
            BinaryTreeNode node = nodeAndFlag.getKey();
            Boolean flag = nodeAndFlag.getValue();
            if (node == null) { //此时已到达叶子结点的下一层
                continue;
            }
            if (!flag) {
                stack.push(new AbstractMap.SimpleEntry<>(node.right, false));
                stack.push(new AbstractMap.SimpleEntry<>(node, true));
                stack.push(new AbstractMap.SimpleEntry<>(node.left, false));
            } else {
                System.out.print(node.val + " ");
            }
        }
    }
    /**
     * 使用颜色标记节点的状态，新节点为白色，已访问的节点为灰色。
     * 如果遇到的节点为白色，则将其标记为灰色，然后将其右子节点、自身、左子节点依次入栈。
     * 如果遇到的节点为灰色，则将节点的值输出。
     * @param root
     */
    public static void midOrderByMark(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        LinkedList<BinaryTreeNode> stack = new LinkedList<>();
        LinkedList<Boolean> mark = new LinkedList<>();
        stack.push(root);
        mark.push(false);
        while (!stack.isEmpty()) {
            BinaryTreeNode node = stack.pop();
            Boolean isMark = mark.pop();
            if (node == null) {
                continue;
            }
            if (!isMark) {
                stack.push(node.right);
                mark.push(false);
                stack.push(node);
                mark.push(true);
                stack.push(node.left);
                mark.push(false);
            } else {
                System.out.print(node.val + " ");
            }
        }
    }

    public static void midOrderRecursion(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        midOrderRecursion(root.left);
        System.out.print(root.val + " ");
        midOrderRecursion(root.right);
    }

    public static void postOrderRecursion(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        postOrderRecursion(root.left);
        postOrderRecursion(root.right);
        System.out.print(root.val + " ");
    }

    public static void postOrderByMark(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        LinkedList<BinaryTreeNode> stack = new LinkedList<>();
        LinkedList<Boolean> mark = new LinkedList<>();
        stack.push(root);
        mark.push(false);
        while (!stack.isEmpty()) {
            BinaryTreeNode node = stack.pop();
            Boolean isMark = mark.pop();
            if (node == null) {
                continue;
            }
            if (!isMark) {
                stack.push(node);
                mark.push(true);
                stack.push(node.right);
                mark.push(false);
                stack.push(node.left);
                mark.push(false);
            } else {
                System.out.print(node.val + " ");
            }
        }
    }

    public static void postOrderByMarkNew(BinaryTreeNode root) {
        Stack<AbstractMap.SimpleEntry<BinaryTreeNode, Boolean>> stack = new Stack<>();
        stack.push(new AbstractMap.SimpleEntry<>(root, false));
        while (!stack.isEmpty()) {
            BinaryTreeNode node = stack.peek().getKey();
            Boolean flag = stack.pop().getValue();
            if (node == null) {
                continue;
            }
            if (flag) {
                System.out.print(node.val + " ");
            } else {
                stack.push(new AbstractMap.SimpleEntry<>(node, true));
                stack.push(new AbstractMap.SimpleEntry<>(node.right, false));
                stack.push(new AbstractMap.SimpleEntry<>(node.left, false));
            }
        }
    }

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

        System.out.println("前序遍历：");
        preOrderRecursion(root);
        System.out.println();
        preOrderByMark(root);
        System.out.println();
        preOrderNonRec(root);
        System.out.println();
        preOrederByMarkNew(root);
        System.out.println();
        System.out.println("中序遍历：");
        midOrderRecursion(root);
        System.out.println();
        midOrderByMark(root);
        System.out.println();
        midOrderByMarkNew(root);
        System.out.println();
        System.out.println("后序遍历：");
        postOrderRecursion(root);
        System.out.println();
        postOrderByMark(root);
        System.out.println();
        postOrderByMarkNew(root);
        System.out.println();
        System.out.println("bfs遍历：");
        bfsTree(root);
    }

    public static void preOrderNonRec(BinaryTreeNode root) {
        Stack<BinaryTreeNode> stack = new Stack<>();
        BinaryTreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                System.out.print(cur.val + " ");
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop().right;
            }
        }
    }

    public static void bfsTree(BinaryTreeNode root) {
        LinkedList<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryTreeNode node = queue.poll();
            if (node == null) {
                continue;
            }
            System.out.print(node.val + " ");
            queue.add(node.left);
            queue.add(node.right);
        }
    }

}
