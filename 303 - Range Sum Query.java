/*  303 - Range Sum Query - Immutable - From @ LeetCode.com
    
    Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

    Example:

    Given nums = [-2, 0, 3, -5, 2, -1]

    sumRange(0, 2) -> 1
    sumRange(2, 5) -> -1
    sumRange(0, 5) -> -3

    Note:

        You may assume that the array does not change.
        There are many calls to sumRange function.

    
    Solution by @ Davis Ching, 2019
 */
 
 class NumArray {

    private int[] sums = null;
    
    public NumArray(int[] nums) {
        sums = nums;
        calculateSums(nums);
    }
    
    private void calculateSums(int[] sums) {
        int sum = 0;
        for (int i = 0; i < sums.length; i++) {
            sum += sums[i];
            sums[i] = sum;
        }
    }
    
    public int sumRange(int i, int j) {
        return i == 0 ? sums[j] : sums[j] - sums[i-1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */

