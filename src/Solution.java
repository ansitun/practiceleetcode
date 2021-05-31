import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution2 {
    public int longestSubstring(String s, int k) {

        return helper(0, s.length(), s, k);
    }

    public int helper(int start, int end, String str, int k) {
        if(end-start < k) return 0;

        int[] arr = new int[26];

        for(int i=start; i<end; i++) {
            arr[str.charAt(i) - 'a']++;
        }

        boolean flag = false;
        for (int j : arr) {
            if (j < k) {
                flag = true;
                break;
            }
        }

        if (!flag) return end-start;

        for(int i=start; i<end; i++) {
            if (arr[str.charAt(i)-'a'] < k && arr[str.charAt(i)-'a'] > 0) {
                int left = helper(start, i, str, k);
                int right = helper(i+1, end, str, k);
                return Math.max(left, right);
            }
        }

        return end - start;
    }

    public static void main(String args[]) {
        Solution2 s2 = new Solution2();
        System.out.println(s2.longestSubstring("ababbc", 2));
    }
}