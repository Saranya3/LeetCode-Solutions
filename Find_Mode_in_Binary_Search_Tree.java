class Solution {
    int prevVal = Integer.MIN_VALUE;
    int currCount = 1;
    int maxCount = 0;
    public int[] findMode(TreeNode root) {
        // iterative, inorder traversal 
        // recusively find for each node as a mode, the count of the nodes
        // corner case
        if (root == null) return new int[0];
        if (root.left == null && root.right ==null) return new int[] {root.val};
        
        List<Integer> result = new ArrayList<>();
        inorderTraversal(root, result);
        int[] resultArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }
        
        return resultArray;
    }
    
    private void inorderTraversal(TreeNode root, List<Integer> result) {
        // base case
        if (root == null) return;
        // left
        inorderTraversal(root.left, result);
        
        // visit
        // if currValue equals prev value, currCount++
        // else if currValue not equals prev value, currCount reset to 1
        int currVal = root.val;
        if (currVal == prevVal) {
            currCount++;
        }
        else {
            currCount = 1;
        }
        // if currCount is bigger than maxCount, clear list and add current, update maxCount
        // if currCount equals maxCount, add to list
        if (currCount == maxCount) {
            result.add(currVal);
        }
        else if (currCount > maxCount) {
            result.clear();
            result.add(currVal);
            maxCount = currCount;
        }
        prevVal = currVal;
        
        //right
        inorderTraversal(root.right, result);
    }
}
