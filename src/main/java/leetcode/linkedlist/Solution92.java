package leetcode.linkedlist;

public class Solution92 {
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null || left == right) {
            return head;
        }

        ListNode pre = new ListNode(0, head);
        for (int i = 1; i < left; i++) {
            pre = pre.next;
        }
        ListNode end = pre.next;
        for (int i = left; i < right; i++) {
            end = end.next;
        }
        ListNode after = end.next;
        end.next = null;
        ListNode[] reverse = reverse(pre.next, end);
        pre.next = reverse[0];
        reverse[1].next = after;
        if (left == 1) {
            return pre.next;
        }else{
            return head;
        }
    }

    public static ListNode[] reverse(ListNode begin, ListNode end) {
        ListNode pre = null;
        ListNode cur = begin;
        ListNode after;
        while (cur != null) {
            after = cur.next;
            cur.next = pre;
            pre = cur;
            cur = after;
        }
        return new ListNode[]{end, begin};
    }

    public static void main(String[] args) {
        /*ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;*/
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l1.next = l2;

        ListNode listNode = reverseBetween(l1, 1, 2);
        for (ListNode p = listNode; p != null; p = p.next) {
            System.out.print(p.data + " ");
        }
    }
}
