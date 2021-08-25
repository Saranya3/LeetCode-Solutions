class Solution {
    List<List<Integer>> res;
    void helper(int[] nums,int remaining,int idx,List<Integer> tmp){
        if(remaining<0)
            return;
        else if(remaining==0)
            res.add(new ArrayList<>(tmp));
        else{
            for(int i=idx;i<nums.length;i++){
                tmp.add(nums[i]);
                // not i + 1 because we can reuse same elements
                helper(nums,remaining-nums[i],i,tmp);
                //Backtrack
                //Remove last added element
                tmp.remove(tmp.size()-1);
            }
        }
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //Can reuse same element
        res=new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates,target,0,new ArrayList<>());
        return res;
    }
}
