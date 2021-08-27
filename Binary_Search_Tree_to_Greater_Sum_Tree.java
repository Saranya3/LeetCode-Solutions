//1
class Solution {
    int sum=0;
    public TreeNode bstToGst(TreeNode root) {
       if(root!=null){
            bstToGst(root.right);
            sum+=root.val;
            root.val=sum;
            bstToGst(root.left);
       }
      return root;
    }
}

//2
class Solution {
    int sum;
    void helper(TreeNode root){
        if(root==null)
            return;
        
        helper(root.right);
        sum+=root.val;
        root.val=sum;
        helper(root.left);
    }
    public TreeNode bstToGst(TreeNode root) {
        sum=0;
        helper(root);
        return root;
    }
}
