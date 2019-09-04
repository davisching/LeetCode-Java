/*  049 - Two Sum - From @ LeetCode.com
    
    Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
    Output:
    [
      ["ate","eat","tea"],
      ["nat","tan"],
      ["bat"]
    ]
    
    Solution by @ Davis Ching, 2019
 */
 
 // I - Categorize by Sorted String
 class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] ca = str.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!map.containsKey(key))
                map.put(key, new ArrayList<String>());
            map.get(key).add(str);
        }
        return new ArrayList(map.values());
    }
}

// II - Categorize by Count
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        int[] counts = new int[26];
        for (String str : strs) {
            Arrays.fill(counts, 0);
            for (char c : str.toCharArray())
                counts[c-'a'] += 1;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(counts[i]);
            }
            String key = sb.toString();
            if (!map.containsKey(key))
                map.put(key, new ArrayList<String>());
            map.get(key).add(str);
        }
        return new ArrayList(map.values());
    }
}
