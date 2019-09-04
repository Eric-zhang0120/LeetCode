package leet0001;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int tmp = target - nums[i];
            if (map.containsKey(tmp)) {
                return new int[]{map.get(tmp), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No such two num");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(new Solution().twoSum(nums, target)));
    }
}
