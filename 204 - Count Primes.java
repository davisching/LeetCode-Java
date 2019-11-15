/*  204 - Count Primes - From @ LeetCode.com
    
    Count the number of prime numbers less than a non-negative number, n.

    Example:

    Input: 10
    Output: 4
    Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
    
    Solution by @ Davis Ching, 2019
 */
 
 class Solution {
    public int countPrimes(int n) {
        int ans = 0;
        for (int i = 2; i < n; i++) {
            boolean isPrime = true;
            for (int k = 2; k <= (int) Math.sqrt(i); k++) 
                if (i % k == 0) {
                    isPrime = false; break;
                }
            if (isPrime) ans += 1;
        }
        return ans;
    }
}
