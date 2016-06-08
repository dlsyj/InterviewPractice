public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0){
            return 0;
        }
        int ans = 0;
        int[] left = new int[prices.length];
        int min = Integer.MAX_VALUE;
        int maxLeft = 0;
        for (int i=0; i < prices.length; i++){
            min = min < prices[i] ? min : prices[i];
            maxLeft = maxLeft > (prices[i] - min) ? maxLeft : (prices[i] - min);
            left[i] = maxLeft;
        }
        int max = Integer.MIN_VALUE;
        int maxRight = 0;
        for (int i=prices.length-1; i >= 0; i--){
            max = max > prices[i] ? max : prices[i];
            maxRight = maxRight > (max - prices[i]) ? maxRight : (max - prices[i]);
            ans = ans > (maxRight + left[i]) ? ans : (maxRight + left[i]);
        }
        return ans;
    }
}