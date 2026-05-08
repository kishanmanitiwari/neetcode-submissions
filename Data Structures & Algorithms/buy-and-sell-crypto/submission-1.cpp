class Solution {
   public:
    int maxProfit(vector<int>& prices) {
        int minBuy = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.size(); i++) {
            minBuy = min(prices[i], minBuy);
            profit = max(profit, prices[i] - minBuy);
        }

        return profit;
    }
};
