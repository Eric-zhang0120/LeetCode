package hard.leet0010;

import java.util.Scanner;

enum Result {
    TRUE,
    FALSE
}

public class Solution0010 {
    Result[][] memo;

    public boolean isMatch(String s, String p) {
        memo = new Result[s.length()+1][p.length()+1];
        return dp(0, 0, s, p);
    }

    public boolean dp(int i, int j, String s, String p) {
        if (memo[i][j] != null) {
            return memo[i][j] == Result.TRUE;
        }

        boolean ans;
        if (j == p.length()) {
            ans = i == s.length();
        } else {
            boolean firstMatch = (i < s.length() && (s.charAt(i) == p.charAt(j) ||
                    p.charAt(j) == '.'));
            //当前p字符为'*'时，匹配前一个字符零次（跳过该字符）或者任意次数
            if (j < p.length() - 1 && p.charAt(j + 1) == '*') {
                //dp(i, j+2, s, p)表示跳过字符'*'
                //dp(i+1, j, s, p)表示用前一个字符匹配至少一次
                ans = (dp(i, j + 2, s, p) || firstMatch && dp(i + 1, j, s, p));
            } else {
                //当前p字符不为'*'时，直接匹配该字符
                ans = firstMatch && dp(i + 1, j + 1, s, p);
            }
        }
        memo[i][j] = ans ? Result.TRUE : Result.FALSE;
        return ans;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String p = in.nextLine();
        boolean match = new Solution0010().isMatch(s, p);
        System.out.println(match);
    }
}
