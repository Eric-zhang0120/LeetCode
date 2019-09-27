package medium.leet0016;

import java.util.Arrays;

public class Solution0016 {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return Integer.MIN_VALUE;
        }
        int res =  Integer.MAX_VALUE;
        int len = nums.length;
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            int l = i+1, r = len - 1;
            int rangeMin = nums[i] + nums[l] + nums[l+1];
            int rangeMax = nums[i] + nums[r] + nums[r-1];
            if (target < rangeMin) {
                if (rangeMin - target < min) {
                    min = rangeMin - target;
                    res = rangeMin;
                }
            } else if (target > rangeMax) {
                if (target - rangeMax < min) {
                    min = target - rangeMax;
                    res = rangeMax;
                }
            } else {
                while (l < r) {
                    int sum = nums[i] + nums[l] + nums[r];
                    int tmp = target - sum;
                    if (Math.abs(tmp) < min) {
                        min = tmp;
                        res = sum;
                    }

                    if (tmp == 0) {
                        return sum;
                    } else if (tmp > 0) {
                        l++;
                    } else {
                        r--;
                    }
                }
            }
        }
        return res;
    }
}
