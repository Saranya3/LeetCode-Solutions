class Solution {
    int ans=1;
    public int diameter(TreeNode root){
        if(root==null)
            return 0;
        int l = diameter(root.left);
        int r = diameter(root.right);
        ans = Math.max(ans,l+r+1);
        return Math.max(l,r)+1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        diameter(root);
        return ans-1;
    }
}
