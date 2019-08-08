/*  014 - Longest Common Prefix - From @ LeetCode.com
    
    Write a function to find the longest common prefix string amongst an array of strings.
    If there is no common prefix, return an empty string "".

    Example 1:
    Input: ["flower","flow","flight"]
    Output: "fl"

    Example 2:
    Input: ["dog","racecar","car"]
    Output: ""
    Explanation: There is no common prefix among the input strings.

    Solution by @ Davis Ching, 2019
 */
 
 class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        int l = 0, r = Integer.MAX_VALUE;
        for (String str : strs)
            r = Math.min(r, str.length());
        while (l <= r) {
            int m = (l+r)/2;
            if (isCommonPrefix(strs, m))
                l = m + 1;
            else
                r = m - 1;
        }
        return strs[0].substring(0, (l+r)/2);
    }
    
    private boolean isCommonPrefix (String[] strs, int len) {
        String prefix = strs[0].substring(0, len);
        for (String str : strs)
            if (!str.startsWith(prefix))
                return false;
        return true;
    }
}
