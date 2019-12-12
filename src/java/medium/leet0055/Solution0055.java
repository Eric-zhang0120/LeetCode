package medium.leet0055;

public class Solution0055 {
    public boolean canJump(int[] nums) {
        int lastPos = nums.length-1;
        for (int i = nums.length-1; i >= 0; i--) {
            if (i+nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {3,2,1,0,4};
        int[] nums2 = new int[] {9, 4, 2, 1, 0, 2, 0};
        System.out.println(new Solution0055().canJump(nums));
        System.out.println(new Solution0055().canJump(nums2));
    }
}
