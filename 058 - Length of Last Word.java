/*  058 - Two Sum - From @ LeetCode.com
    
    Given a string s consists of upper/lower-case alphabets and empty space characters ' ', 
    return the length of last word in the string.

    If the last word does not exist, return 0.
    Note: A word is defined as a character sequence consists of non-space characters only.

    Example:
    Input: "Hello World"
    Output: 5
   
    Solution by @ Davis Ching, 2019
 */
 
 class Solution {
    public int lengthOfLastWord(String s) {
        int ans = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            if (s.charAt(i) == ' ')
                if (ans == 0) continue; else break;
            ans += 1;
        }
        return ans;
    }
}
