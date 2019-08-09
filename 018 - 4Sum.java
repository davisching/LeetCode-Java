/*  018 - 4Sum - From @ LeetCode.com
    
    Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

    Note:
    The solution set must not contain duplicate quadruplets.

    Example:
    Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
    A solution set is:
    [
      [-1,  0, 0, 1],
      [-2, -1, 1, 2],
      [-2,  0, 0, 2]
    ]

    Solution by @ Davis Ching, 2019
 */
 
 class Solution {
    
    private int[] nums;
    
    public List<List<Integer>> fourSum (int[] nums, int target) {
        List<List<Integer>> ans = new LinkedList<>();
        this.nums = nums;
        int l = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i + 3 < l; i++) {
            if (sum(i, i+1, i+2, i+3) > target) break;
            if (sum(i, l-3, l-2, l-1) < target) continue;
            if (i != 0 && nums[i] == nums[i-1]) continue;
            for (int j = i + 1; j + 2 < l; j++) {
                if (sum(i, j, j+1, j+2) > target) break;
                if (sum(i, j, l-2, l-1) < target) continue;
                if (j != i + 1 && nums[j] == nums[j-1]) continue;
                int lo = j+1, hi = l-1;
                while (lo < hi) {
                    int sum = sum(i, j, lo, hi);
                    if (sum == target) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[lo], nums[hi]));
                        do { lo++; } while (lo < hi && nums[lo] == nums[lo-1]);
                        do { hi--; } while (lo < hi && nums[hi] == nums[hi+1]);
                    } else if (sum > target)
                        hi--;
                    else
                        lo++;
                }
            }
        }
        return ans;
    }
    
    private int sum (int a, int b, int c, int d) {
        return nums[a] + nums[b] + nums[c] + nums[d];
    }
}
