/*
1091. Shortest Path in Binary Matrix
-------------------------------------

Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no clear path, return -1.
A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:
All the visited cells of the path are 0.
All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).
The length of a clear path is the number of visited cells of this path.

Example 1:
Input: grid = [[0,1],[1,0]]
Output: 2

Example 2:
Input: grid = [[0,0,0],[1,1,0],[1,1,0]]
Output: 4

Example 3:
Input: grid = [[1,0,0],[1,1,0],[1,1,0]]
Output: -1

*/

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        //BFS
        Queue<int[]> q=new LinkedList<>();
        
        //Directions
        //8 Directional
        int[] dr=new int[]{0,0,1,-1,1,1,-1,-1};
        int[] dc=new int[]{1,-1,0,0,1,-1,1,-1};
        int n=grid.length;
        int ctr=1;
        
        //Visited/not 
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;
        
        if(grid[0][0]==1 || grid[n-1][n-1]==1)
            return -1;
        
        q.add(new int[]{0,0});
        
        while(!q.isEmpty()){
            int size=q.size();
            
            while(size-->0){
                int[] cur=q.poll();
                if(cur[0]==n-1 && cur[1]==n-1)
                    return ctr;
                
                for(int i=0;i<8;i++){     
                    int r=cur[0]+dr[i],c=cur[1]+dc[i];
                    
                    if(r<0 || c<0 || r>=n || c>=n || visited[r][c])
                        continue;
                    
                    visited[r][c]=true;
                    
                    if(grid[r][c]==0){
                        q.add(new int[]{r,c});
                    }                     
                    
                }
            }
            ctr++;
            
        }
        
        return -1;
        
    }
}
