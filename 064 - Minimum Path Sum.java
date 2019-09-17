/*  064 - Minimum Path Sum - From @ LeetCode.com
    
    Given a m x n grid filled with non-negative numbers, 
    find a path from top left to bottom right which minimizes the sum of all numbers along its path.
    Note: You can only move either down or right at any point in time.

    Example:
    Input:
    [
      [1,3,1],
      [1,5,1],
      [4,2,1]
    ]
    Output: 7
    Explanation: Because the path 1→3→1→1→1 minimizes the sum.
    
    Solution by @ Davis Ching, 2019
 */
 
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid[0].length, n = grid.length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int upperOne = (j == 0) ? Integer.MAX_VALUE : grid[j-1][i];
                int leftOne = (i == 0) ? Integer.MAX_VALUE : grid[j][i-1];
                if (!(i == 0 && j == 0)) grid[j][i] += Math.min(upperOne, leftOne);
            }
        }
        return grid[n-1][m-1];
    }
}
