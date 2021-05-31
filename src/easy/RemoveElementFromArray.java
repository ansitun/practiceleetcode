package easy;

public class RemoveElementFromArray {
    public int removeElement(int[] nums, int val) {
        if(nums.length == 0) return 0;

        int i=nums.length-1;

        for(int j=0; j<=i; j++) {

            while(i >=0 && nums[i] == val) i--;
            if(i < 0 ) break;

            // swap
            if(i>j && nums[j] == val) {
                int s = nums[j];
                nums[j] = nums[i];
                nums[i] = s;
                i--;
            }
        }

        return i+1;
    }
    public static void main(String[] args) {
        RemoveElementFromArray r = new RemoveElementFromArray();
        System.out.println(r.removeElement(new int[]{1,2,2,3,1}, 1));
    }
}
