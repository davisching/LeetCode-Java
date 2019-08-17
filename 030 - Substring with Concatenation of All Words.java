/*  030 - Substring with Concatenation of All Words - From @ LeetCode.com
    
    You are given a string, s, and a list of words, words, that are all of the same length. 
    Find all starting indices of substring(s) in s that is a concatenation of each word 
    in words exactly once and without any intervening characters.

    Example 1:
    Input:
      s = "barfoothefoobarman",
      words = ["foo","bar"]
    Output: [0,9]
    Explanation: Substrings starting at index 0 and 9 are "barfoor" and "foobar" respectively.
    The output order does not matter, returning [9,0] is fine too.

    Example 2:
    Input:
      s = "wordgoodgoodgoodbestword",
      words = ["word","good","best","word"]
    Output: []

    Solution by @ Davis Ching, 2019
 */
 
 class Solution {
    public List<Integer> findSubstring (String s, String[] words) {
        List<Integer> ans = new LinkedList<>();
        if (words.length == 0) return ans;
        HashMap<String, Integer> map1 = new HashMap<>();
        for (String word : words)
            map1.put(word, map1.getOrDefault(word, 0)+1);
        int num = words.length, l = words[0].length();
        for (int i = 0; i <= s.length() - num*l; i++) {
            int j = 0;
            HashMap<String, Integer> map2 = new HashMap<>();
            for (; j < num; j++) {
                String str = s.substring(i + j*l, i + (j+1)*l);
                if (map1.containsKey(str)) {
                    map2.put(str, map2.getOrDefault(str, 0)+1);
                    if (map2.get(str) > map1.get(str))
                        break;
                } else break;
            }
            if (j == num)
                ans.add(i);
        }
        return ans;
    }
} 
