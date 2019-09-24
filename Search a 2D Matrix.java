/*  074 - Search a 2D Matrix - From @ LeetCode.com
    
    Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
    Integers in each row are sorted from left to right.
    The first integer of each row is greater than the last integer of the previous row.

    Example 1:
    Input:
    matrix = [
      [1,   3,  5,  7],
      [10, 11, 16, 20],
      [23, 30, 34, 50]
    ]
    target = 3
    Output: true

    Example 2:
    Input:
    matrix = [
      [1,   3,  5,  7],
      [10, 11, 16, 20],
      [23, 30, 34, 50]
    ]
    target = 13
    Output: false

    Solution by @ Davis Ching, 2019
 */
 
 class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        int l = 0, r = m-1;
        while (l <= r) {
            int mid = (l+r)/2;
            if (target >= matrix[mid][0] && target <= matrix[mid][n-1]){
                return searchArray(matrix[mid], target);
            } else if (target < matrix[mid][0]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }
    
    private boolean searchArray(int[] arr, int target) {
        int l = 0, r = arr.length-1;
        while (l <= r) {
            int mid = (l+r)/2;
            if (arr[mid] == target) {
                return true;
            } else if (target < arr[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }
}
