class Solution {
    void helper(List<List<Integer>> res,ArrayList<Integer> tmp,HashSet<Integer> set,int[] nums){
        if(tmp.size()==nums.length){
            res.add(new ArrayList<>(tmp));
            return;
        }
        else{
            for(int i=0;i<nums.length;i++){
                if(set.contains(nums[i])){
                    //Already exists
                    continue;
                }
                tmp.add(nums[i]);
                set.add(nums[i]);
                
                helper(res,tmp,set,nums);
                
                set.remove(tmp.get(tmp.size()-1));
                tmp.remove(tmp.size()-1);
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        //Final Result
        List<List<Integer>> res=new ArrayList<>();
        helper(res,new ArrayList<Integer>(),new HashSet<Integer>(),nums);
        return res;
    }
}
