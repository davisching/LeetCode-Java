/*  106 - Construct Binary Tree from Inorder and Postorder Traversal - From @ LeetCode.com
    
    iven inorder and postorder traversal of a tree, construct the binary tree.

    Note:
    You may assume that duplicates do not exist in the tree.

    For example, given

    inorder = [9,3,15,20,7]
    postorder = [9,15,7,20,3]

    Return the following binary tree:

        3
       / \
      9  20
        /  \
       15   7

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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1);
    }
    
    private TreeNode buildTree(int[] inorder, int[] postorder, int s1, int e1, int s2, int e2) {
        if (s1 > e1 || s2 > e2) return null;
        if (s1 == e1) return new TreeNode(inorder[s1]);
        int i = s1;
        for (; i <= e1; i++)
            if (inorder[i] == postorder[e2])
                break;
        TreeNode cur = new TreeNode(postorder[e2]);
        cur.left = buildTree(inorder, postorder, s1, i-1, s2, s2+(i-1-s1));
        cur.right = buildTree(inorder, postorder, i+1, e1, s2+(i-s1), e2-1);
        return cur;
    }
}
