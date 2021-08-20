class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res=new HashSet<>();
        Arrays.sort(nums);
        if(nums.length==0)
            return new ArrayList<>();
        
        for(int i=0;i<nums.length-2;i++){
            int start=i+1,end=nums.length-1;
            while(start<end){
                if((nums[i]+nums[start]+nums[end])==0){
                    res.add(Arrays.asList(nums[i],nums[start++],nums[end--]));
                }
                else if((nums[i]+nums[start]+nums[end])<0){
                    start++;
                }
                else{
                    end--;
                }
            }
        }
        
        return new ArrayList<>(res);
    }
}
