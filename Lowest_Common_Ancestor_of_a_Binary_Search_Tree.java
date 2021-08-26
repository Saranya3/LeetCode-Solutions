class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root==null)
            return null;
        
        if(p==root||q==root)
            return root;
        
        int pval=p.val,qval=q.val;
        
        if(pval<root.val && qval<root.val){
            return lowestCommonAncestor(root.left,p,q);
        }
        else if(pval>root.val && q.val>root.val){
            return lowestCommonAncestor(root.right,p,q);
        }
        else
            return root;
        
    }
}
