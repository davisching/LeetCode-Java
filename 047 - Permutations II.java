/*  047 - Permutations II - From @ LeetCode.com
    
    Given a collection of numbers that might contain duplicates, return all possible unique permutations.

    Example:
    Input: [1,1,2]
    Output:
    [
      [1,1,2],
      [1,2,1],
      [2,1,1]
    ]

    Solution by @ Davis Ching, 2019
 */
 
 // This problem can be solved with the same solution of "Next Permutation" as Permutation I.
 // Which is more efficient and friendly
 // The solution's link is below:
 // https://github.com/davisching/LeetCode-Java/blob/master/046%20-%20Permutations%20(Using%20Next%20Permutation).java
 
 // Using backtracking
 
 class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        backtracking(nums, ans, new ArrayList<Integer>(), new boolean[nums.length]);
        return ans;
    }
    
    private void backtracking (int[] nums, List<List<Integer>> ans, List<Integer> list, boolean[] used) {
        if (nums.length == list.size()) {
            ans.add(new ArrayList(list));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i] || i > 0 && nums[i] == nums[i-1] && !used[i-1]) continue;
                list.add(nums[i]);
                used[i] = true;
                backtracking(nums, ans, list, used);
                used[i] = false;
                list.remove(list.size()-1);
            }
        }
    }
}
