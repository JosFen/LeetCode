// Time/Space: O(n + queries.length):

class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        boolean[] answer = new boolean[queries.length];
        int[] paritySum = new int[nums.length];
        paritySum[0] = 0; // the first number always has different parity with its previous number (null)

        for (int i = 1; i < nums.length; i++) {
            paritySum[i] = (nums[i] % 2 == nums[i-1] % 2) ? (paritySum[i-1] + 1) : paritySum[i-1];
        }

        for (int j = 0; j < queries.length; j++) {
            int from = queries[j][0];
            int to = queries[j][1];
            answer[j] = (paritySum[from] == paritySum[to]);
        }

        return answer;
    }
}

// Brute Force:
// class Solution {
//     public boolean[] isArraySpecial(int[] nums, int[][] queries) {
//         boolean[] answer = new boolean[queries.length];
//         for (int i = 0; i < queries.length; i++) {
//             int j = queries[i][0];
//             int k = queries[i][1];

//             while (j < k) {
//                 if ( (nums[j] + nums[j+1]) % 2 == 0 ) {
//                     answer[i] = false;
//                     break;
//                 }
//                 j++;
//             }
//             if (j == k) answer[i] = true;
//         }
//         return answer;
//     }
// }
