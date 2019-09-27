/*  077 - Combinations - From @ LeetCode.com
    
    Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

    Example:
    Input: n = 4, k = 2
    Output:
    [
      [2,4],
      [3,4],
      [2,3],
      [1,2],
      [1,3],
      [1,4],
    ]
    
    Solution by @ Davis Ching, 2019
 */
 
 class Solution {
    
    List<List<Integer>> ans = new ArrayList<>();
    
    public List<List<Integer>> combine(int n, int k) {
        backtracking(n, k, new ArrayList<Integer>());
        return ans;
    }
    
    private void backtracking (int n, int k, List<Integer> list) {
        if (k == 0) {
            ans.add(new ArrayList(list));
        } else {
            for (int i = n; i >= 1; i--) {
                list.add(i);
                backtracking(i-1, k-1, list);
                list.remove(list.size()-1);
            }
        }
    }
}
