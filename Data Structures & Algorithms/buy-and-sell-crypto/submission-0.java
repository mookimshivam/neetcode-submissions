class Solution {
    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int maxProfit = 0;
        for(int curPrice: prices){
            // based on last min price 
            // find profit if sold current-day
            int profit = curPrice - buy;
            // update max-profit
            maxProfit = Math.max(profit, maxProfit);
            // update min price after comparing to curent-day
            buy = Math.min(buy, curPrice);
        }

        return Math.max(maxProfit, 0);
    }
}
