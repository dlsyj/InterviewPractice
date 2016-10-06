public class Solution {
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[];
        int result = 0;
        for (int i = 2; i < n; i ++){
            if (notPrime[i] == false){
                result ++;
                for (int j = 2; i * j < n; j ++){
                    notPrime[j] = true;
                }
            }
        }
        return result;
    }
}