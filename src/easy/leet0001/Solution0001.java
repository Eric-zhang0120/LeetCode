package easy.leet0001;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Solution0001 {
    /**
     * 两个数相加，得到目标和
     *
     * @param nums 加数数组
     * @param target 目标和
     * @return 两数的索引
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        //使用map记录(key--数组中的数值，val--数组中对应数值的索引)
        for (int i = 0; i < nums.length; i++) {
            int tmp = target - nums[i];
            //当要求的加数出现在map中，读取其val即可得到索引，加上当前索引组成两个加数
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
        System.out.println(Arrays.toString(new Solution0001().twoSum(nums, target)));
    }
}
