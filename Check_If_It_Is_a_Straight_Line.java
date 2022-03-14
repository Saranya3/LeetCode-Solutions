/*
1232. Check If It Is a Straight Line
-------------------------------------
You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point. 
Check if these points make a straight line in the XY plane.

Example 1:
Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
Output: true

Example 2:
Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
Output: false

*/

//Slope
public boolean checkStraightLine(int[][] coordinates) {
        int x0 = coordinates[0][0], y0 = coordinates[0][1], 
            x1 = coordinates[1][0], y1 = coordinates[1][1];
        int dx = x1 - x0, dy = y1 - y0;
        for (int[] co : coordinates) {
            int x = co[0], y = co[1];
            if (dx * (y - y1) != dy * (x - x1))
                return false;
        }
        return true;
 }
 
 //Doesn't form triangle
 class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int n = coordinates.length;
        for(int end=0;end<=n-3;end++) {
            int[] c1 = coordinates[end];
            int[] c2 = coordinates[end+1];
            int[] c3 = coordinates[end+2];
            if(!isCollinear(c1[0],c1[1],c2[0],c2[1],c3[0],c3[1])) {
                return false;
            }
        }
        return true;
    }

    private boolean isCollinear(int x1, int y1, int x2,int y2, int x3, int y3) {
        int result = x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2);
        return result==0;
    }
}
    
