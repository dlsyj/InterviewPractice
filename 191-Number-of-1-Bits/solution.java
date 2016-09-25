public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int result = 0;
        while (n != 0){
            count ++;
            n = n && (n - 1);
        }
        return count;
    }
}