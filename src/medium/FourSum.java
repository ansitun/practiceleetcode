package medium;

import easy.RomanToString;

import java.util.*;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        int start, end;
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        HashSet<String> set = new HashSet<>();

        for(int i=0; i<nums.length-1; i++) {
            for(int j=i+1; j<nums.length; j++) {
                start = j+1;
                end = nums.length-1;
                while(start < end) {
                    int sum = nums[j] + nums[start] + nums[end] + nums[i];
                    String str = nums[i] +"-"+nums[j]+"-"+nums[start]+"-"+nums[end];
                    if (sum == target && !set.contains(str)) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[start], nums[end]));
                        start++;
                        end--;
                        set.add(str);
                    }
                    else if(sum > target)
                        end--;
                    else
                        start++;
                }

            }
        }

        return result;
    }

    public static void main(String[] args) {
        FourSum f = new FourSum();
        System.out.println(f.fourSum(new int[]{1,0,-1,0,-2,2}, 0));
    }
}
