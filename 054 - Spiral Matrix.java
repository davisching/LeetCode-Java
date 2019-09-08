/*  054 - Spiral Matrix - From @ LeetCode.com
    
    Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

    Example 1:
    Input:
    [
     [ 1, 2, 3 ],
     [ 4, 5, 6 ],
     [ 7, 8, 9 ]
    ]
    Output: [1,2,3,6,9,8,7,4,5]

    Example 2:
    Input:
    [
      [1, 2, 3, 4],
      [5, 6, 7, 8],
      [9,10,11,12]
    ]
    Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 
    Solution by @ Davis Ching, 2019
 */
 
 class Solution {
    
    private List<Integer> ans = new ArrayList<>();
    private int[][] matrix = null;
    private  int i = 0, j = 0, k = 0; 
    
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return ans;
        this.matrix = matrix;
        while (ans.size() < matrix[0].length * matrix.length) {
            for (i = k, j = k; i < matrix[0].length-k; i++)
                if (add()) return ans;
            for (i -= 1, j += 1; j < matrix.length-k; j++)
                if (add()) return ans;
            for (j -= 1, i -= 1; i >= k; i--)
                if (add()) return ans;
            for (i += 1, j -= 1; j >= k+1; j--)
                if (add()) return ans;
            k += 1;
        }
        return ans;
    }
    
    private boolean add() {
        ans.add(matrix[j][i]);
        if (ans.size() < matrix[0].length * matrix.length) return false;
        return true;
    }
}
