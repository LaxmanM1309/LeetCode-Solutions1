class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int current_price = Integer.MIN_VALUE;
        int profit = 0;
        int n = prices.length;

        for(int i=0; i<n-1 ; i++)
        {
            if(prices[i] < min) min = prices[i];
            current_price = prices[i+1];
            int temp  = current_price - min;
            if(profit <= temp) profit = temp;
        }
        if(profit<0)    return 0;
        return profit;
    }
}