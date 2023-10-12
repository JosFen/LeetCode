
// class Solution {
//     public int minKBitFlips(int[] nums, int k) {
//         int ct = 0;

//         for (int i = 0; i < nums.length; i++) {
//             if (nums[i] == 1) continue;
//             if (i+k > nums.length) return -1;

//             for (int j = 0; j < k; j++) {
//                 nums[i+j] ^= 1;
//             }
//             ct++;
//         }

//         return ct;
//     }
// }

class Solution{
    public int minKBitFlips(int[] A, int K) {
        int n = A.length;
        Queue<Integer> fq = new LinkedList<>();
        int res = 0;
        
        for(int i=0; i<n; i++) {
            if ((A[i] == 0 && fq.size()%2 == 0) || (A[i]==1 && fq.size()%2 == 1)) {
                res++;
                if (i+K > n) return -1;
                fq.add(i+K-1);
            } //fi
            if (fq.size() > 0 && fq.peek() == i) {
                fq.remove();
            }
        }//for
        return res;
    }
}
