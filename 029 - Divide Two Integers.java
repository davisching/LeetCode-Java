/*  029 - Divide Two Integers - From @ LeetCode.com
    
    Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.
    Return the quotient after dividing dividend by divisor.
    The integer division should truncate toward zero.

    Example 1:
    Input: dividend = 10, divisor = 3
    Output: 3

    Example 2:
    Input: dividend = 7, divisor = -3
    Output: -2

    Note:
    Both dividend and divisor will be 32-bit signed integers.
    The divisor will never be 0.
    Assume we are dealing with an environment which could only store integers 
    within the 32-bit signed integer range: [−231,  231 − 1]. 
    For the purpose of this problem, assume that your function returns 231 − 1 when the division result overflows.
    
    Solution by @ Davis Ching, 2019
 */
 
 class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        int a = Math.abs(dividend);
        int b = Math.abs(divisor);
        int ans = 0;
        while (a - b >= 0) {
            int x = 0;
            while (a - (b << 1 << x) >= 0)
                x += 1;
            ans += 1 << x;
            a -= b << x;
        }
        return (dividend >= 0) == (divisor >= 0) ? ans : ~ans+1;
    }
}
