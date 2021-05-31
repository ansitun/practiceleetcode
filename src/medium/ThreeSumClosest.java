package medium;

import java.util.*;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int sum = 0, start, end, minSum = nums[0]+nums[1]+nums[2], diff = Integer.MAX_VALUE;
        Arrays.sort(nums);

        for(int i=0; i<nums.length; i++) {

            start = i+1;
            end = nums.length-1;

            while(start < end) {
                sum = nums[i] + nums[start] + nums[end];
                if(sum > target) {
                    end--;
                } else if( sum < target) {
                    start++;
                } else {
                    return sum;
                }
                if(Math.abs(sum-target) < diff) {
                    diff = Math.abs(sum-target);
                    minSum = sum;
                }
            }

        }
        return minSum;

    }
    public static void main(String[] args) {
        ThreeSumClosest t = new ThreeSumClosest();
        System.out.println(t.threeSumClosest(new int[]{-1,2,1,-4}, 1));
    }
}
