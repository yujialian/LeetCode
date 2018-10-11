//122. Best Time to Buy and Sell Stock II
/* Brutal force, O(n^n), space O(n).*/
class Solution {
    public int maxProfit(int[] prices) {
        return calculate(prices, 0);
    }
    private int calculate(int[] prices, int s) {
        int m = 0;
        for(int i = s; i < prices.length; i++) {
            int maxProfit = 0;
            for(int j = i + 1; j < prices.length; j++) {
                if(prices[j] - prices[i] > 0) {
                    int currProfit = prices[j] - prices[i] + calculate(prices, j + 1);
                    if(currProfit > maxProfit) maxProfit = currProfit;
                }
            }
            m = Math.max(m, maxProfit);
        }
        return m;
    }
}
class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        int max = 0;
        int i = 0;
        int valley = prices[0];
        int peak = prices[0];
        while(i < prices.length - 1) {
            while(i < prices.length - 1 && prices[i] >= prices[i + 1]) i++;
            valley = prices[i];
            while(i < prices.length - 1 && prices[i] <= prices[i + 1]) i++;
            peak = prices[i];
            max += peak - valley;
        }
        return max;
    }
}
