/*  069 - Sqrt(x) - From @ LeetCode.com
    
    Implement int sqrt(int x).
    Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
    Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.

    Example 1:
    Input: 4
    Output: 2

    Example 2:
    Input: 8
    Output: 2
    Explanation: The square root of 8 is 2.82842..., and since 
                 the decimal part is truncated, 2 is returned.

    Solution by @ Davis Ching, 2019
 */
 
 class Solution {
    public int mySqrt(int x) {
        int l = 1, r = x/2;
        while (l <= r) {
            int m = (l+r)/2;
            if (x/m >= m && x/(m+1) < m+1) return m;
            else if (x/m < m) r = m - 1;
            else l = m + 1;
        }
        return (x == 0) ? 0 : 1;
    }
}
