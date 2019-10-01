/*  079 - Word Search - From @ LeetCode.com
    
    Given a 2D board and a word, find if the word exists in the grid.

    The word can be constructed from letters of sequentially adjacent cell, 
    where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

    Example:
    board =
    [
      ['A','B','C','E'],
      ['S','F','C','S'],
      ['A','D','E','E']
    ]
    Given word = "ABCCED", return true.
    Given word = "SEE", return true.
    Given word = "ABCB", return false.

    Solution by @ Davis Ching, 2019
 */
 
class Solution {
    
    private boolean[][] visited;
    
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = m > 0 ? board[0].length : 0;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (backtracking(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean backtracking(char[][] board, int i, int j, String word, int k) {
        if (k == word.length()) {
            return true;
        } else if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(k) || visited[i][j]) {
            return false;
        } else {
            k += 1;
            visited[i][j] = true;
            if (backtracking(board, i+1, j, word, k) ||
                backtracking(board, i-1, j, word, k) ||
                backtracking(board, i, j+1, word, k) ||
                backtracking(board, i, j-1, word, k)) return true;
            visited[i][j] = false;
            return false;
        }
    }
}