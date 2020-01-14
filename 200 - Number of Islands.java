/*  200 - Number of Islands - From @ LeetCode.com
    
    Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. 
    An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
    You may assume all four edges of the grid are all surrounded by water.

    Example 1:

    Input:
    11110
    11010
    11000
    00000

    Output: 1

    Example 2:

    Input:
    11000
    11000
    00100
    00011

    Output: 3
    
    Solution by @ Davis Ching, 2020.
 */
 
 class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++)
                if (grid[i][j] == '1') {
                    drownIsland(grid, i, j);
                    count += 1;
                }
        return count;
    }
    
    private void drownIsland(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length 
            || j < 0 || j >= grid[0].length || grid[i][j] == '0')
            return;
        grid[i][j] = '0';
        drownIsland(grid, i+1, j);
        drownIsland(grid, i-1, j);
        drownIsland(grid, i, j+1);
        drownIsland(grid, i, j-1);
    }
}
