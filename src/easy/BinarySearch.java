package easy;

public class BinarySearch {

    public int search(int[] nums, int target) {

        return binarySearch(nums, 0, nums.length-1, target);
    }

    public int binarySearch(int[] nums, int low, int high, int target) {
        if(low > high || low < 0 || high == nums.length)
            return -1;

        int mid = (high+low)/2;

        if(nums[mid] == target)
            return mid;
        else if(nums[mid] > target)
            return binarySearch(nums, low, mid-1, target);
        else
            return binarySearch(nums, mid+1, high, target);

    }

    public static void main(String[] args) {
        BinarySearch b = new BinarySearch();
        System.out.println(b.search(new int[]{1,2,2,3,1}, 1));
    }
}
