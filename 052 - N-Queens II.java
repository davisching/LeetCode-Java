/*  051 - N-Queens - From @ LeetCode.com
    
    The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
    Given an integer n, return the number of distinct solutions to the n-queens puzzle.
    Example:
    Input: 4
    Output: [
     [".Q..",  // Solution 1
      "...Q",
      "Q...",
      "..Q."],
     ["..Q.",  // Solution 2
      "Q...",
      "...Q",
      ".Q.."]
    ]
    Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.
    
    Solution by @ Davis Ching, 2019
 */
 
 // 这里直接使用了获取所有结果集，再数数的方法。如果为了效率只数出有几个答案，但要求答案的时候，又要重新写方法吗？开发效率和运行效率，是一个paradox
 
 class Solution {
    public int totalNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        backtracking(n, ans, new ArrayList<>());
        return ans.size();
    }
    
    private void backtracking (int n, List<List<String>> ans, List<String> list) {
        if (list.size() == n) {
            ans.add(new ArrayList(list));
        } else {
            for (int j = 0; j < n; j++) {
                if (!isValid(list, j)) continue;
                list.add(getRowStr(n, j));
                backtracking(n, ans, list);
                list.remove(list.size()-1);
            }
        }
    }
    
    private boolean isValid (List<String> list, int j) {
        for (int i = list.size()-1, k = 1; i >= 0; i--, k++) {
            String curRow = list.get(i);
            if (curRow.charAt(j) == 'Q') return false;
            if (j-k >= 0 && curRow.charAt(j-k) == 'Q') return false;
            if (j+k < curRow.length() && curRow.charAt(j+k) == 'Q') return false;
        } 
        return true;
    }
    
    private String getRowStr (int n, int j) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i == j) sb.append('Q');
            else sb.append('.');
        }
        return sb.toString();
    }
}
