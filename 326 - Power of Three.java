/*  326 - Power of Three - From @ LeetCode.com
    
    Given an integer, write a function to determine if it is a power of three.

    Example 1:

    Input: 27
    Output: true

    Example 2:

    Input: 0
    Output: false

    Example 3:

    Input: 9
    Output: true

    Example 4:

    Input: 45
    Output: false 
    
    Solution by @ Davis Ching, 2019
 */
 
 class Solution {
    public boolean isPowerOfThree(int n) {
        return Integer.toString(n, 3).matches("10*");
    }
}
