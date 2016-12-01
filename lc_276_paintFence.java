package leetcode;
/* There is a fence with n posts, each post can be painted with one of the k colors.

You have to paint all the posts such that no more than two adjacent fence posts have the same color.

Return the total number of ways you can paint the fence.

Note:
n and k are non-negative integers.
 * Method: 
w(n) number of ways to paint n posts

p(n) color of the nth post

w(n) consists of two cases:

1.p(n) == p(n - 1)

2.p(n) != p(n - 1)

case 2 is easy. for every way of painting all previous (n - 1) posts, you have (k - 1) ways to paint p(n)
because you can choose k - 1 different color rather than the same color as p(n - 1)

so w(n - 1) * (k - 1)

notice that for p(n) == p(n - 1), p(n - 1) must be not equal to p(n - 2), this is equalvalent to replace n by n - 1
for the formular above, essentially the same as case2 but for a smaller n.
so w(n - 1 - 1) * (k - 1)

so w(n) = (k - 1) * (w(n - 1) + w(n - 2))
 */
public class lc_276_paintFence {
	public int numWays(int n, int k) {
        if (n == 0 || k == 0 ){
            return 0;
        }
        int w1 = k;
        int w2 = k * k;
        int curr = 0;
        if (n == 1){
            return w1;
        }
        if (n == 2){
            return w2;
        }
        for (int i = 0; i <= n - 3; i ++){
            curr = (k - 1)*(w2 + w1);
            w1 = w2;
            w2 = curr;
        }
        return curr;
    }
}
