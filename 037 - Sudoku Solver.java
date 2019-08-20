/*  037 - Sudoku Solver - From @ LeetCode.com
    
    Write a program to solve a Sudoku puzzle by filling the empty cells.
    
    A sudoku solution must satisfy all of the following rules:
        Each of the digits 1-9 must occur exactly once in each row.
        Each of the digits 1-9 must occur exactly once in each column.
        Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
    Empty cells are indicated by the character '.'.

    Note:
    The given board contain only digits 1-9 and the character '.'.
    You may assume that the given Sudoku puzzle will have a single unique solution.
    The given board size is always 9x9.

    Solution by @ Davis Ching, 2019
 */
 
 class Solution {
    public void solveSudoku (char[][] board) {
        dfs(board, 0);
    }
    
    private boolean dfs (char[][] board, int n) {
        if (n == 81) return true;
        int i = n / 9, j = n % 9;
        if (board[i][j] != '.') return dfs(board, n+1);
        boolean[] notValid = new boolean[10];
        validate(board, i, j, notValid);
        for (int k = 1; k <= 9; k++) {
            if (!notValid[k]) {
                board[i][j] = (char)('0'+k);
                if (dfs(board, n+1)) return true;
            }
        }
        board[i][j] = '.';
        return false;
    }
    
    private void validate (char[][] board, int i, int j, boolean[] notValid) {
        for (int k = 0; k < 9; k++) {
            if (board[i][k] != '.') notValid[board[i][k]-'0'] = true;
            if (board[k][j] != '.') notValid[board[k][j]-'0'] = true;
            int r = i/3*3+k/3, c = j/3*3+k%3;
            if (board[r][c] != '.') notValid[board[r][c]-'0'] = true;
        }
    }
}
