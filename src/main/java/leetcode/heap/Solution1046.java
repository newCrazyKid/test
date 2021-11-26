package leetcode.heap;

import java.util.PriorityQueue;

public class Solution1046 {
    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(stones.length, (a, b) -> b - a);
        for (int stone : stones) {
            maxHeap.add(stone);
        }
        while (maxHeap.size() >= 2) {
            Integer max1 = maxHeap.poll();
            Integer max2 = maxHeap.poll();
            if (max1.equals(max2)) {
                continue;
            }
            maxHeap.add(max1 - max2);
        }

        if (maxHeap.isEmpty()) {
            return 0;
        } else {
            return maxHeap.poll();
        }
    }

    public static int[] smallestK(int[] arr, int k) {
        if (arr.length == 0) {
            return new int[]{};
        }
        int[] res = new int[k];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, (a, b) -> b - a);
        int len = arr.length;
        for (int i = 0; i < k; i++) {
            maxHeap.add(arr[i]);
        }
        for (int i = k; i < len; i++) {
            if (arr[i] < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.offer(arr[i]);
            }
        }
        for (int i = 0; i < k; i++) {
            res[i] = maxHeap.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] res = smallestK(new int[]{1, 3, 5, 7, 2, 4, 6, 8}, 4);
        for (int re : res) {
            System.out.println(re);
        }
    }
}
