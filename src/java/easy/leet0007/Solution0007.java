package easy.leet0007;

public class Solution0007 {
    /**
     * 整数反转
     *
     * @param x 待反转整数
     * @return 反转后的整数
     */
    public int reverse(int x) {
        int ans = 0;
        while (x != 0) {
            //求整数的末尾数字
            int tmp = x % 10;
            //删除末尾数字
            x = x / 10;
            //当反转数超过int表示的范围时
            if (ans > Integer.MAX_VALUE/10 ||
                    (ans == Integer.MAX_VALUE/10 && x > 7)) {
                return 0;
            }
            if (ans < Integer.MIN_VALUE/10 ||
                    (ans == Integer.MIN_VALUE/10 && x < -8)) {
                return 0;
            }
            //反转
            ans = ans * 10 + tmp;
        }

        return ans;
    }

    public static void main(String[] args) {
        int x = 12345;
        System.out.println(new Solution0007().reverse(x));
    }
}
