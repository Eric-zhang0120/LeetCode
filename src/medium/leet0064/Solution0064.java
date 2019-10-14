package medium.leet0064;

public class Solution0064 {
    public int minPathSum(int[][] grid) {
        if (grid == null) {
            return 0;
        }

        int r = grid.length;
        int c = grid[0].length;
        //dp[i][j]表示到达位置（i， j）的最小路径和
        //因此,dp[i][j]  = min(dp[i-1][j], dp[i][j-1])+grid[i][j]
        int[][] dp = new int[r][c];
        dp[0][0] = grid[0][0];

        //设置第一列，只能通过上一个位置(i-1, 0)到达
        for (int i = 1; i < r; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }

        //设置第一行，只能通过左一个位置(0, j-1)到达
        for (int j = 1; j < c; j++) {
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }

        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }

        return dp[r-1][c-1];
    }
}
