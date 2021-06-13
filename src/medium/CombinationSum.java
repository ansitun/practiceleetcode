package medium;

import java.util.*;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        combinationSumHelper(result, target, nums, 0, new ArrayList<>());
        return result;
    }

    public void combinationSumHelper(List<List<Integer>> result, int target, int[] nums, int index, List<Integer> temp) {

        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }

        if (index == nums.length || target < nums[index] ) {
            return;
        }
        for(int i=index; i< nums.length; i++) {
            temp.add(nums[i]);
            combinationSumHelper(result, target-nums[i], nums, i, temp);
            temp.remove(temp.size()-1);
        }

    }

    public static void main(String[] args) {
        CombinationSum c = new CombinationSum();
        System.out.println(c.combinationSum(new int[]{2,3,6,7}, 7));
    }
}
