/*  209 - Minimum Size Subarray Sum - From @ LeetCode.com
    
    Given an array of n positive integers and a positive integer s, 
    find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

    Example: 

    Input: s = 7, nums = [2,3,1,2,4,3]
    Output: 2
    Explanation: the subarray [4,3] has the minimal length under the problem constraint.

    Follow up:
    If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n). 

    Solution by @ Davis Ching, 2020.
 */
 
 class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int[] sums = new int[nums.length+1];
        for (int i = 0; i < nums.length; i++)
            sums[i+1] = sums[i] + nums[i];
        boolean found = false;
        int min = nums.length;
        for (int i = 0; i < nums.length; i++) {
            int l = i, r = Math.min(nums.length,l + min);
            while (l <= r) {
                int m = (l+r)/2;
                if (sums[m] - sums[i] < s)
                    l = m + 1;
                else {
                    found = true;
                    min = Math.min(min, m - i);
                    r = m - 1;
                }
            }
        }
        return found ? min : 0;
    }
}
