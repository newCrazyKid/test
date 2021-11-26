package leetcode;

import java.math.BigInteger;

/**
 * 链表
 *
 * @author xiejialin
 * @date 2020/12/01
 */
public class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuffer sb1 = new StringBuffer();
        StringBuilder sb2 = new StringBuilder();
        for (ListNode i = l1; i != null ; i = i.next) {
            sb1.append(i.val);
        }
        for (ListNode i = l2; i != null ; i = i.next) {
            sb2.append(i.val);
        }
        BigInteger num1 = new BigInteger(sb1.reverse().toString()).add(new BigInteger(sb2.reverse().toString()));
        StringBuilder resStr = new StringBuilder(String.valueOf(num1)).reverse();
        ListNode head = null;
        ListNode p = null;
        for (int i = 0; i < resStr.length(); i++) {
             int num = resStr.charAt(i) - '0';
             if (i == 0) {
                 head = new ListNode(num);
                 p = head;
             } else {
                 ListNode tmp = new ListNode(num);
                 p.next = tmp;
                 p = p.next;
             }
        }
        return head;
    }



    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        for (ListNode i = l1; i != null ; i = i.next) {
            System.out.println(i.val);
        }
        for (ListNode i = l2; i != null ; i = i.next) {
            System.out.println(i.val);
        }

        System.out.println(new Solution2().addTwoNumbers(l1, l2).val);
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}
