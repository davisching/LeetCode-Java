/*  131 - Palindrome Partitioning - From @ LeetCode.com
    
    Given a string s, partition s such that every substring of the partition is a palindrome.

    Return all possible palindrome partitioning of s.

    Example:

    Input: "aab"
    Output:
    [
      ["aa","b"],
      ["a","a","b"]
    ]
    
    Solution by @ Davis Ching, 2019
 */
 
 class Solution {
    
    private List<List<String>> ans = new ArrayList<>();
    
    public List<List<String>> partition(String s) {
        backtracking(s, 0, new ArrayList());
        return ans;
    }
    
    private void backtracking(String s, int startsAt, List<String> list) {
        if (startsAt >= s.length()) {
            ans.add(new ArrayList(list)); return;
        }
        char c = s.charAt(startsAt);
        for (int i = startsAt; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(startsAt) && isPalindrome(s, startsAt, i)) {
                list.add(s.substring(startsAt, i+1));
                backtracking(s, i+1, list);
                list.remove(list.size()-1);
            }
        }
    }
    
    private boolean isPalindrome(String s, int startsAt, int endsWith) {
        for (int i = startsAt, j = endsWith; i < j; i++, j--)
            if (s.charAt(i) != s.charAt(j))
                return false;
        return true;
    }
}
