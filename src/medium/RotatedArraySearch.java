package medium;

public class RotatedArraySearch {
    public int search(int[] nums, int target) {

        return binarySearch(nums, target, 0, nums.length-1);

    }

    public int binarySearch(int[] nums, int target, int low, int high) {
        if(low >= high & nums[low] != target) return -1;

        int mid = (high+low)/2;

        if (target == nums[mid]) return mid;

        if (target == nums[low]) return low;

        if (target == nums[high]) return high;

        if ((target < nums[low] && target > nums[high]) && !(nums[low] < nums[mid] && nums[mid] < nums[high])) return -1;

        if(nums[mid] < nums[high])
            if(target > nums[high] || target < nums[mid]) return binarySearch(nums, target, low, mid-1);
            else return binarySearch(nums, target, mid+1, high);

        if(nums[mid] > nums[low])
            if(target < nums[low] || target > nums[mid]) return binarySearch(nums, target, mid+1, high);
            else return binarySearch(nums, target, low, mid-1);

        return -1;
    }

    public static void main(String[] args) {
        RotatedArraySearch r = new RotatedArraySearch();
        System.out.println(r.search(new int[]{4,5,6,7,8,1,2,3}, 8));
    }
}
