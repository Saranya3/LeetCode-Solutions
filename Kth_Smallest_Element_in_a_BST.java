/*
230. Kth Smallest Element in a BST
----------------------------------
Given the root of a binary search tree, and an integer k, return the kth (1-indexed) smallest element in the tree.

Example 1:
Input: root = [3,1,4,null,2], k = 1
Output: 1

Example 2:
Input: root = [5,3,6,2,4,null,null,1], k = 3
Output: 3

*/

class Solution {
    int res,k;
    public void inOrder(TreeNode root){
        if(root==null)
            return;
        
        inOrder(root.left);
            
        if(--k==0){
            res=root.val;
            return;
        }
                
        inOrder(root.right);
            
    }
    public int kthSmallest(TreeNode root, int k) {
        this.k=k;
        res=0;
        inOrder(root);
        return res;
    }
}
