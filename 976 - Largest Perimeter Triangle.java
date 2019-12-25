/*  976 - Largest Perimeter Triangle - From @ LeetCode.com
    
    Given an array A of positive lengths, return the largest perimeter of a triangle with non-zero area, 
    formed from 3 of these lengths.

    If it is impossible to form any triangle of non-zero area, return 0.

    Example 1:

    Input: [2,1,2]
    Output: 5

    Example 2:

    Input: [1,2,1]
    Output: 0

    Example 3:

    Input: [3,2,3,4]
    Output: 10

    Example 4:

    Input: [3,6,2,3]
    Output: 8

    Note:

        3 <= A.length <= 10000
        1 <= A[i] <= 10^6
    
    Solution by @ Davis Ching, 2019
 */
 
 class Solution {
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        return largestPerimeter(A, A.length-1);
    }
    
    private int largestPerimeter(int[] A, int longestIdx) {
        if (longestIdx < 2) return 0;
        int x = A[longestIdx];
        int y = A[longestIdx-1];
        int z = A[longestIdx-2];
        return (x < y + z) ? x+y+z 
                           : largestPerimeter(A, longestIdx-1);
    }
}
