package easy.leet0014;

public class Solution0014 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            //当strs[i]的前缀不是当前的prefix时，需要改变前缀
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length()-1);
                if (prefix.length() == 0) {
                    return "";
                }
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        String s1 = "flower";
        String s2 = "flight";
        System.out.println(s2.indexOf(s1));
    }
}
