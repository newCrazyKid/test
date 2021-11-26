package leetcode.binarysearch;

import java.util.Arrays;

public class Solution875 {
    public static int minEatingSpeed(int[] piles, int h) {
        int max = Arrays.stream(piles).max().getAsInt();
        for (int i = 1; i <= max; i++) {
            int sum = 0;
            for (int j = 0; j < piles.length; j++) {
                sum += Math.ceil(piles[j] / (double)i);
            }
            if (sum <= h) {
                return i;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        System.out.println(minEatingSpeed(new int[]{30,11,23,4,20}, 5));
    }
}
