/*  007 - Reverse Integer - From @ LeetCode.com
    
    Given a 32-bit signed integer, reverse digits of an integer.

    Example 1:
    Input: 123
    Output: 321

    Example 2:
    Input: -123
    Output: -321

    Example 3:
    Input: 120
    Output: 21

    Note:
    Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: 
        [−2^31,  2^31 − 1]. 
    For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

    Solution by @ Davis Ching, 2019
 */
 
 class Solution {
    public int reverse (int x) {
        int ans = 0, pop = 0;
        while (x != 0) {
            pop = x % 10;
            if (Math.abs(ans) > Integer.MAX_VALUE/10 
            || Math.abs(ans) == Integer.MAX_VALUE/10 && pop > 1)
              return 0;
            ans = ans * 10 + pop;
            x /= 10;
        }
        return ans;
    }
}
