class Solution {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int maxArea = 0; 

        while (l < r) {
            maxArea = Math.max(maxArea, (r - l) * (height[l] < height[r] ? height[l++] : height[r--]));
        }
        return maxArea;
    }
}

