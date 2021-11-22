/*
106. Construct Binary Tree from Inorder and Postorder Traversal
---------------------------------------------------------------
Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.

Example 1:
Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
Output: [3,9,20,null,null,15,7]

Example 2:
Input: inorder = [-1], postorder = [-1]
Output: [-1]

*/

class Solution {
    
    HashMap<Integer,Integer> h=new HashMap<>();
    private int idx;
    
    TreeNode build(int[] inorder, int[] postorder, int start,int end){
        if (start>end) return null;
        int val=postorder[idx--];
        TreeNode node = new TreeNode(val);
        if (start==end) return node;
        
        
        node.right = build(inorder, postorder, h.get(val)+1, end);
        node.left = build(inorder, postorder, start, h.get(val)-1);
        return node;
    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        idx = postorder.length-1;
        for(int i=0; i<inorder.length; i++) {
            h.put(inorder[i],i);
        }
       
        TreeNode root = build(inorder, postorder, 0, idx);
        return root;
    }
    
}
