/*
1007. Minimum Domino Rotations For Equal Row
--------------------------------------------
In a row of dominoes, tops[i] and bottoms[i] represent the top and bottom halves of the ith domino. 
(A domino is a tile with two numbers from 1 to 6 - one on each half of the tile.)
We may rotate the ith domino, so that tops[i] and bottoms[i] swap values.
Return the minimum number of rotations so that all the values in tops are the same, or all the values in bottoms are the same.
If it cannot be done, return -1.

Example 1:
Input: tops = [2,1,2,4,2,2], bottoms = [5,2,6,2,3,2]
Output: 2
Explanation: 
The first figure represents the dominoes as given by tops and bottoms: before we do any rotations.
If we rotate the second and fourth dominoes, we can make every value in the top row equal to 2, as indicated by the second figure.

Example 2:
Input: tops = [3,5,1,2,3], bottoms = [3,6,3,3,4]
Output: -1
Explanation: 
In this case, it is not possible to rotate the dominoes to make one row of values equal.

*/

class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        //Counting occurances
        //Domioes numbered 1-6
        int[] ctop=new int[7];
        int[] cbottom=new int[7];
        //If top & bottom are same
        int[] same=new int[7];
        //length of arrays
        int n=tops.length;
        
        for(int i=0;i<tops.length;i++){
            ctop[tops[i]]++;
            cbottom[bottoms[i]]++;
            if(tops[i]==bottoms[i])
                same[tops[i]]++;
        }
        
        //Checking if ctop[x]+cbottom[x]-same[x]==n ?
        for(int i=1;i<7;i++){
            if(ctop[i]+cbottom[i]-same[i] == n){
                return n-Math.max(ctop[i],cbottom[i]);
            }
        }
        
        return -1;
    }
}
