package leetcode;
/* Given a sorted array of integers nums and integer values a, b and c. Apply a function of the form f(x) = ax2 + bx + c to each element x in the array.

The returned array must be in sorted order.

Expected time complexity: O(n)

Example:
nums = [-4, -2, 2, 4], a = 1, b = 3, c = 5,

Result: [3, 9, 15, 33]

nums = [-4, -2, 2, 4], a = -1, b = 3, c = 5

Result: [-23, -5, 1, 7]

 * the problem seems to have many cases a>0, a=0,a<0, (when a=0, b>0, b<0). However, they can be combined into just 2 cases: a>0 or a<0

1.a>0, two ends in original array are bigger than center if you learned middle school math before.

2.a<0, center is bigger than two ends.

so use two pointers i, j and do a merge-sort like process. depending on sign of a, you may want to start from the beginning or end of the transformed array. For a==0 case, it does not matter what b's sign is.
The function is monotonically increasing or decreasing. you can start with either beginning or end.
 */
public class lc_360_sortTransformedArray {
	public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int len = nums.length;
        int[] sorted = new int[len];
        int left = 0, right = len - 1;
        int index = a >= 0 ? len - 1 : 0;
        while (left <= right){
            if (a >= 0){
                sorted[index --] = cal(nums[left], a, b, c) >= cal(nums[right], a, b, c) ? cal(nums[left ++], a, b, c) :cal(nums[right --], a, b, c);
            }else{
                sorted[index ++] = cal(nums[left], a, b, c) < cal(nums[right], a, b, c) ? cal(nums[left ++], a, b, c) :cal(nums[right --], a, b, c);
            }
        }
        return sorted;
    }
    
    public int cal(int x, int a, int b, int c){
        return a*x*x + b*x + c;
    }
}
