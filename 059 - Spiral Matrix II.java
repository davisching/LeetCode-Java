/*  059 - Spiral Matrix II - From @ LeetCode.com
    
    Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
    Example:
    Input: 3
    Output:
    [
     [ 1, 2, 3 ],
     [ 8, 9, 4 ],
     [ 7, 6, 5 ]
    ]
    
    Solution by @ Davis Ching, 2019
 */
 
 class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int k = 0, i = 0, j = 0, x = 1;
        while (k < (n+1)/2) {
            for (i = k, j = k; j < n - k; j++)
                ans[i][j] = x++;
            for (i += 1, j -= 1; i < n - k; i++)
                ans[i][j] = x++;
            for (i -= 1, j -= 1; j >= k; j--)
                ans[i][j] = x++;
            for (i -= 1, j += 1; i > k; i--)
                ans[i][j] = x++;
            k += 1;
        }
        return ans;
    }
}
