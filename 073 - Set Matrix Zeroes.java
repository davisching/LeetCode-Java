/*  073 - Set Matrix Zeroes - From @ LeetCode.com
    
    Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.

    Example 1:

    Input: 
    [
      [1,1,1],
      [1,0,1],
      [1,1,1]
    ]
    Output: 
    [
      [1,0,1],
      [0,0,0],
      [1,0,1]
    ]

    Example 2:

    Input: 
    [
      [0,1,2,0],
      [3,4,5,2],
      [1,3,1,5]
    ]
    Output: 
    [
      [0,0,0,0],
      [0,4,5,0],
      [0,3,1,0]
    ]

    Follow up:
    A straight forward solution using O(mn) space is probably a bad idea.
    A simple improvement uses O(m + n) space, but still not the best solution.
    Could you devise a constant space solution?
    
    Solution by @ Davis Ching, 2019
 */
 
 class Solution {
    public void setZeroes(int[][] matrix) {
        boolean zero_0_j = false, zero_i_0 = false;
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) zero_0_j = true;
                    if (j == 0) zero_i_0 = true;
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) 
                for (int j = 1; j < n; j++)
                    matrix[i][j] = 0;
        }
        for (int j = 1; j < n; j++) {
            if (matrix[0][j] == 0)
                for (int i = 1; i < m; i++)
                    matrix[i][j] = 0;
        }
        if (zero_0_j) {
            for (int j = 0; j < n; j++)
                matrix[0][j] = 0;
        }
        if (zero_i_0) {
            for (int i = 0; i < m; i++)
                matrix[i][0] = 0;
        }
    }
}
