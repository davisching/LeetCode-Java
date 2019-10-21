/*  105 - Construct Binary Tree from Preorder and Inorder Traversal - From @ LeetCode.com
    
    Given preorder and inorder traversal of a tree, construct the binary tree.

    Note:
    You may assume that duplicates do not exist in the tree.

    For example, given

    preorder = [3,9,20,15,7]
    inorder = [9,3,15,20,7]

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
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }
    
    private TreeNode buildTree(int[] preorder, int[] inorder, int i1, int i2, int j1, int j2) {
        if (i2 -i1 < 0 || j2 -j1 < 0) return null;
        if (i2-i1 == 0) return new TreeNode(preorder[i1]);
        
        int val = preorder[i1], k = j1;
        for (; k < j2; k++)
            if (val == inorder[k])
                break;
        
        TreeNode cur = new TreeNode(val);
        cur.left = buildTree(preorder, inorder, i1+1, i1+k-j1, j1, k-1);
        cur.right = buildTree(preorder, inorder, i1+k-j1+1, i2, k+1, j2);
        return cur;
    }
}
