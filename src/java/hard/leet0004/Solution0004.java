package hard.leet0004;

public class Solution0004 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) { //保证m<=n成立
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;

            int lenTmp = m;
            m = n;
            n = lenTmp;
        }

        int iMin = 0, iMax = m;
        int half = (m + n + 1) / 2; //+1是保证m+n为奇数时也成立
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = half -i;
            if (i < iMax && nums2[j-1] > nums1[i]) { //i太小了，增大iMin
                 iMin = i + 1;
            } else if (i > iMin && nums1[i-1] > nums2[j]) { //i太大了，减小iMax
                iMax = i - 1;
            } else { //i刚好满足要求
                int maxLeft;
                if (i == 0) {
                    maxLeft = nums2[j-1];
                } else if (j == 0) {
                    maxLeft = nums1[i-1];
                } else {
                    maxLeft = Math.max(nums1[i-1], nums2[j-1]);
                }

                if ((m + n) % 2 == 1) {
                    return maxLeft;
                }

                int minRight;
                if (i == m) {
                    minRight = nums2[j];
                } else if (j == n) {
                    minRight = nums1[i];
                } else {
                    minRight = Math.min(nums1[i], nums2[j]);
                }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }

    public static void main(String[] args) {
        int[] nums1 = {-1, -2};
        int[] nums2 = {3};

        System.out.println(new Solution0004().findMedianSortedArrays(nums1, nums2));
    }

}
