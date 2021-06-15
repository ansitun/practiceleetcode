package easy;

import hard.TrappingRainWater;

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        return nearbyBinarySearch(0, nums.length-1, target, nums);

    }

    public int nearbyBinarySearch(int start, int end, int target, int[] nums) {
        if(end-start == 1 && target > nums[start] && target < nums[end])
            return start+1;

        if(end-start<=0) {
            if(target <= nums[start])
                return start;
            else
                return end+1;
        }

        int mid = (start+end)/2;

        if(nums[mid] == target)
            return mid;

        if(nums[mid] > target)
            return nearbyBinarySearch(start, mid-1, target, nums);
        else
            return nearbyBinarySearch(mid+1, end, target, nums);
    }
    public static void main(String[] args) {
        SearchInsertPosition s = new SearchInsertPosition();
        System.out.println(s.searchInsert(new int[]{1,3,5,6}, 5));
    }
}
