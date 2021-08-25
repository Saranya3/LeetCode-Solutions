class Solution {
    public int helper(TreeNode root,int n){
        n = n*10+root.val;
        if(root.left==null && root.right==null)
            return n;
        int l=0,r=0;
        if(root.left!=null)
            l = helper(root.left,n);
        if(root.right!=null)
            r = helper(root.right,n);
        return l+r;
    }
    public int sumNumbers(TreeNode root) {
        
        if(root==null)
            return 0;
        return helper(root,0);
        
    }
}
