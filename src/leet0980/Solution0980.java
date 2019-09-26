package leet0980;

public class Solution0980 {
    int ans = 0;
    int[][] grid;
    int tr, tc;
    /**
    * dr[i]+dc[i]表示下一步的方向（上下左右）
    **/
    int[] dr = new int[]{0, -1, 0, 1};
    int[] dc = new int[]{1, 0, -1, 0};
    int row, col;

    public int uniquePathsIII(int[][] grid) {
        this.grid = grid;
        row = grid.length;
        col = grid[0].length;

        //cnt记录可以通过的位置数量总和
        int cnt = 0;
        //(sr, sc)为起点坐标
        int sr = 0, sc = 0;
        //遍历所有路径，记录起点和终点位置，以及所有可以通过的坐标数量
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] != -1) {
                    cnt++;
                }

                if (grid[i][j] == 1) {
                    sr = i;
                    sc = j;
                } else if (grid[i][j] == 2) {
                    tr = i;
                    tc = j;
                }
            }
        }

        dfs(sr, sc, cnt);
        return ans;
    }

    /**
     * 采用回溯算法，寻找所有可能的轨迹
     * 先尝试每一个0的方格，并在走过的方格里留下一个障碍。回溯的时候，再删除这些障碍
     *
     * @param r   当前位置横坐标
     * @param c   当前位置的纵坐标
     * @param cnt 非障碍物点数量
     */
    private void dfs(int r, int c, int cnt) {
        cnt--;
        //避免重复遍历完路径
        if (cnt < 0 ) {
            return;
        }
        //达到终点
        if (r == tr && c == tc) {
            //走完所有能走的点
            if (cnt == 0) {
                ans++;
            }
            return;
        }
        //先标记当前点为走过的点
        grid[r][c] = 3;
        //选择下一步方向
        for (int i = 0; i < 4; i++) {
            //（nr, nc）为下一个点的位置
            int nr = r + dr[i];
            int nc = c + dc[i];
            //防止路径越界
            if (nr >= 0 && nr < row && nc >= 0 && nc < col) {
                //grid[nr][nc]%2 == 0只有在未通过点（值为0）和终点时成立
                //下一个点为无障碍物点
                if (grid[nr][nc] % 2 == 0) {
                    dfs(nr, nc, cnt);
                }
            }
        }
        //清除当前标记
        grid[r][c] = 0;
    }
}
