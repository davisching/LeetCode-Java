/*  415 - Add Strings - From @ LeetCode.com
    
    Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

    Note:

        The length of both num1 and num2 is < 5100.
        Both num1 and num2 contains only digits 0-9.
        Both num1 and num2 does not contain any leading zero.
        You must not use any built-in BigInteger library or convert the inputs to integer directly.


    Solution by @ Davis Ching, 2020.
 */
 
 class Solution {
    public String addStrings(String num1, String num2) {
        
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = num1.length()-1;
        int j = num2.length()-1;
        
        while (i >= 0 || j >= 0) {
            int x = (i >= 0) ? num1.charAt(i--) - '0' : 0;
            int y = (j >= 0) ? num2.charAt(j--) - '0' : 0;
            int sum = x + y + carry;
            carry = sum/10;
            sb.insert(0, sum%10);
        }
        
        if (carry > 0)
            sb.insert(0, 1);
        
        return sb.toString();
    }
}
