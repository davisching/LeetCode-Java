/*  1304 - Find N Unique Integers Sum up to Zero - From @ LeetCode.com
    
    Given an integer n, return any array containing n unique integers such that they add up to 0.

    Example 1:

    Input: n = 5
    Output: [-7,-1,1,3,4]
    Explanation: These arrays also are accepted [-5,-1,1,2,3] , [-3,-1,2,-2,4].

    Example 2:

    Input: n = 3
    Output: [-1,0,1]

    Example 3:

    Input: n = 1
    Output: [0]

    Constraints:

        1 <= n <= 1000

    Solution by @ Davis Ching, 2020.
                  and happy new year, guys!
 */
 
 class Solution {
    public int[] sumZero(int n) {
        int[] arr = new int[n];
        int sum = 0;
        for (int i = 0; i < n-1; i++) {
            arr[i] = i;
            sum += i;
        }
        arr[n-1] = -sum;
        return arr;
    }
}
