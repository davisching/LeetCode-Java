/*  942 - DI String Match - From @ LeetCode.com
    
    Given a string S that only contains "I" (increase) or "D" (decrease), let N = S.length.

    Return any permutation A of [0, 1, ..., N] such that for all i = 0, ..., N-1:

        If S[i] == "I", then A[i] < A[i+1]
        If S[i] == "D", then A[i] > A[i+1]

    Example 1:

    Input: "IDID"
    Output: [0,4,1,3,2]

    Example 2:

    Input: "III"
    Output: [0,1,2,3]

    Example 3:

    Input: "DDI"
    Output: [3,2,0,1]

    Note:

        1 <= S.length <= 10000
        S only contains characters "I" or "D".
    
    Solution by @ Davis Ching, 2019
 */
 
 class Solution {
    public int[] diStringMatch(String S) {
        int[] ans = new int[S.length()+1];
        int lo = 0, hi = S.length(), idx = 0;
        for (Character c : S.toCharArray())
            ans[idx++] = c == 'I' ? lo++ : hi--;
        ans[idx] = lo;
        return ans;
    }
}
