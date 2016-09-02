public class Solution {
    public int maxProfit(int[] prices) {
        // Scan from left to right and keep the minimum and largest gap
        int minPrice = Integer.MAX_VALUE, maxGap = 0;
        for (int price : prices){
            minPrice = Math.min(minPrice,price);
            maxGap = Math.max(price - minPrice, maxGap);
        }
        return maxGap;
    }
}