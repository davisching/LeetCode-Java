/*  038 - Count and Say - From @ LeetCode.com
    
    The count-and-say sequence is the sequence of integers with the first five terms as following:
    1.     1
    2.     11
    3.     21
    4.     1211
    5.     111221

    1 is read off as "one 1" or 11.
    11 is read off as "two 1s" or 21.
    21 is read off as "one 2, then one 1" or 1211.

    Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.
    Note: Each term of the sequence of integers will be represented as a string.

    Example 1:
    Input: 1
    Output: "1"

    Example 2:
    Input: 4
    Output: "1211"

    Solution by @ Davis Ching, 2019
 */
 
 class Solution {
    public String countAndSay(int n) {
        String ans = "1";
        for (int i = 1; i < n; i++)
            ans = countAndSay(ans);
        return ans;
    }
    
    private String countAndSay (String str) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            int counter = 0, j = i;
            for (; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j))
                    counter += 1;
                else break;
            }
            ans.append(counter);
            ans.append(str.charAt(i));
            i = j - 1;
        }
        return ans.toString();
    }
}
