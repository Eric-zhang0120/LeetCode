package medium.leet0015;

import java.util.*;

public class Solution0015 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);
        //在nums[i]的右边寻找两个数，与nums[i]之和为0
        for (int i = 0; i < nums.length; i++) {
            // 当nums[i]>0时，其右边的数全部大于0，则三数之和肯定大于0
            if (nums[i] > 0) {
                break;
            }
            //去重
            if (i>0 && nums[i] == nums[i-1]) {
                continue;
            }
            int l = i+1;
            int r = nums.length - 1;
            //采用双指针查找nums[i]右边的元素
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    //去重
                    while (nums[l] == nums[l + 1]) {
                        l++;
                    }
                    while (nums[r] == nums[r - 1]) {
                        r--;
                    }
                    l++;
                    r--;
                } else if (sum < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {-1, 0, 1, 2, -1, -4};
        System.out.println(new Solution0015().threeSum(nums));
    }
}
