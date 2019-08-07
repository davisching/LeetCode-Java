/*  005 - Longest Palindromic Substring - From @ LeetCode.com
    
    Given a string s, find the longest palindromic substring in s. 
    You may assume that the maximum length of s is 1000.

    Example 1:
    Input: "babad"
    Output: "bab"
    Note: "aba" is also a valid answer.

    Example 2:
    Input: "cbbd"
    Output: "bb"

    Solution by @ Davis Ching, 2019
 */

class Solution {
    public String longestPalindrome (String s) {
        if (s == null || s.length() == 0) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int l1 = getPalindromeLength(s, i, i);
            int l2 = getPalindromeLength(s, i, i+1);
            int l = Math.max(l1, l2);
            if (l > end - start + 1) {
                start = i - (l-1)/2;
                end = i + l/2;
            }
        }
        return s.substring(start, end+1);
    }
    
    private int getPalindromeLength (String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l -= 1;
            r += 1;
        }
        return r-l-1;
    }
}
