package easy.leet0053;

public class Solution0053 {
    public int maxSubArray(int[] nums) {
        int sum = 0, ans = Integer.MIN_VALUE;
        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            ans = Math.max(ans, sum);
        }

        return ans;
    }
}
