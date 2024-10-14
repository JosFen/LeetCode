class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0, minPrice = prices[0];
        for (int p : prices) {
            minPrice = Math.min(minPrice, p);
            maxProfit = Math.max(maxProfit, p-minPrice);
            
            // System.out.println("min, max:" + minPrice + " " + maxProfit);
        }

        return maxProfit; 
    }
}
