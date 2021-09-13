/*
572. Subtree of Another Tree
-----------------------------
Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.
A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants. The tree tree could also be considered as a subtree of itself.

Example 1:
Input: root = [3,4,5,1,2], subRoot = [4,1,2]
Output: true

Example 2:
Input: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
Output: false
*/
//1
class Solution {
    public String helper(TreeNode root){
        if(root==null)
            return "null";
        return "#"+root.val+" "+helper(root.left)+" "+helper(root.right);
    }
    public boolean isSubtree(TreeNode s, TreeNode t) {
        String s1=helper(s);
        String s2=helper(t);
        
        return s1.indexOf(s2)>=0;
    }
}

//2
class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null){
            return true;
        }
        
        if(root == null || subRoot == null){
            return false;
        }
        
        boolean curr = false;
        
        if(root.val == subRoot.val){
            curr = isEqual(root.left, subRoot.left) && isEqual(root.right, subRoot.right);
        }
        
        return curr || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    
    private boolean isEqual(TreeNode a, TreeNode b){
        if(a == null && b == null){
            return true;
        }
        
        if(a == null || b == null){
            return false;
        }
        
        if(a.val != b.val)
            return false;
        
        return isEqual(a.left, b.left) && isEqual(a.right, b.right);
    }
}
