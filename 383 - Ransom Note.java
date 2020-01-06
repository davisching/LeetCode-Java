/*  383 - Ransom Note - From @ LeetCode.com
    
    Given an arbitrary ransom note string and another string containing letters from all the magazines, 
    write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.

    Each letter in the magazine string can only be used once in your ransom note.

    Note:
    You may assume that both strings contain only lowercase letters.

    canConstruct("a", "b") -> false
    canConstruct("aa", "ab") -> false
    canConstruct("aa", "aab") -> true

    Solution by @ Davis Ching, 2020.
 */
 
 class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] m = new int[26];
        for (char c : magazine.toCharArray())
            m[c-'a'] += 1;
        for (char c : ransomNote.toCharArray())
            if (m[c-'a']-- == 0) return false;
        return true;
    }
}


// do not use hashmap, too slow
