package leetcode.linkedlist;

public class Solution61 {
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode end = dummy;
        int nodeNums = 0;
        for (ListNode p = head; p != null; p = p.next) {
            end = end.next;
            nodeNums++;
        }
        int step = k % nodeNums;
        if (step == 0) {
            return head;
        }

        ListNode cur = dummy;
        for (int i = 0; i < nodeNums - step; i++) {
            cur = cur.next;
        }
        ListNode after = cur.next;
        cur.next = null;
        end.next = dummy.next;

        return after;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        ListNode listNode = rotateRight(l1, 3);
        for (ListNode p = listNode; p != null; p = p.next) {
            System.out.print(p.data + " ");
        }
    }
}
