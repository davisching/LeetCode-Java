/*  016 - 3Sum Closest - From @ LeetCode.com
    
    Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. 
    Return the sum of the three integers. You may assume that each input would have exactly one solution.

    Example:
    Given array nums = [-1, 2, 1, -4], and target = 1.
    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
           
    Solution by @ Davis Ching, 2019
 */
 
 class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i + 2 < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i-1])
                continue;
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum > target)
                    r--;
                else
                    l++;
                if (Math.abs(sum - target) < Math.abs(ans - target))
                    ans = sum;
            }
        }
        return ans;
    }
}
