/*
2248. Intersection of Multiple Arrays
-------------------------------------
Given a 2D integer array nums where nums[i] is a non-empty array of distinct positive integers, return the list of integers 
that are present in each array of nums sorted in ascending order. 

Example 1:
Input: nums = [[3,1,2,4,5],[1,2,3,4],[3,4,5,6]]
Output: [3,4]
Explanation: 
The only integers present in each of nums[0] = [3,1,2,4,5], nums[1] = [1,2,3,4], and nums[2] = [3,4,5,6] are 3 and 4, so we return [3,4].

Example 2:
Input: nums = [[1,2,3],[4,5,6]]
Output: []
Explanation: 
There does not exist any integer present both in nums[0] and nums[1], so we return an empty list [].

*/

//1
class Solution {
    public List<Integer> intersection(int[][] nums) {
        //in constraint
        int[] map = new int[1001];
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums[i].length;j++){
               map[nums[i][j]]++;
            }
        }
        List<Integer> res=new ArrayList<>();
        for(int i=0;i<1001;i++){
            if(map[i]==nums.length)
                res.add(i);
        }
        return res;
    }
}

//2
class Solution {
    public List<Integer> intersection(int[][] nums) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums[i].length;j++){
                map.put(nums[i][j],map.getOrDefault(nums[i][j],0)+1);
            }
        }
        List<Integer> res=new ArrayList<>();
        for(int key:map.keySet()){
            if(map.get(key)==nums.length)
                res.add(key);
        }
        return res;
    }
}
