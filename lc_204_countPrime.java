package leetcode;
/* Count the number of prime numbers less than a non-negative number, n.
 * 
 */
public class lc_204_countPrime {
	public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int result = 0;
        for (int i = 2; i < n; i++){
            if (notPrime[i] == false){
                result ++;
                for (int j = 2; i * j < n; j++){
                    notPrime[i * j] = true;
                } 
            }
        }
        return result;
    }
}
