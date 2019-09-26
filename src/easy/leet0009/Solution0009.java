package easy.leet0009;

public class Solution0009 {
    public boolean isPalindrome(int x) {
        //如果x<0，没有数字与‘-’号匹配
        //如果x!=0，但是最后一位为0，最高位数字不与末尾数字相同
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        //反转整数的一半长度
        //当反转数字大于或等于原数字时，反转已经变化了一半
        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        //x为偶数数位时，直接比较是否相等
        //x为奇数数位时，先对去除中心数字，再比较（例如x=12321，反转后x=12，revertedNumber=123）
        return revertedNumber == x || revertedNumber/10 == x;
    }

    public static void main(String[] args) {
        int x = 12321;
        System.out.println(new Solution0009().isPalindrome(x));
    }

}
