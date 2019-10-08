/*  091 - Decode Ways - From @ LeetCode.com
    
    A message containing letters from A-Z is being encoded to numbers using the following mapping:

    'A' -> 1
    'B' -> 2
    ...
    'Z' -> 26

    Given a non-empty string containing only digits, determine the total number of ways to decode it.

    Example 1:

    Input: "12"
    Output: 2
    Explanation: It could be decoded as "AB" (1 2) or "L" (12).

    Example 2:

    Input: "226"
    Output: 3
    Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).

    Solution by @ Davis Ching, 2019
 */
 
class Solution {
    public int numDecodings(String s) {
        if (s.isEmpty()) return 0;
        else return dfs(s);
    }
    
    private int dfs(String s) {
        if (s.length() == 0) return 1;
        else {
            if (s.charAt(0) == '0') return 0;
            int x = dfs(s.substring(1)), y = 0;
            if (s.length() >= 2 && (s.charAt(0) == '1' || s.charAt(0) == '2' && s.charAt(1) <= '6')) y = dfs(s.substring(2));
            return x + y;
        }
    }
}