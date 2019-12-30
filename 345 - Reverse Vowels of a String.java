/*  345 - Reverse Vowels of a String - From @ LeetCode.com
    
    Write a function that takes a string as input and reverse only the vowels of a string.

    Example 1:

    Input: "hello"
    Output: "holle"

    Example 2:

    Input: "leetcode"
    Output: "leotcede"

    Note:
    The vowels does not include the letter "y".
    
    Solution by @ Davis Ching, 2019
 */
 
 class Solution {
    public String reverseVowels(String s) {
        List<Integer> list = new ArrayList<>();
        char[] cs = s.toCharArray();
        for (int i = 0; i < s.length(); i++)
            if (isVowel(cs[i]))
                list.add(i);
        for (int i = 0, j = list.size()-1; i < j; i++, j--) 
            swap(cs, list.get(i), list.get(j));
        return String.valueOf(cs);
    }
    
    private void swap(char[] cs, int i, int j) {
        char t = cs[i]; cs[i] = cs[j]; cs[j] = t;
    }
    
    private boolean isVowel (char c) {
        switch(c) {
            case 'A': case 'a':
            case 'E': case 'e':
            case 'I': case 'i':
            case 'O': case 'o':
            case 'U': case 'u':
                return true;
            default:
                return false;
        }
    }
}
