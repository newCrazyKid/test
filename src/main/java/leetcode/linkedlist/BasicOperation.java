package leetcode.linkedlist;

public class BasicOperation {
    /**
     * 链表递归前序遍历
     *
     * @param listNode
     */
    public static void preOrder(ListNode listNode) {
        if (listNode == null) {
            System.out.println();
            return;
        }
        System.out.print(listNode.data + " ");
        preOrder(listNode.next);
    }

    /**
     * 插入
     *
     * @param head 原始链表头节点
     * @param index 从第几个节点后插入，从1开始
     * @param listNode 待插入的节点
     */
    public static void insert(ListNode head, int index, ListNode listNode) {
        int i = 0;
        ListNode p = head;
        // 寻找要插入节点位置的前驱节点
        while (p != null) {
            if (++i == index) {
                break;
            }
            p = p.next;
        }

        // 在p之后插入
        /*listNode.next = p.next;
        p.next = listNode;*/
        ListNode tmp = p.next;
        p.next = listNode;
        listNode.next = tmp;
    }

    public static ListNode[] reverse(ListNode head, ListNode tail) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            // 反转
            ListNode tmp = cur.next;
            cur.next = pre;
            // 移动
            pre = cur;
            cur = tmp;
        }
        return new ListNode[] {tail, head};
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode tail = new ListNode(3);
        head.next = listNode2;
        listNode2.next = tail;
        preOrder(head);
        ListNode listNode4 = new ListNode(4);
        insert(head, 1, listNode4);
        preOrder(head);
        reverse(head, tail);
        preOrder(tail);
    }
}

class ListNode {
    int data;
    ListNode next;

    public ListNode(int data, ListNode next) {
        this.data = data;
        this.next = next;
    }

    public ListNode(int data) {
        this.data = data;
    }

    public ListNode() {

    }
}