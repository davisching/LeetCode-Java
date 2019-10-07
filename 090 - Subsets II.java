/*  090 - Subsets II - From @ LeetCode.com
    
    Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

    Note: The solution set must not contain duplicate subsets.

    Example:

    Input: [1,2,2]
    Output:
    [
    [2],
    [1],
    [1,2,2],
    [2,2],
    [1,2],
    []
    ]

    Solution by @ Davis Ching, 2019
 */
 
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        backtracking(ans, nums, new ArrayList(), 0);
        return ans;
    }
    
    private void backtracking (List<List<Integer>> ans, int[] nums, List<Integer> list, int startsAt) {
        ans.add(new ArrayList(list));
        for (int i = startsAt; i < nums.length; i++) {
            if (i > startsAt && nums[i] == nums[i-1]) continue;
            list.add(nums[i]);
            backtracking(ans, nums, list, i+1);
            list.remove(list.size()-1);
        }
    }
}