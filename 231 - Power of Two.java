/*  231 - Power of Two - From @ LeetCode.com
    
    Given an integer, write a function to determine if it is a power of two.

    Example 1:

    Input: 1
    Output: true 
    Explanation: 20 = 1

    Example 2:

    Input: 16
    Output: true
    Explanation: 24 = 16

    Example 3:

    Input: 218
    Output: false
    
    Solution by @ Davis Ching, 2019
 */
 
 class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n < 0) return false;
        int l = 0, r = 31;
        while (l <= r) {
            int m = (l+r)/2;
            double cur = Math.pow(2, m);
            if (cur == n) {
                return true;
            } else if (cur > n) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return false;
    }
}

// or 

class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n < 0) return false;
        String str = Integer.toBinaryString(n);
        int counter = 0;
        for (char c : str.toCharArray()) 
            counter += c-'0';
        return counter == 1;
    }
}
