package LeetCode;


//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
public class BuyAndSell {

    //normal (O(N^2)) --too long
    //Successive comparison and maintenance of Min Buy and Max Sell values
    public int maxProfit(int[] prices) {

        int maxProfit = 0;
        int currentProfit = 0;
        for(int i = 0;i< (prices.length-1);i++)
        {
            for(int j = i+1;j< prices.length;j++)
            {
                int buy = prices[i];
                int sell = prices[j];
                currentProfit = sell-buy;
                if(currentProfit>maxProfit)
                    maxProfit = currentProfit;
            }
        }

        return maxProfit;

    }

    //0(n) solution
    //keep track of minimum value as you iterate and update when necessary - check to update global minimum or not
    //use this updated/non-updated global minimum to calculate max profit for every upcoming number in the same iteration cycle
    public int maxProfit2(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int element : prices) {
            if (element  < minprice)
                minprice = element;
            else if (element  - minprice > maxprofit)
                maxprofit = element - minprice;
        }
        return maxprofit;
    }



}
