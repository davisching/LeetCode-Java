/*  041 - First Missing Positive - From @ LeetCode.com
    
    Given an unsorted integer array, find the smallest missing positive integer.

    Example 1:
    Input: [1,2,0]
    Output: 3

    Example 2:
    Input: [3,4,-1,1]
    Output: 2

    Example 3:
    Input: [7,8,9,11,12]
    Output: 1

    Note:
    Your algorithm should run in O(n) time and uses constant extra space.
 
    Solution by @ Davis Ching, 2019
 */
 
 class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) return 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i]-1]) {
                swap(nums, i, nums[i]-1);
                i -= 1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1)
                return i + 1;
        }
        return nums.length + 1;
    }
    
    private void swap (int[] nums, int i, int j) {
        int t = nums[i]; nums[i]  = nums[j]; nums[j] = t;
    }
}
