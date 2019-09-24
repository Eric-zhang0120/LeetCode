package leet0007;

public class Solution0007 {
    public int reverse(int x) {
        int ans = 0;
        while (x != 0) {
            int tmp = x % 10;
            x = x / 10;
            if (ans > Integer.MAX_VALUE/10 ||
                    (ans == Integer.MAX_VALUE/10 && x > 7)) {
                return 0;
            }
            if (ans < Integer.MIN_VALUE/10 ||
                    (ans == Integer.MIN_VALUE/10 && x < -8)) {
                return 0;
            }
            ans = ans * 10 + tmp;
        }

        return ans;
    }

    public static void main(String[] args) {
        int x = 12345;
        System.out.println(new Solution0007().reverse(x));
    }
}
