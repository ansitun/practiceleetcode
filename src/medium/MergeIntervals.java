package medium;

import java.util.*;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        int[][] result = new int[][]{};
        List<int[]> temp = new ArrayList<>();
        int start, end;
        int[] resultEle;

        PriorityQueue<int[]> pq = new PriorityQueue<>(intervals.length, (a,b) -> a[0]-b[0]);

        for(int i=0; i< intervals.length; i++) {
            pq.add(intervals[i]);
        }

        start = pq.peek()[0];
        end = pq.peek()[1];
        pq.poll();

        while(!pq.isEmpty()) {
            resultEle = pq.peek();
            if(end >= resultEle[0])
                end = Math.max(resultEle[1], end);
            else {
                temp.add(new int[]{start, end});
                start = resultEle[0];
                end = resultEle[1];
            }

            pq.poll();
        }
        temp.add(new int[]{start, end});

        result = temp.toArray(result);

        return result;
    }

    public static void main(String[] args) {
        MergeIntervals m = new MergeIntervals();
        System.out.println(Arrays.deepToString(m.merge(new int[][]{new int[]{1, 4}, new int[]{4, 5}})));
    }
}
