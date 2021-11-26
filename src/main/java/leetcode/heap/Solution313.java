package leetcode.heap;

import java.util.PriorityQueue;

public class Solution313 {
    public static int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        int count = 0;
        long ans = 1;
        minHeap.add(ans);
        while (count < n) {
            ans = minHeap.poll();
            while (!minHeap.isEmpty() && ans == minHeap.peek()) { // 防止重复的值添加进去
                minHeap.poll();
            }
            count++;

            for (int prime : primes) {
                minHeap.offer(ans * prime);
            }
        }

        return (int)ans;
    }

    public static void main(String[] args) {
        System.out.println(nthSuperUglyNumber(12, new int[]{2, 7, 13, 19}));
        int[] arr = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541};
        System.out.println(nthSuperUglyNumber(1000000, arr));
    }
}
