class Solution {
    public int trap(int[] height) {
        if (height == null || height.length <= 1) return 0;

        int leftMax = 0, rightMax = 0;
        int l = 0, r = height.length - 1;
        int water = 0;

        while (l < r) {
            leftMax = Math.max(leftMax, height[l]);
            rightMax = Math.max(rightMax, height[r]);
            
            if (leftMax > rightMax) water += (rightMax - height[r--]);
            else water += (leftMax - height[l++]);

        }
        return water;
    }
}
