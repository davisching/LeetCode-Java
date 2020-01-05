/*  633 - Sum of Square Numbers - From @ LeetCode.com
    
    Given a non-negative integer c, 
    your task is to decide whether there're two integers a and b such that a2 + b2 = c.

    Example 1:

    Input: 5
    Output: True
    Explanation: 1 * 1 + 2 * 2 = 5

    Example 2:

    Input: 3
    Output: False

    Solution by @ Davis Ching, 2020.
 */
 
 class Solution {
    public boolean judgeSquareSum(int c) {
        for (int i = 0; i <= (int) Math.sqrt(c); i++) {
            double n = Math.sqrt(c-i*i);
            if (n - (int)n == 0.0) return true;
        }
        return false;
    }
}
