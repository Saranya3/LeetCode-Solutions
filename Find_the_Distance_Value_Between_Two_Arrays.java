/*
1385. Find the Distance Value Between Two Arrays
------------------------------------------------
Given two integer arrays arr1 and arr2, and the integer d, return the distance value between the two arrays.
The distance value is defined as the number of elements arr1[i] such that there is not any element arr2[j] where |arr1[i]-arr2[j]| <= d.

Example 1:
Input: arr1 = [4,5,8], arr2 = [10,9,1,8], d = 2
Output: 2
Explanation: 
For arr1[0]=4 we have: 
|4-10|=6 > d=2 
|4-9|=5 > d=2 
|4-1|=3 > d=2 
|4-8|=4 > d=2 
For arr1[1]=5 we have: 
|5-10|=5 > d=2 
|5-9|=4 > d=2 
|5-1|=4 > d=2 
|5-8|=3 > d=2
For arr1[2]=8 we have:
|8-10|=2 <= d=2
|8-9|=1 <= d=2
|8-1|=7 > d=2
|8-8|=0 <= d=2

Example 2:
Input: arr1 = [1,4,2,3], arr2 = [-4,-3,6,10,20,30], d = 3
Output: 2

Example 3:
Input: arr1 = [2,1,100,3], arr2 = [-5,-2,10,-3,7], d = 6
Output: 1

*/
class Solution {
    
    //Count number of elements in arr1 -> |arr1[i]-arr2[j]| > d
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count=0;
        //Sort arr2
        //Binary Search
        Arrays.sort(arr2);
        
        for(int i=0;i<arr1.length;i++){
            if(inRange(arr2,arr1[i]-d,arr1[i]+d))
                count++;
        }
        return count;
    }
    
    private boolean inRange(int[] arr,int a,int b){
        int start=0,end=arr.length-1,mid=0;
        
        while(start<=end){
            mid=start+(end-start)/2;
            if(arr[mid]>=a && arr[mid]<=b)
                return false;
            else if(arr[mid]<a)
                start=mid+1;
            else
                end=mid-1;
        }
        return true;
    }
    
}
