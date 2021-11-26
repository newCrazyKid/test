package leetcode.heap;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution347 {
    public static int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(k, (ar1, ar2) -> ar1[1] - ar2[1]);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        /*for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            System.out.println(e.getKey() + "=" + e.getValue());
        }
        System.out.println();*/
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if (minHeap.size() < k) {
                minHeap.offer(new int[]{key, value});
            } else {
                if (value > minHeap.peek()[1]) {
                    minHeap.poll();
                    minHeap.offer(new int[]{key, value});
                }
            }
        }

        for (int i = 0; i < k; i++) {
            res[i] = minHeap.poll()[0];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {4, 1, -1, 2, -1, 2, 3};
        int[] res = topKFrequent2(arr, 2);
        for (int re : res) {
            System.out.println(re);
        }
    }

    public static int[] topKFrequent2(int[] nums, int k) {
        int[] res = new int[k];
        HashMap<Integer, Integer> sortMap = new HashMap<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // 使用java8的stream对map的value排序
        List<Map.Entry<Integer, Integer>> sortedEntrys = map.entrySet().parallelStream()
                .sorted((v1, v2) -> Integer.compare(v2.getValue(), v1.getValue()))
                .collect(Collectors.toList());
        for (int i = 0; i < k; i++) {
            res[i] = sortedEntrys.get(i).getKey();
        }
        return res;
    }

    public int[][] kClosestLeetCode973(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(k, (a1, a2) -> a2[0] - a1[0]);
        for (int i = 0; i < k; i++) {
            maxHeap.offer(new int[]{points[i][0] * points[i][0] + points[i][1] * points[i][1], i});
        }
        for (int i = k; i < points.length; i++) {
            int dist = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            if (dist < maxHeap.peek()[0]) {
                maxHeap.poll();
                maxHeap.offer(new int[]{dist, i});
            }
        }

        int[][] res = new int[k][2];
        int index;
        for (int i = 0; i < k; i++) {
            /*index = maxHeap.poll()[1];
            res[i][0] = points[index][0];
            res[i][1] = points[index][1];*/
            res[i] = points[maxHeap.poll()[1]];
        }
        return res;
    }

    public int[][] kClosestLeetCode973_2(int[][] points, int k) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] point1, int[] point2) {
                return (point1[0] * point1[0] + point1[1] * point1[1]) - (point2[0] * point2[0] + point2[1] * point2[1]);
            }
        });
        return Arrays.copyOfRange(points, 0, k);
    }
}