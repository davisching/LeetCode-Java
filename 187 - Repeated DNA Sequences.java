/*  187 - Repeated DNA Sequences - From @ LeetCode.com
    
    All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, 
    for example: "ACGAATTCCG". 
    When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

    Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

    Example:

    Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"

    Output: ["AAAAACCCCC", "CCCCCAAAAA"]
    
    Solution by @ Davis Ching, 2020.
 */
 
 class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> set = new HashSet<>();
        Set<String> res = new HashSet<>();
        for (int i = 0; i <= s.length()-10; i++) {
            String cur = s.substring(i, i+10);
            if (!set.add(cur))
                res.add(cur);
        }
        return new ArrayList(res);
    }
}
