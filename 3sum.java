
/*
15. 3Sum
------------

Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, 
and nums[i] + nums[j] + nums[k] == 0.
Notice that the solution set must not contain duplicate triplets.

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Example 2:

Input: nums = []
Output: []
Example 3:

Input: nums = [0]
Output: []
 

*/
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
