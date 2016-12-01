package leetcode;
/* Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

The update(i, val) function modifies nums by updating the element at index i to val.
Example:
Given nums = [1, 3, 5]

sumRange(0, 2) -> 9
update(1, 2)
sumRange(0, 2) -> 8
Note:
The array is only modifiable by the update function.
You may assume the number of calls to update and sumRange function is distributed evenly.

 * Method: Binary Indexed Tree
 
/* * A Fenwick tree or binary indexed tree is a data structure providing efficient methods
 * for calculation and manipulation of the prefix sums of a table of values.
 * 
 * Space complexity for fenwick tree is O(n)
 * Time complexity to create fenwick tree is O(nlogn)
 * Time complexity to update value is O(logn)
 * Time complexity to get prefix sum is O(logn)
 * 
 * http://blog.csdn.net/L664675249/article/details/50157669
 * 
 */

public class lc_307_rangeSumQuery_Mutable {
	int[] tree;
    int[] nums;
    
    public lc_307_rangeSumQuery_Mutable(int[] nums) {
        tree = new int[nums.length + 1];
        this.nums = nums;
        for (int i = 1; i <= nums.length; i ++){
            int sum = 0;
            for (int j = i; j > i - (i & (i - 1) ^ i); j --){
                sum += nums[j - 1];
            }
            tree[i] = sum;
        }
    }

    void update(int i, int val) {
        int gap = val - nums[i];
        nums[i] = val;
        i ++;
        for (;i < tree.length; i += (i & ((i - 1) ^ i))){
            tree[i] += gap;
        }
    }

    public int sumRange(int i, int j) {
        return getSum(j) - getSum(i - 1);
    }
    
    public int getSum(int i){
        i ++;
        int sum = 0;
        while (i > 0){
            sum += tree[i];
            i -= i & ((i - 1) ^ i);
        }
        return sum;
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);