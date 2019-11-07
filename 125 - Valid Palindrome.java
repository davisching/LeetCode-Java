/*  125 - Valid Palindrome - From @ LeetCode.com
    
    Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

    Note: For the purpose of this problem, we define empty string as valid palindrome.

    Example 1:

    Input: "A man, a plan, a canal: Panama"
    Output: true

    Example 2:

    Input: "race a car"
    Output: false

    Solution by @ Davis Ching, 2019
 */
 
 class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toLowerCase().toCharArray())
            if (c >= 'a' && c <= 'z' || c >= '0' && c <= '9')
                sb.append(c);
        return sb.toString().equals(sb.reverse().toString());
    }
}