// class Solution {
//     public int[] maxSlidingWindow(int[] nums, int k) {
//         if (nums.length == 1 || k == 1) return nums;

//         int[] maxNums = new int[nums.length - k + 1];
//         Deque<Integer> q = new ArrayDeque<>();
        
//         for (int r = 0; r < nums.length; r++) {
//             while (!q.isEmpty() && nums[r] > q.peekLast()){
//                 q.removeLast();
//             }
//             q.addLast(nums[r]);

//             if (r >= k && q.peekFirst() == nums[r-k]) q.removeFirst();

//             if (r + 1 >= k){
//                 maxNums[r-k+1] = q.peekFirst();
//             }            
//         }

//         return maxNums;
//     }
// }


class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int N = nums.length;
        int[] res = new int[N - k + 1];
        int[] left = new int[N];
        int[] right = new int[N];
        
        for (int i = 0; i < N; i += k) {
            int max = Integer.MIN_VALUE;
            int rightBound = Math.min(i + k - 1, N - 1);
            // from left to right --> 
            for (int j = i; j <= rightBound; j++) {
                if (nums[j] > max) 
                    max = nums[j];
                left[j] = max;
            }
            // from right to left <--
            max = Integer.MIN_VALUE;
            for (int j = rightBound; j >= i; j--) {
                if (nums[j] > max)
                    max = nums[j];
                right[j] = max;
            }
        }
        for (int i = 0; i < N - k + 1; i++) {
            int j = i + k - 1;
            // left[j] represents the largest of the right part of the sliding window
            // right[i] represents the largest of the left part of the sliding window
            res[i] = Math.max(right[i], left[j]); 
        }
        return res;
    }
}
