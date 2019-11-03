/*  119 - Pascal's Triangle II - From @ LeetCode.com
    
    Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.

    Note that the row index starts from 0.

    In Pascal's triangle, each number is the sum of the two numbers directly above it.

    Example:

    Input: 3
    Output: [1,3,3,1]
    
    Follow up:
    Could you optimize your algorithm to use only O(k) extra space?
    
    Solution by @ Davis Ching, 2019
 */
 
 class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i <= Math.min(1, rowIndex); i++)
            ans.add(1);
        if (rowIndex <= 1) return ans;
        for (int i = 2; i <= rowIndex; i++) {
            int t = 1;
            for (int j = 1; j < i; j++) {
                int t2 = ans.get(j);
                ans.set(j, ans.get(j)+t);
                t = t2;
            }
            ans.add(1);
        }
        return ans;
    }
}
