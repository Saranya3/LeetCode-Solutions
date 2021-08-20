class Solution {
     long res = 0, total = 0, sub;
    public int maxProduct(TreeNode root) {
        //Sum of all nodes in tree
        total = helper(root); 
        helper(root);
        return (int)(res % (int)(1e9 + 7));
    }
    
    private long helper(TreeNode root) {
        if (root == null) return 0;
        //Sum of subtree
        sub = root.val + helper(root.left) + helper(root.right);
        res = Math.max(res, sub * (total - sub));
        return sub;
    }
}
