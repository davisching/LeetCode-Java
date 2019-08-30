/*  044 - Wildcard Matching - From @ LeetCode.com
    
    Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.
    '?' Matches any single character.
    '*' Matches any sequence of characters (including the empty sequence).
    The matching should cover the entire input string (not partial).

    Note:
    s could be empty and contains only lowercase letters a-z.
    p could be empty and contains only lowercase letters a-z, and characters like ? or *.

    Example 1:
    Input:
    s = "aa"
    p = "a"
    Output: false
    Explanation: "a" does not match the entire string "aa".

    Example 2:
    Input:
    s = "aa"
    p = "*"
    Output: true
    Explanation: '*' matches any sequence.

    Example 3:
    Input:
    s = "cb"
    p = "?a"
    Output: false
    Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.

    Example 4:
    Input:
    s = "adceb"
    p = "*a*b"
    Output: true
    Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".

    Example 5:
    Input:
    s = "acdcb"
    p = "a*c?b"
    Output: false

    Solution by @ Davis Ching, 2019
 */
 
 class Solution {
    public boolean isMatch(String s, String p) {
        int i = 0, j = 0, i_actual = 0, j_star = -1;
        while (i < s.length()) {
            if (j < p.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
                i += 1;
                j += 1;
            } else if (j < p.length() && p.charAt(j) == '*') {
                j_star = j;
                i_actual = i;
                j += 1;
            } else if (j_star != -1) {
                j = j_star + 1;
                i_actual += 1;
                i = i_actual;
            } else return false;
        }
        for (; j < p.length(); j++)
            if (p.charAt(j) != '*')
                return false;
        return true;
    }
}
