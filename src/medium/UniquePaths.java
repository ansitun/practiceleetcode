package medium;
import easy.Atoi;

import java.util.*;

public class UniquePaths {

    public int uniquePaths(int m, int n) {
        if(m==1 && n==1)
            return 1;

        if (m<=0 || n<=0)
            return 0;

        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        return uniquePathsHelper(m-1, n-1, dp);
    }

    public int uniquePathsHelper(int m, int n, int[][] dp) {
        if(m==0 && n==0) {
            return 1;
        }

        if (m<0 || n<0)
            return 0;

        if(m >0 && dp[m-1][n] > 0)
            dp[m][n] = dp[m-1][n] + uniquePathsHelper(m, n-1, dp);
        else if(n>0 && dp[m][n-1] > 0)
            dp[m][n] = uniquePathsHelper(m-1, n, dp) + dp[m][n-1];
        else
            dp[m][n] = uniquePathsHelper(m-1, n, dp) + uniquePathsHelper(m, n-1, dp);

        return dp[m][n];
    }

    public static void main(String[] args) {
        UniquePaths u = new UniquePaths();
        System.out.println(u.uniquePaths(51,9));
    }

}
