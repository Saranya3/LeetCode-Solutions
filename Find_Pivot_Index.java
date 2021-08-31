class Solution {
    public int pivotIndex(int[] nums) {
        int sum=0,left=0;
        
        for(int n:nums){
            sum+=n;
        }
        
        for(int i=0;i<nums.length;i++){
            sum-=nums[i];
            
            if(sum==left)
                return i;
            
            left+=nums[i];
            
        }
        return -1;
    }
}
