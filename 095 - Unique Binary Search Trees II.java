/*  095 - Unique Binary Search Trees II - From @ LeetCode.com
    
    Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.

    Example:

    Input: 3
    Output:
    [
    [1,null,3,2],
    [3,2,null,1],
    [3,1,null,null,2],
    [2,1,3],
    [1,null,2,null,3]
    ]
    Explanation:
    The above output corresponds to the 5 unique BST's shown below:

    1         3     3      2      1
        \       /     /      / \      \
        3     2     1      1   3      2
        /     /       \                 \
    2     1         2                 3

    Solution by @ Davis Ching, 2019
 */
 
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList();
        return generateTrees(1, n);
    }
    
    private List<TreeNode> generateTrees (int from, int to) {
        List<TreeNode> ans = new ArrayList<>();
        if (from > to) ans.add(null);
        for (int i = from; i <= to; i++) {
            List<TreeNode> lefts = generateTrees(from, i-1);
            List<TreeNode> rights = generateTrees(i+1, to);
            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    ans.add(root);
                }
            } 
        }
        return ans;
    }
}