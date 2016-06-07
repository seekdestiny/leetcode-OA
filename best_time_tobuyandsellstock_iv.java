class Solution {
    /**
     * @param k: An integer
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int k, int[] prices) {
        // write your code here
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        
        //if the most transation times is less than k times
        if (k * 2 >= prices.length) {
            int maxP = 0;
            for (int i = 1; i < prices.length; i++) {
                maxP += Math.max(0, prices[i] - prices[i - 1]);
            }
            return maxP;
        }
        
        //k transactions can be completed
        int[][] max = new int[prices.length][k + 1];
        
        for (int j = 1; j <= k; j++) {
            /*in jth stock buy if we purchase at some price before ith stock 
              max money is left in our hands*/
            int maxLeftMoneyWithUnsoldStock = -prices[0];
            
            for (int i = 1; i < prices.length; i++) {
                max[i][j] = Math.max(max[i - 1][j], maxLeftMoneyWithUnsoldStock + prices[i]);
                maxLeftMoneyWithUnsoldStock = Math.max(maxLeftMoneyWithUnsoldStock, max[i - 1][j - 1] - prices[i]);
            }
        }
        
        return max[prices.length - 1][k];
    }
};
