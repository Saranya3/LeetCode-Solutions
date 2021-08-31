class Solution {
    public int[] searchRange(int[] nums, int target) {
        //Default
        int first=-1,last=-1;
        //first occurance
        int start=0,end=nums.length-1;
        
        while(start<=end){
            int mid=start+(end-start)/2;
            
            if(nums[mid]==target){
                first=mid;
                end=mid-1;
            }
            else if(nums[mid]<target)
                start=mid+1;
            else
                end=mid-1;
        }
        
        //last occurance
        start=0;
        end=nums.length-1;
        
        while(start<=end){
            int mid=start+(end-start)/2;
            
            if(nums[mid]==target){
                last=mid;
                start=mid+1;
            }
            else if(nums[mid]<target)
                start=mid+1;
            else
                end=mid-1;
        }
        
        return new int[]{first,last};
    }
}
