package StockBuySell;

// LeetCode
/* https://www.geeksforgeeks.org/maximum-difference-between-two-elements/ - Other approaches. 
Difficulty Level : Easy
Traverse either from left or from right. 
*/
//Traverse from the back of the array.
// class MaxProfit {
//     public int maxProfit(int[] prices) {
//         int prof = 0; 
//         int buy =prices[prices.length -1]; 
//         int sell=prices[prices.length -1];

//         for(int i=prices.length-1;i>=0;i--) {
       
//             if(sell - prices[i] >= prof){
//                 prof = sell - prices[i];
//                 buy = prices[i];
//             }
//             else if(sell < prices[i]){
//                 sell = prices[i];
//                 buy = prices[i];
//             }

//         }
//         System.out.println("Buying price is "+buy+" and selling price is "+sell);
//         return prof;
//     }
// }

class MaxProfit {
    public int maxProfit(int[] prices) {
        int max_prof = Integer.MIN_VALUE;
        int buy = 0,sell = 0;

        while(sell < prices.length ) {
            
            // optimization step.
            int buy_at=prices[buy], sell_at=prices[sell];

            if(buy_at > sell_at) buy++;
            else if(buy_at <= sell_at){
                int prof = sell_at-buy_at;
                if(prof > max_prof) max_prof = prof; //save indices if asked.
                sell++;
            }
        }

        return max_prof;
    }
}

/*
Difficulty Level : Hard |
Maximum profit by buying and selling a share at most twice | 
Using two lists to traverse from right to left and then left to right.
https://www.geeksforgeeks.org/maximum-profit-by-buying-and-selling-a-share-at-most-twice/
*/

