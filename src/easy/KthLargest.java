package easy;

import java.util.*;

public class KthLargest {
    PriorityQueue<Integer> pq;
    int maxSize;

    public KthLargest(int k, int[] nums) {
        maxSize = k;
        pq = new PriorityQueue<>(k);
        for(int i: nums)
            add(i);
    }

    public int add(int val) {
        pq.add(val);

        if (pq.size() > maxSize) {
            pq.poll();
        }

        return pq.peek();
    }

    public static void main(String[] args) {
        KthLargest obj = new KthLargest(4, new int[]{1,4,6,4});
        int param_1 = obj.add(3);

        System.out.println(param_1);
    }
}
