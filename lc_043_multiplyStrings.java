package leetcode;
/* Given two numbers represented as strings, return multiplication of the numbers as a string.
Note:
The numbers can be arbitrarily large and are non-negative.
Converting the input string to integer is NOT allowed.
You should NOT use internal library such as BigInteger.
 * 
 */
public class lc_043_multiplyStrings {
	public String multiply(String num1, String num2) {
        // https://discuss.leetcode.com/topic/30508/easiest-java-solution-with-graph-explanation
        int len1 = num1.length();
        int len2 = num2.length();
        int[] product = new int[len1 + len2];
        for (int i = len1 - 1; i >= 0; i --){
            for (int j = len2 - 1; j >= 0; j --){
                int index = len1 + len2 - i - j - 2;
                product[index] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                product[index + 1] += product[index] / 10;
                product[index] %= 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = product.length - 1; i >= 0; i --){
            if (sb.length() == 0 && product[i] == 0){	// reverse product array and avoid leading zeros
                continue;
            }
            sb.append(product[i]);
        }

        return sb.length() == 0 ? "0":sb.toString();
    }
}
