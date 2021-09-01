//Faster
//Swap
class Solution {
    public TreeNode invertTree(TreeNode root) {
        return invert(root);
    }
    
    TreeNode invert(TreeNode node) {
        if(node==null) {
            return null;
        }
        
        // TreeNode left = node.left;
        // TreeNode right = node.right;
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        
        invert(node.left);
        invert(node.right);
        return node;
    }
    
}
class Solution {
    public TreeNode invertTree(TreeNode root) {
        
        if(root==null)
            return null;
        TreeNode l = invertTree(root.left);
        TreeNode r = invertTree(root.right);
            
        
        root.left=r;
        root.right=l;
        
        return root;
        
    }
}
