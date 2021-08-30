class Solution {
    int res = Integer.MIN_VALUE;
    public int find(TreeNode root){
        if(root==null)
            return 0;
			
		//Recursive calls
        int l = find(root.left);
        int r = find(root.right);
		
        //Max of (root+left), (root+right), (root), (root+left+right)
        int cur = Math.max(Math.max(l,r)+root.val, root.val); 
        int temp = Math.max(cur, l+r+root.val);
        res = Math.max(res, temp);
        return cur;
    }
    public int maxPathSum(TreeNode root) {
        find(root);
        return res;
    }
}
