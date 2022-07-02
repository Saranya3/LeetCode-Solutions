/*
1465. Maximum Area of a Piece of Cake After Horizontal and Vertical Cuts
-------------------------------------------------------------------------

You are given a rectangular cake of size h x w and two arrays of integers horizontalCuts and verticalCuts where:

horizontalCuts[i] is the distance from the top of the rectangular cake to the ith horizontal cut and similarly, and
verticalCuts[j] is the distance from the left of the rectangular cake to the jth vertical cut.
Return the maximum area of a piece of cake after you cut at each horizontal and vertical position provided in the arrays 
horizontalCuts and verticalCuts. Since the answer can be a large number, return this modulo 109 + 7.

Example 1:
Input: h = 5, w = 4, horizontalCuts = [1,2,4], verticalCuts = [1,3]
Output: 4 
Explanation: The figure above represents the given rectangular cake. Red lines are the horizontal and vertical cuts. 
After you cut the cake, the green piece of cake has the maximum area.

Example 2:
Input: h = 5, w = 4, horizontalCuts = [3,1], verticalCuts = [1]
Output: 6
Explanation: The figure above represents the given rectangular cake. 
Red lines are the horizontal and vertical cuts. After you cut the cake, the green and yellow pieces of cake have the maximum area.

Example 3:
Input: h = 5, w = 4, horizontalCuts = [3], verticalCuts = [3]
Output: 9

*/

class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int mod=1000000007;
        int area=0,hi=0,wi=0;
        long maxh=0,maxw=0;
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        // hi=horizontalCuts[0];
        // wi=verticalCuts[0];
        
        for(int i=0;i<horizontalCuts.length;i++){
            maxh=Math.max(maxh,horizontalCuts[i]-hi);
            hi=horizontalCuts[i];
        }
        maxh=Math.max(maxh,h-hi);
        //System.out.println(h-hi);
        
        for(int i=0;i<verticalCuts.length;i++){
            maxw=Math.max(maxw,verticalCuts[i]-wi);
            wi=verticalCuts[i];
        }
        maxw=Math.max(maxw,w-wi);
        //System.out.println(w-wi);
        
        return (int)(maxh%mod*maxw%mod)%mod;
    }
}
