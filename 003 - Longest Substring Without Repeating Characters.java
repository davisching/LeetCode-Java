/*  003 - Longest Substring Without Repeating Characters - From @ LeetCode.com
    
    Given a string, find the length of the longest substring without repeating characters.
    
    Example 1:
    Input: "abcabcbb"
    Output: 3 
    Explanation: The answer is "abc", with the length of 3. 

    Example 2:
    Input: "bbbbb"
    Output: 1
    Explanation: The answer is "b", with the length of 1.

    Example 3:
    Input: "pwwkew"
    Output: 3
    Explanation: The answer is "wke", with the length of 3. 

    Solution by @ Davis Ching, 2019
 */
 
 class Solution {
    public int lengthOfLongestSubstring (String s) {
        if (s == null) return 0;
        int ans = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int l = 0, r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            if (map.containsKey(c))
                l = Math.max(l, map.get(c)+1);
            map.put(c, r);
            ans = Math.max(ans, r-l+1);
        }
        return ans;
    }
}
