package medium.leet0011;

import java.util.Scanner;

public class Solution0011 {
    public int maxArea(int[] height) {
        int maxarea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r])*(r - l));
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxarea;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] split = s.split(" ");
        int[] height = new int[split.length];
        for (int i = 0; i < height.length; i++) {
            height[i] = Integer.parseInt(split[i]);
        }

        System.out.println(new Solution0011().maxArea(height));
    }
}
