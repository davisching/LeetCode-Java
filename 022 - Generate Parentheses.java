/*  022 - Generate Parentheses - From @ LeetCode.com
    
    Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

    For example, given n = 3, a solution set is:
    [
      "((()))",
      "(()())",
      "(())()",
      "()(())",
      "()()()"
    ]

    Solution by @ Davis Ching, 2019
 */
 
 class Solution {
    
    private List<String> ans = new LinkedList<>();
    private int n;
    
    public List<String> generateParenthesis(int n) {
        this.n = n;
        backtrack("", 0, 0);
        return ans;
    }
    
    private void backtrack (String str, int l, int r) {
        if (l + r == n*2)
            ans.add(str);
        else {
            if (l < n)  backtrack(str+'(', l+1, r);
            if (r < l)  backtrack(str+')', l, r+1);
        }
    }
}
