package easy.leet0557;

import java.util.Scanner;

public class Solution0557 {
    public String reverseWords(String s) {
        String[] str = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();

        for (String tmpStr : str) {
            char[] chars = tmpStr.toCharArray();
            for (int i = chars.length - 1; i >= 0; i--) {
                sb.append(chars[i]);
            }
            sb.append(' ');
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine().trim();
        System.out.println(new Solution0557().reverseWords(s));
    }
}
