/*
993. Cousins in Binary Tree
----------------------------

Given the root of a binary tree with unique values and the values of two different nodes of the tree x and y, 
return true if the nodes corresponding to the values x and y in the tree are cousins, or false otherwise.
Two nodes of a binary tree are cousins if they have the same depth with different parents.
Note that in a binary tree, the root node is at the depth 0, and children of each depth k node are at the depth k + 1.

Example 1:
Input: root = [1,2,3,4], x = 4, y = 3
Output: false

Example 2:
Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
Output: true

Example 3:
Input: root = [1,2,3,null,4], x = 2, y = 3
Output: false

*/

//BFS

//1
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        int ctr=0;
        Queue<TreeNode> q=new LinkedList<>();
        if(root==null)
            return false;
        q.add(root);
        
        while(!q.isEmpty()){
            ctr=0;
            int tmp=q.size();
            while(tmp-->0){
                TreeNode cur=q.poll();
                if(cur.left!=null && (cur.left.val==x||cur.left.val==y))
                    ctr++;
                else{
                    if(cur.right!=null && (cur.right.val==x||cur.right.val==y))
                        ctr++;
                }
                if(cur.left!=null)
                    q.add(cur.left);
                if(cur.right!=null)
                    q.add(cur.right);
            }
            if(ctr==2)
                return true;
        }
        return false;
    }
}

//2
class Solution {
    
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null)
            return false;
        
        int depth=1,px=-1,py=-1,dx=-1,dy=-1;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                TreeNode cur=q.poll();
                if((cur.left!=null && cur.left.val==x) || (cur.right!=null && cur.right.val==x)){
                    px=cur.val;
                    dx=depth;
                }
                if((cur.left!=null && cur.left.val==y) || (cur.right!=null && cur.right.val==y)){
                    py=cur.val;
                    dy=depth;
                }
                if(cur.left!=null){
                    q.add(cur.left);
                }
                if(cur.right!=null){
                    q.add(cur.right);
                }
            }
            depth++;
        }
        
        return (dx==dy && px!=py);
    }
}
