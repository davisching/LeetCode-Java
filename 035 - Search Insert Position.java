/*  035 - Search Insert Position - From @ LeetCode.com
    
    Given a sorted array and a target value, return the index if the target is found. 
    If not, return the index where it would be if it were inserted in order.
    You may assume no duplicates in the array.

    Example 1:
    Input: [1,3,5,6], 5
    Output: 2

    Example 2:
    Input: [1,3,5,6], 2
    Output: 1

    Example 3:
    Input: [1,3,5,6], 7
    Output: 4

    Example 4:
    Input: [1,3,5,6], 0
    Output: 0

    Solution by @ Davis Ching, 2019
 */
 
 class Solution {
    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (target < nums[m])
                r = m - 1;
            else if (target > nums[m])
                l = m + 1;
            else return m;
        }
        return l;
    }
}
