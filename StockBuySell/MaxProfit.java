// LeetCode

class MaxProfit {
    public int maxProfit(int[] prices) {
        int prof = 0; 
        int buy=prices[prices.length -1]; 
        int sell=prices[prices.length -1];
        for(int i=prices.length-1;i>=0;i--) {
       
            if(sell - prices[i] >= prof){
                prof = sell - prices[i];
                buy = prices[i];
            }
            else if(sell - prices[i] < 0 ){
                sell = prices[i];
            }

        }
        return prof;
    }
}