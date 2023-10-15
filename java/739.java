// O(n) form a solution
// examples:  
// 1. incremental array:  [1,2,3,4,5,6,7] , O(n) because temperatures[i] >= temperatures[k], the "while loop" will never be excuted
// 2. decreasing array: [5,4,3,2,1], o(n), because alwasy res[k] == 0, the "while loop" will never be excuted
// 3. mixed array: [20,15,1,2,3,21], we can construct result up to [?, ?, 1, 1, 1, 0] in O(1) time for each index. for 15, we will have to go through each temperature from 1 to 21. Thus it will visit each. result[1] = 4,  For 20, we just have to look at 15 as it will directly jump the pointer k to k + result[k] = 1 + 4 = 5. This will cause the while loop to exit as result[5] is 0 since it's the last temperature in the input array. Thus, we get the result[0] in just two steps, without visiting all temperatures on the right.
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];

        for(int i = n - 2; i >= 0; i--) {
            int k = i + 1;
            while(temperatures[i] >= temperatures[k] && res[k] != 0) { // higher temp after k, otherwise no need to contnue
                k += res[k];  // to find the first k that is greather than temperatures[i]
            }
            if(temperatures[i] < temperatures[k]) {
                res[i] = k - i;
            }
        }
        return res;
    }
}

// 1st Version: Stack to record indices of warmer temperature
// class Solution {
//     public int[] dailyTemperatures(int[] temperatures) {
//         if (temperatures.length == 1) return new int[] {0};

//         int[] result = new int[temperatures.length];
//         Stack<Integer> stack = new Stack<>();  // to record the index of warmer temperature

//         for (int i = temperatures.length - 1; i >= 0; i--) {
//             while (!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]) {
//                 stack.pop(); // remove all colder temperature indices
//             }
//             result[i] = (stack.isEmpty()) ? 0 : stack.peek() - i;
//             stack.push(i);
//         }

//         return result;
//     }
// }
