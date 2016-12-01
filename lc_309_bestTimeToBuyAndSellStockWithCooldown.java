package leetcode;
/* Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:

You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
Example:

prices = [1, 2, 3, 0, 2]
maxProfit = 3
transactions = [buy, sell, cooldown, buy, sell]
 * https://discuss.leetcode.com/topic/30421/share-my-thinking-process
 */
public class lc_309_bestTimeToBuyAndSellStockWithCooldown {
	public int maxProfit(int[] prices) {
        int prev_buy = 0, curr_buy = Integer.MIN_VALUE, prev_sell = 0, curr_sell = 0;
        // attention: curr_buy should be initialized as MIN_VALUE to avoid a wrong answer
        for (int price : prices){
            prev_buy = curr_buy;
            curr_buy = Math.max(prev_sell - price, prev_buy);
            prev_sell = curr_sell;
            curr_sell = Math.max(prev_buy + price, prev_sell);
        }
        return curr_sell;
    }
}
