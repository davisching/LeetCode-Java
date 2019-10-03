/*  081 - Search in Rotated Sorted Array II - From @ LeetCode.com
    
    Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

    (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).

    You are given a target value to search. If found in the array return true, otherwise return false.

    Example 1:

    Input: nums = [2,5,6,0,0,1,2], target = 0
    Output: true

    Example 2:

    Input: nums = [2,5,6,0,0,1,2], target = 3
    Output: false

    Follow up:

    This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
    Would this affect the run-time complexity? How and why?



    Solution by @ Davis Ching, 2019
 */
 
class Solution {
    public boolean search(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        while (l <= r) {
            while (l < r && nums[l] == nums[r]) l++;
            int m = (l+r)/2;
            if (target == nums[m]) {
                return true;
            } else if (nums[m] >= nums[l]) {
                if (nums[l] <= target && target < nums[m]) {
                    r = m - 1;
                } else {
                    l = m + 1; 
                }
            } else {
                if (nums[m] < target && target <= nums[r]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }
        return false;
    }
}