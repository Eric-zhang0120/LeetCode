package medium.leet0005;

public class Solution0005 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            //查找两次是为了避免abcdddcbe，len1=7,len2=2
            //回文子串长度为奇数时
            int len1 = expendAroundCenter(s, i, i);
            //回文子串长度为偶数时
            int len2 = expendAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);

            //计算回文子串在原串的索引
            if (len > end - start) {
                //这里len-1是为了避免i-len/2时前移了一个单位
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private int expendAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        //这里-1是为了避免left--和right++操作之后，left和right都比实际位置偏移了一个单位
        return right - left - 1;
    }

    public static void main(String[] args) {
        //String s = "abcdddcbe";
        String s = "aa";
        System.out.println(new Solution0005().longestPalindrome(s));
    }
}
