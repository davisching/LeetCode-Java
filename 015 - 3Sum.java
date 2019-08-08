/*  015 - 3Sum - From @ LeetCode.com

    Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? 
    Find all unique triplets in the array which gives the sum of zero.

    Note:
    The solution set must not contain duplicate triplets.

    Example:
    Given array nums = [-1, 0, 1, 2, -1, -4],
    A solution set is:
    [
      [-1, 0, 1],
      [-1, -1, 2]
    ]
              
    Solution by @ Davis Ching, 2019
 */
 
 class Solution {
    public List<List<Integer>> threeSum (int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        Arrays.sort(nums);
        for (int i = 0; i + 2 < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i-1])
                continue;
            int l = i+1, r = nums.length-1, target = -nums[i];
            while (l < r) {
                if (nums[l] + nums[r] == target) {
                    ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    do { l++; } while (l < r && nums[l] == nums[l-1]);
                    do { r--; } while (l < r && nums[r] == nums[r+1]);
                } else if (nums[l] + nums[r] > target)
                    r--;
                else
                    l++;
            }
        }
        return ans;
    }
}
