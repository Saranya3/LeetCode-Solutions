class Solution {
    private List<TreeNode> genTreeList (int start, int end) {
        List<TreeNode> list = new ArrayList<TreeNode>(); 
        if (start > end) {
            list.add(null);
        }
        for(int idx = start; idx <= end; idx++) {
           List<TreeNode> leftList = genTreeList(start, idx - 1);
           List<TreeNode> rightList = genTreeList(idx + 1, end);
            for (TreeNode left : leftList) {
                for(TreeNode right: rightList) {
                     TreeNode root = new TreeNode(idx);
                     root.left = left;
                     root.right = right;
                     list.add(root);
                }
            }
        }
        return list;
    }
    public List<TreeNode> generateTrees(int n) {
        return genTreeList(1,n);
    }
}
