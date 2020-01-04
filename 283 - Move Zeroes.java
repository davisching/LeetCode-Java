
/*  283 - Move Zeroes - From @ LeetCode.com
    
    Given an array nums, write a function to move all 0's to the end of it while maintaining 
    the relative order of the non-zero elements.

    Example:

    Input: [0,1,0,3,12]
    Output: [1,3,12,0,0]

    Note:

        You must do this in-place without making a copy of the array.
        Minimize the total number of operations.

    Solution by @ Davis Ching, 2020.
 */
 
 class Solution {
    public void moveZeroes(int[] nums) {
        int idx = 0;
        for (int i = 0; i < nums.length; i++)
            if (nums[i] != 0) 
                nums[idx++] = nums[i];
        
        for (int i = idx; i < nums.length; i++)
            nums[i] = 0;
    }
}
