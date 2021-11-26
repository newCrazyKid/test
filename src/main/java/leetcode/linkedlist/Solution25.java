package leetcode.linkedlist;

public class Solution25 {
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;
        ListNode end = dummy;

        while (end != null) {
            for (int i = 0; i < k; i++) {
                end = end.next;
                if (end == null) {
                    return dummy.next;
                }
            }
            ListNode after = end.next;
            end.next = null; //注意翻转子链表前一定要和后面的链表断开，并且保存！！！否则翻转结束后面的链表会丢失
            ListNode[] reverse = reverseLinkedList(pre.next, end);
            pre.next = reverse[0];
            reverse[1].next = after;

            pre = reverse[1]; //pre指向下一段子链表
            end = pre;
        }
        return dummy.next;
    }

    public static ListNode[] reverseLinkedList(ListNode begin, ListNode end) {
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
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
//        ListNode[] reverse = reverseLinkedList(l1, l5);
        ListNode listNode = reverseKGroup(l1, 2);
        for (ListNode p = listNode; p != null; p = p.next) {
            System.out.print(p.data + " ");
        }
    }
}
