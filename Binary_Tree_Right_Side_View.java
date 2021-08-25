class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        //BFS
        List<Integer> l = new ArrayList<>();
        if(root==null)
            return l;
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode cur = null;
        q.add(root);
        
        while(!q.isEmpty()){
            int temp = q.size();
            while(temp-->0){
                cur=q.remove();
                if(cur.left!=null)
                    q.add(cur.left);
                if(cur.right!=null)
                    q.add(cur.right);
            }
           l.add(cur.val); 
        }
        return l;
    }
}
