package leet0070;

public class Solution0070 {

    /**
     * 求兔子从第一个台阶跳到第n个台阶的方法总数
     *
     * @param n 台阶数
     * @return 兔子到达第n个台阶的总方法数
     */
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        //dp[i]表示兔子到达第i个台阶的方法数
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < dp.length; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {

    }
}
