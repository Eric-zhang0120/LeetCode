package leet0010;

import java.util.Scanner;

public class Solution0010 {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }

        char[] chars = s.toCharArray();
        char[] pChar = p.toCharArray();
        int i, j = 0;
        for (i = 0; i < chars.length && j < pChar.length; i++) {

            if (chars[i] == pChar[j] || pChar[j] == '.') {
                j++;
            } else if (pChar[j] == '*') {
                if (pChar[j - 1] == '.') {

                }

                while (i < chars.length && chars[i] == pChar[j-1]) {
                    i++;
                }
                j++;
                i--;
            } else {
                break;
            }
        }

        if (i == chars.length && j == pChar.length) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String p = in.nextLine();
        boolean match = new Solution0010().isMatch(s, p);
        System.out.println(match);
    }
}
