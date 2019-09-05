package leet0003;

public class Solution0003 {
    /**
     * 返回最长无重复子串
     *
     * @param s
     * @return 返回最长无重复子串的长度
     */
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;

        int max = Integer.MIN_VALUE;
        int[] pChar = new int[256];   //记录字符出现的次数
        int[] index = new int[256];   //记录字符出现的位置
        int l = 0;

        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (++pChar[array[i]] > 1) {
                //字符出现次数大于1，则移动窗口的左边界
                l = index[array[i]]+1 > l ? index[array[i]]+1 : l;
            }
            index[array[i]] = i;
            max = max > i-l+1 ? max : i-l+1;
        }

        return max;
    }

    public static void main(String[] args) {
        String s = " ";
        System.out.println(new Solution0003().lengthOfLongestSubstring(s));
    }
}
