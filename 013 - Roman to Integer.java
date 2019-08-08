/*  013 - Roman to Integer - From @ LeetCode.com
    
    Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

    Symbol       Value
    I             1
    V             5
    X             10
    L             50
    C             100
    D             500
    M             1000

    Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.

    Example 1:
    Input: "III"
    Output: 3

    Example 2:
    Input: "IV"
    Output: 4

    Example 3:
    Input: "IX"
    Output: 9

    Example 4:
    Input: "LVIII"
    Output: 58
    Explanation: L = 50, V= 5, III = 3.

    Example 5:
    Input: "MCMXCIV"
    Output: 1994
    Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 
    Solution by @ Davis Ching, 2019
 */
 
 class Solution {
    public int romanToInt(String s) {
        int ans = 0, cur = 0;
        for (int i = 0; i < s.length()-1; i++) {
            cur = getValue(s, i);
            if (cur < getValue(s, i+1))
                ans -= cur;
            else
                ans += cur;
        }
        return ans + getValue(s, s.length()-1);
    }
    
    private int getValue (String s, int index) {
        switch (s.charAt(index)) {
            case 'I':   return 1;
            case 'V':   return 5;
            case 'X':   return 10;
            case 'L':   return 50;
            case 'C':   return 100;
            case 'D':   return 500;
            case 'M':   return 1000;
            default:    return 0;
        }
    }
}
