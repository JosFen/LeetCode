class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) return ;

        int end = m + n - 1;
        int e1 = m - 1;
        int e2 = n - 1;

        while (e1 >= 0 && e2 >= 0) {
            nums1[end--] = (nums1[e1] >= nums2[e2]) ? nums1[e1--] : nums2[e2--];
        }

        while (e2 >= 0) {
            nums1[end--] = nums2[e2--];
        }

    }
}
