public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int maxAns = 0;
        for (int i = 0; i < prices.length; i++){
            min = min < prices[i] ? min : prices[i];
            maxAns = maxAns > (prices[i] - min) ? maxAns : (prices[i] - min);
        }
        return maxAns;
    }
}