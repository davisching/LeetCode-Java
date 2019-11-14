/*  151 - Reverse Words in a String - From @ LeetCode.com
    
    Given an input string, reverse the string word by word.

    Example 1:

    Input: "the sky is blue"
    Output: "blue is sky the"

    Example 2:

    Input: "  hello world!  "
    Output: "world! hello"
    Explanation: Your reversed string should not contain leading or trailing spaces.

    Example 3:

    Input: "a good   example"
    Output: "example good a"
    Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.

    Note:

    A word is defined as a sequence of non-space characters.
    Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
    You need to reduce multiple spaces between two words to a single space in the reversed string.

    Solution by @ Davis Ching, 2019
 */
 
 class Solution {
    public String reverseWords(String s) {
        List<String> words = new ArrayList<>();
        for (String word : s.split(" ")) 
            if (!word.isEmpty()) 
                words.add(0, word);
        StringBuilder sb = new StringBuilder();    
        for (int i = 0; i < words.size(); i++) {
            sb.append(words.get(i));
            if (i != words.size()-1)
                sb.append(" ");
        }
        return sb.toString();
    }
}
