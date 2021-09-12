//209. Minimum Size Subarray Sum
//-----------------------------------------

// Given an array of positive integers nums and a positive integer target, return the minimal length of a 
// contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr] of which the sum is greater than or equal to target. 
// If there is no such subarray, return 0 instead. 

// Example 1:

// Input: target = 7, nums = [2,3,1,2,4,3]
// Output: 2
// Explanation: The subarray [4,3] has the minimal length under the problem constraint.
// Example 2:

// Input: target = 4, nums = [1,4,4]
// Output: 1
// Example 3:

// Input: target = 11, nums = [1,1,1,1,1,1,1,1]
// Output: 0

//O(N)
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int min=Integer.MAX_VALUE;
        int count=0;
        
        for(int i=0;i<nums.length;i++){
            int sum=nums[i];
            count=1;
            for(int j=i+1;j<nums.length;j++){
                
                if(sum>=target){
                    min=Math.min(min,count);
                    break;
                }
                
                sum+=nums[j];
                count++;
                
            }
            if(sum>=target){
                 min=Math.min(min,count);
            }
        }
        
        return min==Integer.MAX_VALUE?0:min;
    }
}


