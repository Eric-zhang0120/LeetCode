package leet0301;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution0301 {
    private Set<String> res = new HashSet<>();

    /**
     * 移除无效的括号
     *
     * @param s 原字符串
     * @return 移除的可能结果
     */
    public List<String> removeInvalidParentheses(String s) {
        int left = 0;
        int right = 0;

        //遍历整个字符串，记录未匹配的左右括号数
        for (char c : s.toCharArray()) {
            if (c == '(') {
                left++;
            }

            else if (c == ')') {
                if (left > 0) {
                    left--;
                } else {
                    right++;
                }
            }
        }

        //使用深度优先遍历算法，计算所有可能的结果
        dfs(s, 0, left, right);
        return new ArrayList<>(res);
    }

    /**
     * 验证字符串中括号是否非法
     *
     * @param s
     * @return true 该字符串的左右括号完全匹配
     */
    private boolean isValid(String s) {
        //cnt记录字符串中未匹配的括号数
        int cnt = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                cnt++;
            } else if (c == ')') {
                cnt--;
            }

            //右括号数量多于左括号，提前终止循环
            if (cnt < 0) {
                return false;
            }
        }
        return cnt == 0;
    }

    /**
     * 深度优先遍历，删除重复的括号
     *
     * @param s     输入字符串
     * @param start 遍历初始位置
     * @param l     未匹配的左括号数
     * @param r     未匹配的右括号数
     */
    private void dfs(String s, int start, int l, int r) {
        if (l == 0 && r == 0) {
            if (isValid(s)) {
                res.add(s);
            }
            return;
        }

        for (int i = start; i < s.length(); i++) {
            //去重
            if (i - 1 >= start && s.charAt(i-1) == s.charAt(i)) {
                continue;
            }

            String subStr = s.substring(0, i) + s.substring(i+1);
            if (l > 0 && s.charAt(i) == '(') {
                dfs(subStr, i, l-1, r);
            }
            if (r > 0 && s.charAt(i) == ')') {
                dfs(subStr, i, l, r-1);
            }
        }
    }

    public static void main(String[] args) {
        String s = "()())()";
        System.out.println(new Solution0301().removeInvalidParentheses(s));
    }
}
