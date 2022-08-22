/*
342. Power of Four
------------------
Given an integer n, return true if it is a power of four. Otherwise, return false.
An integer n is a power of four, if there exists an integer x such that n == 4x.

Example 1:
Input: n = 16
Output: true

Example 2:
Input: n = 5
Output: false

Example 3:
Input: n = 1
Output: true
*/
class Solution {
    public boolean isPowerOfFour(int n) {
        if(n<=0)
            return false;
        double tmp=Math.log(n)/Math.log(4);
        if(tmp-Math.floor(tmp)==0)
            return true;
        return false;
    }
}
