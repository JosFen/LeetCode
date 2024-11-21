// Fisher–Yates shuffle
// Time/Space complexity: O(n)
import java.util.Random;

class Solution {

    private int[] original;
    private Random rand;

    public Solution(int[] nums) {
        this.original = nums;
        rand = new Random();
    }
    
    public int[] reset() {
        return this.original;
    }
    
    public int[] shuffle() {
        int len = this.original.length;
        // int[] shuffled = Arrays.copyOf(this.original, len);
        int[] shuffled = this.original.clone();
        for (int i = len - 1; i > 0; i--) {
            int j = rand.nextInt(i+1);
            swapPos(shuffled, i, j);
        }
        return shuffled;
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
