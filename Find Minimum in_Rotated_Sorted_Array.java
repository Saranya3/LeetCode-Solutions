//1
class Solution {
    public int findMin(int[] nums) {
        int lo = 0, hi = nums.length-1;
        while (lo < hi) {
            int mid = lo + (hi-lo)/2;
            if (nums[mid] < nums[hi]) {
                hi = mid;
            } else {
                lo = mid+1;
            }
        }
        return nums[lo];
    }
}

//2
class Solution {
    public int findMin(int[] nums) {
        //Find position of rotation
        int pos=0;
        int start=0,end=nums.length-1;
        
        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]<nums[0]){
                pos=mid;
                end=mid-1;
            }
            else{
                start=mid+1;
            }
            
        }    
        
        return Math.min(nums[0],nums[pos]);
        
    }
}
