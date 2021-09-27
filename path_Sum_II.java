/*
113. Path Sum II
-----------------
Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node values 
in the path equals targetSum. Each path should be returned as a list of the node values, not node references.
A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.

Example 1:
Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
Output: [[5,4,11,2],[5,8,4,5]]
Explanation: There are two paths whose sum equals targetSum:
5 + 4 + 11 + 2 = 22
5 + 8 + 4 + 5 = 22

Example 2:
Input: root = [1,2,3], targetSum = 5
Output: []

Example 3:
Input: root = [1,2], targetSum = 0
Output: []

*/

class Solution {
    List<List<Integer>> res;
    
    void helper(TreeNode root, int sum, int target, List<Integer> tmp){
        if(root==null)
            return;
        
        //NLR
        sum+=root.val;
        tmp.add(root.val);
        if(sum==target && root.left==null && root.right==null){
            res.add(new ArrayList<>(tmp));
        }
        
        helper(root.left,sum,target,tmp);
        helper(root.right,sum,target,tmp);
        tmp.remove(tmp.size()-1);
        
    }
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        res=new ArrayList<>();
        helper(root,0,targetSum,new ArrayList<>());
        return res;
    }
}
