/*  050 - Pow(x, n) - From @ LeetCode.com
    
    Implement pow(x, n), which calculates x raised to the power n (xn).

    Example 1:
    Input: 2.00000, 10
    Output: 1024.00000

    Example 2:
    Input: 2.10000, 3
    Output: 9.26100

    Example 3:
    Input: 2.00000, -2
    Output: 0.25000
    Explanation: 2-2 = 1/22 = 1/4 = 0.25

    Note:
    -100.0 < x < 100.0
    n is a 32-bit signed integer, within the range [−231, 231 − 1]

    
    Solution by @ Davis Ching, 2019
 */
 
 class Solution {
    public double myPow(double x, int n) {
        return n >= 0 ? pow(x, n) : 1/pow(x, Math.abs((long) n));
    }
    
    private double pow(double x, long n) {
        double more = 1;
        if (n == 0) return 1;
        else if (n == 1) return x;
        else if ((n&1) == 1) more = x;
        double y = pow(x, n/2);
        return y * y * more;
    }
}

// OR

class Solution {
    public double myPow(double x, int n) {
        return n >= 0 ? myPow(x, (long) n) : 1/myPow(x, Math.abs((long) n));
    }
    
    private double myPow (double x, long n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        return (n&1) == 0 ? myPow(x*x, n/2) : myPow(x*x, n/2)*x;
    }
}
