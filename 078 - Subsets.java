/*  078 - Subsets - From @ LeetCode.com
    
    Given a set of distinct integers, nums, return all possible subsets (the power set).
    Note: The solution set must not contain duplicate subsets.

    Example:
    Input: nums = [1,2,3]
    Output:
    [
      [3],
      [1],
      [2],
      [1,2,3],
      [1,3],
      [2,3],
      [1,2],
      []
    ]
  
    Solution by @ Davis Ching, 2019
 */
 
 class Solution {
    
    List<List<Integer>> ans = new ArrayList<>();
    
    public List<List<Integer>> subsets(int[] nums) {
        backtracking(nums, 0, new ArrayList<>());
        return ans;
    }
    
    private void backtracking (int[] nums, int startsAt, List<Integer> list) {
        ans.add(new ArrayList(list));
        for (int i = startsAt; i < nums.length; i++) {
            list.add(nums[i]);
            backtracking(nums, i+1, list);
            list.remove(list.size()-1);
        }
    }
}
