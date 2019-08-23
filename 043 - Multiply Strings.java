/*  042 - Trapping Rain Water - From @ LeetCode.com
    
    Given two non-negative integers num1 and num2 represented as strings, 
    return the product of num1 and num2, also represented as a string.

    Example 1:
    Input: num1 = "2", num2 = "3"
    Output: "6"

    Example 2:
    Input: num1 = "123", num2 = "456"
    Output: "56088"

    Note:
    The length of both num1 and num2 is < 110.
    Both num1 and num2 contain only digits 0-9.
    Both num1 and num2 do not contain any leading zero, except the number 0 itself.
    You must not use any built-in BigInteger library or convert the inputs to integer directly.
 
    Solution by @ Davis Ching, 2019
 */
 
 class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] nums = new int[m+n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int p = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                p += nums[i+j+1];
                nums[i+j] += p/10;
                nums[i+j+1] = p%10;
            }
        }
        StringBuilder ans = new StringBuilder();
        for (int num : nums)
            if (!(ans.length() == 0 && num == 0))
                ans.append(num);
        return (ans.length() == 0) ? "0" : ans.toString();
    }
}
