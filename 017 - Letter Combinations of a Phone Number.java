/*  017 - Letter Combinations of a Phone Number - From @ LeetCode.com
    
    Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
    A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

    Example:
    Input: "23"
    Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
   
    Solution by @ Davis Ching, 2019
 */
 
 class Solution {
    
    private List<String> ans = new ArrayList<>();
    
    public List<String> letterCombinations (String digits) {
        if (!digits.isEmpty())
            digitsToString("", digits);
        return ans;
    }
    
    private void digitsToString (String str, String digits) {
        if (digits.isEmpty())
            ans.add(str);
        else
            for (char c : map.get(digits.charAt(0)).toCharArray())
                digitsToString(str+c, digits.substring(1));
    }
    
    private Map<Character, String> map = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};
}
