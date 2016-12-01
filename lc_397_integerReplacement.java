package leetcode;
/* Given a positive integer n and you can do operations as follow:

If n is even, replace n with n/2.
If n is odd, you can replace n with either n + 1 or n - 1.
What is the minimum number of replacements needed for n to become 1?

Example 1:

Input:
8

Output:
3

Explanation:
8 -> 4 -> 2 -> 1
Example 2:

Input:
7

Output:
4

Explanation:
7 -> 8 -> 4 -> 2 -> 1
or
7 -> 6 -> 3 -> 2 -> 1
 * 
 * 利用bit位的操作。如果这个数偶数，那么末位的bit位一定是0。如果一个数是奇数，那么末位的bit位一定是1。对于偶数，操作是直接除以2。

对于奇数的操作:
如果倒数第二位是0，那么n-1的操作比n+1的操作能消掉更多的1。
1001 + 1 = 1010
1001 - 1 = 1000
如果倒数第二位是1，那么n+1的操作能比n-1的操作消掉更多的1。
1011 + 1 = 1100
1111 + 1 = 10000

还有一个tricky的地方是，为了防止integer越界，可以将n先转换成long。long N = n;这样的处理。
 */
public class lc_397_integerReplacement {
	public int integerReplacement(int n) {
        // 处理大数据的时候tricky part, 用Long来代替int数据
        long N = n;
        int count = 0;
        while(N != 1){
            if (N % 2 == 0){
                N = N >> 1;
            }else{
                // corner case
                if (N == 3){
                    count += 2;
                    break;
                }
                N = (N & 2) == 2 ? N + 1: N - 1;
            }
            count ++;
        }
        return count;
    }
}
