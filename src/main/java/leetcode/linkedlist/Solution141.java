package leetcode.linkedlist;

public class Solution141 {

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode p = head;
        ListNode q = head.next;
        while(p != q) {
            if (q == null || q.next == null) {
                return false;
            }
            p = p.next;
            q = q.next.next;
        }
        return true;
    }
}
