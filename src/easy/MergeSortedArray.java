package easy;

import medium.MergeIntervals;

import java.util.Arrays;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = m-1;
        int j = n-1;
        int k = m+n-1;

        while(i>=0 && j>=0) {
            if(nums1[i] >= nums2[j]) {
                nums1[k] = nums1[i];
                k--;
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
                k--;
            }
        }

        while(j>=0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }

        return;
    }

    public static void main(String[] args) {
        MergeSortedArray merge = new MergeSortedArray();
        int[] n = new int[]{0};
        int[] m = new int[]{1};

        merge.merge(n, 0, m, 1);
        System.out.println(Arrays.toString(n));
    }
}
