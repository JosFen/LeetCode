// Fisher–Yates shuffle
// Time/Space complexity: O(n)
import java.util.Random;

class Solution {

    private int[] original;
    private int[] shuffled;
    private Random rand;

    public Solution(int[] nums) {
        this.original = nums;
        // this.shuffled = Arrays.copyOf(nums, nums.length);
        this.shuffled = nums.clone();
        rand = new Random();
    }
    
    public int[] reset() {
        return this.original;
    }
    
    public int[] shuffle() {
        int len = this.shuffled.length;
        for (int i = len - 1; i > 0; i--) {
            int j = rand.nextInt(i+1);
            swapPos(this.shuffled, i, j);
        }
        return this.shuffled;
    }
    private void swapPos(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
