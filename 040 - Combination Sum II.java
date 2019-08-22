/*  040 - Combination Sum II - From @ LeetCode.com
    
    Given a collection of candidate numbers (candidates) and a target number (target), 
    find all unique combinations in candidates where the candidate numbers sums to target.
    Each number in candidates may only be used once in the combination.

    Note:
    All numbers (including target) will be positive integers.
    The solution set must not contain duplicate combinations.

    Example 1:
    Input: candidates = [10,1,2,7,6,1,5], target = 8,
    A solution set is:
    [
      [1, 7],
      [1, 2, 5],
      [2, 6],
      [1, 1, 6]
    ]

    Example 2:
    Input: candidates = [2,5,2,1,2], target = 5,
    A solution set is:
    [
      [1,2,2],
      [5]
    ]

    Solution by @ Davis Ching, 2019
 */
 
 class Solution {
    
    private List<List<Integer>> ans = new ArrayList<>();
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        getCombination(candidates, 0, target, new ArrayList<>());
        return ans;
    }
    
    private void getCombination (int[] candidates, int startsAt, int target, List<Integer> list) {
        if (target == 0) ans.add(new ArrayList(list));
        if (startsAt >= candidates.length || candidates[startsAt] > target) return;
        for (int i = startsAt; i < candidates.length; i++) {
            if (i != startsAt && candidates[i] == candidates[i-1]) continue;
            list.add(candidates[i]);
            getCombination(candidates, i+1, target-candidates[i], list);
            list.remove(list.size()-1);
        }
    }
}
