/*  072 - Edit Distance - From @ LeetCode.com
    
    Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.

    You have the following 3 operations permitted on a word:

        Insert a character
        Delete a character
        Replace a character

    Example 1:

    Input: word1 = "horse", word2 = "ros"
    Output: 3
    Explanation: 
    horse -> rorse (replace 'h' with 'r')
    rorse -> rose (remove 'r')
    rose -> ros (remove 'e')

    Example 2:

    Input: word1 = "intention", word2 = "execution"
    Output: 5
    Explanation: 
    intention -> inention (remove 't')
    inention -> enention (replace 'i' with 'e')
    enention -> exention (replace 'n' with 'x')
    exention -> exection (replace 'n' with 'c')
    exection -> execution (insert 'u')

    Solution by @ Davis Ching, 2019
 */

class Solution {
    public int minDistance(String word1, String word2) {
        int rowsLen = word2.length(), columnsLen = word1.length();
        int[][] dp = new int[rowsLen+1][columnsLen+1];
        for (int i = 0; i <= rowsLen; i++) {
            for (int j = 0; j <= columnsLen; j++) {
                if (i == 0) {
                    dp[0][j] = j;
                } else if (j == 0) {
                    dp[i][0] = i;
                } else {
                    int a = dp[i-1][j] + 1, b = dp[i][j-1] + 1;
                    int c = dp[i-1][j-1];
                    if (word1.charAt(j-1) != word2.charAt(i-1)) c += 1;
                    dp[i][j] = Math.min(a, Math.min(b, c));
                }
            }
        }
        return dp[rowsLen][columnsLen];
    }
}
