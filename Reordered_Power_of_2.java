/*
869. Reordered Power of 2
-------------------------

You are given an integer n. We reorder the digits in any order (including the original order) such that the leading digit is not zero.
Return true if and only if we can do this so that the resulting number is a power of two.

Example 1:
Input: n = 1
Output: true

Example 2:
Input: n = 10
Output: false
*/

class Solution {
    public boolean reorderedPowerOf2(int n) {
        //Compare count of powers of 2 and the given number n
        int[] count=helper(n);
        
        for(int i=0;i<31;i++){
            if(Arrays.equals(count,helper(1<<i))){
                return true;
            }
        }
        return false;
    }
    
    int[] helper(int n){
        int[] count=new int[10];
        while(n>0){
            count[n%10]++;
            n=n/10;
        }
        return count;
    }
    
}
