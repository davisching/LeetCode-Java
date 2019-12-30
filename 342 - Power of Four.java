/*  342 - Power of Four - From @ LeetCode.com
    
    Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

    Example 1:

    Input: 16
    Output: true

    Example 2:

    Input: 5
    Output: false

    Follow up: Could you solve it without loops/recursion?
    
    Solution by @ Davis Ching, 2019
 */
 
 class Solution {
    public boolean isPowerOfFour(int num) {
        return Integer.toString(num, 4).matches("10*");
    }
}
