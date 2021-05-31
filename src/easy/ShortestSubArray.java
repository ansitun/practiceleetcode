package easy;

import medium.RottenOranges;

import java.util.*;

public class ShortestSubArray {
    public int findShortestSubArray(int[] nums) {

        HashMap<Integer, Integer[]> map = new HashMap<>();
        int maxKey = 0, minLen = 0;

        for(int i=0; i<nums.length; i++) {

            if(map.containsKey(nums[i])) {
                Integer[] val = map.get(nums[i]);
                map.put(nums[i], new Integer[]{val[0]+1, val[1], i});

                Integer[] max = map.get(nums[maxKey]);
                if(max[0] < val[0]+1) {
                    maxKey = i;
                } else if(max[0] == val[0]+1) {
                    if(max[2]-max[1] > i-val[1]) maxKey = i;
                }

            } else {
                map.put(nums[i], new Integer[]{1, i, i});
            }
        }

        Integer[] val = map.get(nums[maxKey]);
        return val[2] - val[1] + 1;
    }
    public static void main(String[] args) {
        ShortestSubArray s = new ShortestSubArray();
        System.out.println(s.findShortestSubArray(new int[]{1,2,2,3,1}));
    }
}
