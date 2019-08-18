/*  034 - Find First and Last Position of Element in Sorted Array - From @ LeetCode.com
    
    Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
    Your algorithm's runtime complexity must be in the order of O(log n).
    If the target is not found in the array, return [-1, -1].

    Example 1:
    Input: nums = [5,7,7,8,8,10], target = 8
    Output: [3,4]

    Example 2:
    Input: nums = [5,7,7,8,8,10], target = 6
    Output: [-1,-1]

    Solution by @ Davis Ching, 2019
 */
 
 class Solution {
    public int[] searchRange (int[] nums, int target) {
        int x = binarySearch(nums, target);
        if (x < 0) return new int[] {-1, -1};
        return getRange(nums, x);
    }
    
    private int binarySearch (int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = (l+r)/2;
            if (target < nums[m])
                r = m - 1;
            else if (target > nums[m])
                l = m + 1;
            else
                return m;
        }
        return -1;
    }
    
    private int[] getRange (int[] nums, int x) {
        int i = x, j = x;
        while (i >= 0 && nums[i] == nums[x])
            i -= 1;
        while (j < nums.length && nums[j] == nums[x])
            j += 1;
        return new int[] {i+1, j-1};
    }
}
