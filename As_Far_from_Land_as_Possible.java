/*

1162. As Far from Land as Possible
----------------------------------
Given an n x n grid containing only values 0 and 1, where 0 represents water and 1 represents land, find 
a water cell such that its distance to the nearest land cell is maximized, and return the distance. If no 
land or water exists in the grid, return -1.
The distance used in this problem is the Manhattan distance: the distance between two cells (x0, y0) and 
(x1, y1) is |x0 - x1| + |y0 - y1|.

Example 1:
Input: grid = [[1,0,1],[0,0,0],[1,0,1]]
Output: 2
Explanation: The cell (1, 1) is as far as possible from all the land with distance 2.

Example 2:
Input: grid = [[1,0,0],[0,0,0],[0,0,0]]
Output: 4
Explanation: The cell (2, 2) is as far as possible from all the land with distance 4.

*/

class Solution {
    public int maxDistance(int[][] grid) {
        int r=grid.length, c=grid[0].length, val=r*c;
        int[][] tmp=new int[r][c];
        
        //left & up
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                tmp[i][j]=val;
                //Land
                if(grid[i][j]==1){
                    tmp[i][j]=0;
                }
                else{
                    if(i-1>=0)
                        tmp[i][j]=Math.min(tmp[i][j],tmp[i-1][j]+1);
                    if(j-1>=0)
                        tmp[i][j]=Math.min(tmp[i][j],tmp[i][j-1]+1);
                }
            }
        }
        
        //right & down
        for(int i=r-1;i>=0;i--){
            for(int j=c-1;j>=0;j--){
                if(tmp[i][j]!=0){
                    if(i+1<r)
                        tmp[i][j]=Math.min(tmp[i][j],tmp[i+1][j]+1);
                    if(j+1<c)
                        tmp[i][j]=Math.min(tmp[i][j],tmp[i][j+1]+1);
                }
            }
        }
        
        int res=0;
        
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                res=Math.max(res,tmp[i][j]);
            }
        }
        
        
        return (res==0 || res>=val)?-1:res;
    }
}
