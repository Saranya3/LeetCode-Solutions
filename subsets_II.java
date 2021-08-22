class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(nums);
        
        for(int i=0;i<(1<<nums.length);i++){
            List<Integer> tmp=new ArrayList<>();
            for(int j=0;j<nums.length;j++){
                if((i&(1<<j))>0){
                    tmp.add(nums[j]);
                }
            }
            if(!res.contains(tmp))
                res.add(tmp);
        }
        
        return res;
    }
}
