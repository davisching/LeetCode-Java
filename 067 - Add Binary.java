/*  067 - Add Binary - From @ LeetCode.com
    
    Given two binary strings, return their sum (also a binary string).
    The input strings are both non-empty and contains only characters 1 or 0.

    Example 1:
    Input: a = "11", b = "1"
    Output: "100"

    Example 2:
    Input: a = "1010", b = "1011"
    Output: "10101"

    Solution by @ Davis Ching, 2019
 */
 
 class Solution {
    public String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int i = a.length()-1, j = b.length()-1, carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            sum += (i >= 0) ? a.charAt(i--)-'0' : 0;
            sum += (j >= 0) ? b.charAt(j--)-'0' : 0;
            carry = sum/2;
            ans.append(sum%2);
        }
        if (carry > 0) ans.append(carry);
        return ans.reverse().toString();
    }
}
