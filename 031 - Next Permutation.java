/*  031 - Next Permutation - From @ LeetCode.com
    
    Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
    If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
    The replacement must be in-place and use only constant extra memory.
    Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

    1,2,3 → 1,3,2
    3,2,1 → 1,2,3
    1,1,5 → 1,5,1

    Solution by @ Davis Ching, 2019
 */
 
 class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2, j = i + 1;
        while (i >= 0 && nums[i] >= nums[i+1])
            i -= 1;
        if (i >= 0) {
            while (nums[j] <= nums[i])
                j -= 1;
            swap(nums, i, j);
        }
        reverse(nums, i+1);
    }
    
    private void reverse (int[] nums, int i) {
        int j = nums.length - 1;
        while (i < j)
            swap(nums, i++, j--);
    }
    
    private void swap (int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
