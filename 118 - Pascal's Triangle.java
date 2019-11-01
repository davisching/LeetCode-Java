/*  118 - Pascal's Triangle - From @ LeetCode.com
    
    Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.

    In Pascal's triangle, each number is the sum of the two numbers directly above it.

    Example:

    Input: 5
    Output:
    [
         [1],
        [1,1],
       [1,2,1],
      [1,3,3,1],
     [1,4,6,4,1]
    ]
    
    Solution by @ Davis Ching, 2019
 */
 
 class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        if (numRows == 0) return ans;
        ans.add(new ArrayList());
        ans.get(0).add(1);
        for (int i = 1; i < numRows; i++) {
            List<Integer> cur = new ArrayList<>();
            List<Integer> last = ans.get(i-1);
            cur.add(1);
            for (int j = 1; j < i; j++)
                cur.add(last.get(j-1)+last.get(j));
            cur.add(1);
            ans.add(cur);
        }
        return ans;
    }
}
