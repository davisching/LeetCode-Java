/*  367 - Valid Perfect Square - From @ LeetCode.com
    
    Given a positive integer num, write a function which returns True if num is a perfect square else False.

    Note: Do not use any built-in library function such as sqrt.

    Example 1:

    Input: 16
    Output: true

    Example 2:

    Input: 14
    Output: false
    
    Solution by @ Davis Ching, 2019
 */
 
 class Solution {
    public boolean isPerfectSquare(int num) {
        if (num == 1) return true;
        int l = 1, r = num/2;
        while (l <= r) {
            long m = (l+r)/2;
            long square = m*m;
            if (square == num)
                return true;
            else if (square < num)
                l = (int) m + 1;
            else
                r = (int) m - 1;
        }
        return false;
     }
}
