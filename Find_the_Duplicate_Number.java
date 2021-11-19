/*
287. Find the Duplicate Number
------------------------------
Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
There is only one repeated number in nums, return this repeated number.
You must solve the problem without modifying the array nums and uses only constant extra space.

Example 1:
Input: nums = [1,3,4,2,2]
Output: 2

Example 2:
Input: nums = [3,1,3,4,2]
Output: 3

Example 3:
Input: nums = [1,1]
Output: 1

Example 4:
Input: nums = [1,1,2]
Output: 1

*/


class Solution {
    /*
    Possible Solutions
    1. Sort & find
    2. Set/Map
    3. Fast/Slow pointer
    */
    
    //Fast/Slow ptr
    //Time Complexity: O(n)
    //Space Complexity: O(1)
    
    public int findDuplicate(int[] nums) {
        int slow=nums[0],fast=nums[0];
        
        do{
            slow=nums[slow];
            fast=nums[nums[fast]];
        }while(slow!=fast);
        
        slow=nums[0];
        while(slow!=fast){
            slow=nums[slow];
            fast=nums[fast];
        }
            
        return slow;
    }
}
