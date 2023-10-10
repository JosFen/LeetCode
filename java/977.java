class Solution {
    public int[] sortedSquares(int[] nums) {
        int len = nums.length;
        int lp = 0;
        int rp = len - 1;

        int[] ssArr = new int[len];

        for (int i = len - 1 ; i >= 0 ; i--) {
            int ls = nums[lp] * nums[lp];
            int rs = nums[rp] * nums[rp];
            if (ls >= rs) {
                ssArr[i] = ls;
                lp++;
            } else {
                ssArr[i] = rs;
                rp--;
            }
        }
        return ssAr;
    }
}
