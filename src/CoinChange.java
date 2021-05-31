import java.util.Arrays;
import java.util.HashMap;

class CoinChange {
    public int coinChange(int[] coins, int amount) {

        int[][] dp = new int[coins.length][amount+1];

        for(int i=0;i<coins.length;i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            //dp[i][0] = 0;
        }

        dp[0][0] = 0;

        int count = helper(dp, amount, 0, coins);
        if (count == Integer.MAX_VALUE)
            return -1;

        return count;
    }

    public int helper(int[][] dp, int amount, int i, int[] coins) {
        if (amount < 0 || i < 0 || i == coins.length) return Integer.MAX_VALUE;
        //if (coins[i] > amount) return 0;

        System.out.println(Arrays.deepToString(dp));

        int left = (dp[i][amount] != Integer.MAX_VALUE) ? dp[i-1][amount] : helper(dp, amount, i-1, coins);
        int right = (dp[i][amount-coins[i]] != Integer.MAX_VALUE) ? dp[i][amount-coins[i]] : 1+helper(dp, amount-coins[i], i, coins);

        System.out.println(left + "---------" + right);
        dp[i][amount] = Math.min(left, right);

        return Math.min(left, right);
    }


    public static void main(String[] args) {
        CoinChange c = new CoinChange();
        //System.out.println(c.coinChange(new int[]{186,419,83,408}, 6249));
        System.out.println(c.coinChange(new int[]{1}, 1));
    }
}