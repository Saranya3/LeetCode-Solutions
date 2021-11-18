/*
448. Find All Numbers Disappeared in an Array
---------------------------------------------
Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.

Example 1:
Input: nums = [4,3,2,7,8,2,3,1]
Output: [5,6]

Example 2:
Input: nums = [1,1]
Output: [2]

*/

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int[] numsCount = new int[nums.length];
        
        for (int i = 0; i < nums.length; i++) {
            numsCount[nums[i] - 1]++;
        }
        
        List<Integer> missing = new ArrayList<>();
        for (int i = 0; i < numsCount.length; i++) {
            if (numsCount[i] == 0) {
                missing.add(i + 1);
            }
        }
        
        return missing;
        
    }
}
