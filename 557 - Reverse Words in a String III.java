/*  557 - Reverse Words in a String III - From @ LeetCode.com
    
    Given a string, you need to reverse the order of characters in each word 
    within a sentence while still preserving whitespace and initial word order.

    Example 1:

    Input: "Let's take LeetCode contest"
    Output: "s'teL ekat edoCteeL tsetnoc"

    Note: In the string, each word is separated by single space and there will not be any extra space in the string. 
    
    Solution by @ Davis Ching, 2019
 */
 
 class Solution {
    public String reverseWords(String s) {
       StringBuilder ans = new StringBuilder();
       for (String word : s.split(" ")) {
           ans.append(new StringBuilder(word).reverse());
           ans.append(' ');
       }
       return ans.deleteCharAt(ans.length()-1).toString();
    }
}
