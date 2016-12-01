package leetcode;
/* Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * 
 */
public class lc_123_bestTimeToBuyAndSellStock3 {
	public int maxProfit(int[] prices) {
        int maxProfit1 = 0, maxProfit2 = 0;
        int minBuyPrice1 = Integer.MAX_VALUE, minBuyPrice2 = Integer.MAX_VALUE;
        for (int p : prices){
            maxProfit2 = Math.max(maxProfit2, p - minBuyPrice2);
            minBuyPrice2 = Math.min(minBuyPrice2, p - maxProfit1);
            maxProfit1 = Math.max(maxProfit1, p - minBuyPrice1);
            minBuyPrice1 = Math.min(minBuyPrice1, p);
        }
        return maxProfit2;
    }
}
