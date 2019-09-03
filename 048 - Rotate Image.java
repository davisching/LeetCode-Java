/*  067 - Add Binary - From @ LeetCode.com
    
    You are given an n x n 2D matrix representing an image.
    Rotate the image by 90 degrees (clockwise).
    Note:
    You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. 
    DO NOT allocate another 2D matrix and do the rotation.

    Example 1:
    Given input matrix = 
    [
      [1,2,3],
      [4,5,6],
      [7,8,9]
    ],
    rotate the input matrix in-place such that it becomes:
    [
      [7,4,1],
      [8,5,2],
      [9,6,3]
    ]

    Example 2:
    Given input matrix =
    [
      [ 5, 1, 9,11],
      [ 2, 4, 8,10],
      [13, 3, 6, 7],
      [15,14,12,16]
    ], 
    rotate the input matrix in-place such that it becomes:
    [
      [15,13, 2, 5],
      [14, 3, 4, 1],
      [12, 6, 8, 9],
      [16, 7,10,11]
    ]

    Solution by @ Davis Ching, 2019
 */
 
 class Solution {
    public void rotate(int[][] matrix) {
        cornerFliping(matrix);
        rotateHorizontally(matrix);
    }
    
    private void cornerFliping (int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) 
            for (int j = 0; j < matrix.length; j++) 
                if (i < j) swap(matrix, i, j, j, i);
    }
    
    private void rotateHorizontally (int[][] matrix) {
        for (int j = 0; j < matrix.length; j++)
            for (int i = 0; i < matrix.length; i++)
                if (j < matrix.length-j-1) swap(matrix, i, j, i, matrix.length-j-1);
    }
    
    private void swap (int[][] matrix, int x1, int y1, int x2, int y2) {
        int t = matrix[x1][y1]; matrix[x1][y1] = matrix[x2][y2]; matrix[x2][y2] = t; 
    }
}
