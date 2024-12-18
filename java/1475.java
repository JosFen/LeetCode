// Brute Force: Time O(n^2)
class Solution {
    public int[] finalPrices(int[] prices) {
        int[] answer = prices.clone();

        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] <= prices[i]) {
                    answer[i] -= prices[j];
                    break;
                }
            }
        }
        
        return answer;
    }
}


// Time/Space : O(n)
class Solution {
    public int[] finalPrices(int[] prices) {
        int[] answer = prices.clone();
        Deque<Integer> stack = new ArrayDeque<>();

        for (int currIdx = 0; currIdx < prices.length; currIdx++) {
            while ( !stack.isEmpty() && (prices[currIdx] <= prices[stack.peek()]) ) {
                answer[stack.pop()] -= prices[currIdx];
            }
            stack.push(currIdx);
        }
        return answer;
    }
}
