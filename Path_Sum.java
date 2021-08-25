class Solution {
    boolean helper(TreeNode root,int targetSum,int sum){
        
        if(root==null){
            return false;
        }
        
        sum+=root.val;
        if(root.left==null && root.right==null){
            if(sum==targetSum){
                return true;
            }
        }
        return helper(root.left,targetSum,sum) || helper(root.right,targetSum,sum);
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null){
            return false;
        }
        
        return helper(root,targetSum,0);
    }
}
