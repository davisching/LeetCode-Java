/*  038 - Count and Say - From @ LeetCode.com
    
    Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), 
    find all unique combinations in candidates where the candidate numbers sums to target.
    The same repeated number may be chosen from candidates unlimited number of times.

    Note:
    All numbers (including target) will be positive integers.
    The solution set must not contain duplicate combinations.

    Example 1:
    Input: candidates = [2,3,6,7], target = 7,
    A solution set is:
    [
      [7],
      [2,2,3]
    ]

    Example 2:
    Input: candidates = [2,3,5], target = 8,
    A solution set is:
    [
      [2,2,2,2],
      [2,3,3],
      [3,5]
    ]

    Solution by @ Davis Ching, 2019
 */
 
 class Solution {
    
    private List<List<Integer>> ans = new ArrayList<>();
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, 0, target, new ArrayList<Integer>());
        return ans;
    }
    
    private void backtrack (int[] candidates, int startsAt, int target, List<Integer> list) {
        if (target == 0) ans.add(new ArrayList(list));
        if (target < candidates[startsAt]) return;
        for (int i = startsAt; i < candidates.length; i++) {
            list.add(candidates[i]);
            backtrack(candidates, i, target-candidates[i], list);
            list.remove(list.size()-1);
        }
    }
}
