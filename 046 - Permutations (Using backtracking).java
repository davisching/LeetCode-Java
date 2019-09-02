/*  046 - Permutations - From @ LeetCode.com
    
    Given a collection of distinct integers, return all possible permutations.

    Example:
    Input: [1,2,3]
    Output:
    [
      [1,2,3],
      [1,3,2],
      [2,1,3],
      [2,3,1],
      [3,1,2],
      [3,2,1]
    ]

    Solution by @ Davis Ching, 2019
 */
 
 // Using backtracking
 
 class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtracking(nums, ans, new ArrayList<Integer>());
        return ans;
    }
    
    private void backtracking (int[] nums, List<List<Integer>> ans, List<Integer> list) {
        if (nums.length == list.size()) {
            ans.add(new ArrayList(list));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (list.contains(nums[i])) continue;
                list.add(nums[i]);
                backtracking(nums, ans, list);
                list.remove(list.size()-1);
            }
        }
    }
}
