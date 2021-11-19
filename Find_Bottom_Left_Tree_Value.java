/*
513. Find Bottom Left Tree Value
--------------------------------
Given the root of a binary tree, return the leftmost value in the last row of the tree.

Example 1:
Input: root = [2,1,3]
Output: 1

Example 2:
Input: root = [1,2,3,4,null,5,6,null,null,7]
Output: 7

*/


class Solution {
    public int findBottomLeftValue(TreeNode root) {
        int res=-1;
        Queue<TreeNode> q=new LinkedList<>();
        
        if(root==null)
            return -1;
        q.add(root);
        
        while(!q.isEmpty()){
            int size=q.size();
            res=q.peek().val;
            
            while(size-->0){
                TreeNode cur=q.poll();
            
                if(cur.left!=null)
                    q.add(cur.left);
                if(cur.right!=null)
                    q.add(cur.right);
            }
        }
        
        return res;
    }
}
