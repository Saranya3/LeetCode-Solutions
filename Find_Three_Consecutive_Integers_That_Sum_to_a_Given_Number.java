/*
2177. Find Three Consecutive Integers That Sum to a Given Number
----------------------------------------------------------------
Given an integer num, return three consecutive integers (as a sorted array) that sum to num. 
If num cannot be expressed as the sum of three consecutive integers, return an empty array.

Example 1:
Input: num = 33
Output: [10,11,12]
Explanation: 33 can be expressed as 10 + 11 + 12 = 33.
10, 11, 12 are 3 consecutive integers, so we return [10, 11, 12].

Example 2:
Input: num = 4
Output: []
Explanation: There is no way to express 4 as the sum of 3 consecutive integers.
 
*/

/*
Time Complexity: O(1)
Space Complexity: O(1)


x+(x+1)+(x+2)=y
3x+3=y
x=(y-3)/3

*/

class Solution {
    public long[] sumOfThree(long num) {
        
        if((num-3)%3!=0)
            return new long[0];
        num-=3;
        
        return new long[] {num/3,num/3+1,num/3+2};
    }
}
