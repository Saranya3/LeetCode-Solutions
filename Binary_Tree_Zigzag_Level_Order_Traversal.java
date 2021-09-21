/*
103. Binary Tree Zigzag Level Order Traversal
---------------------------------------------
Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. 
(i.e., from left to right, then right to left for the next level and alternate between).

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: [[3],[20,9],[15,7]]

Example 2:
Input: root = [1]
Output: [[1]]

Example 3:
Input: root = []
Output: []

*/

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> res=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        if(root==null)
            return res;
        boolean flag=true;
        q.add(root);
        
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> tmp=new ArrayList<>();
            while(size-->0){
                TreeNode cur=q.poll();
                tmp.add(cur.val);
                if(cur.left!=null)
                    q.add(cur.left);
                if(cur.right!=null)
                    q.add(cur.right);
            }
            if(flag==false){
                Collections.reverse(tmp);
                res.add(tmp);
                flag=true;
            }
            else{
                res.add(tmp);
                flag=false;
            }
            
        }
        return res;
    }
}
