/*
934. Shortest Bridge
--------------------

You are given an n x n binary matrix grid where 1 represents land and 0 represents water.
An island is a 4-directionally connected group of 1's not connected to any other 1's. There are exactly two islands in grid.
You may change 0's to 1's to connect the two islands to form one island.
Return the smallest number of 0's you must flip to connect the two islands.

Example 1:
Input: grid = [[0,1],[1,0]]
Output: 1

Example 2:
Input: grid = [[0,1,0],[0,0,0],[0,0,1]]
Output: 2

Example 3:
Input: grid = [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
Output: 1

*/

class Solution {
    public int shortestBridge(int[][] grid) {
        
        Queue<int[]> q=new LinkedList<>();
        boolean[][] visited=new boolean[grid.length][grid[0].length]; 
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        boolean found = false;
        
        //DFS to find an island and mark as visited
        for(int i=0;i<grid.length;i++){
            if(found)
                break;
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    dfs(grid,i,j,visited,dirs,q);
                    found=true;
                    break;
                }
            }
        }
        
        //BFS
        int step=0;
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                int[] cur = q.poll();
                for(int[] dir:dirs){
                    int i = cur[0] + dir[0];
                    int j = cur[1] + dir[1];
                    if(i>=0&&i<grid.length&&j>=0&&j<grid[0].length&&!visited[i][j]){
                        if(grid[i][j]==1){
                            return step;
                        }
                        q.add(new int[]{i,j});
                        visited[i][j]=true;
                    }
                }
            }
            step++;
        }
        return step;
    }
    
    void dfs(int[][] grid,int r,int c,boolean[][] visited,int[][] dirs,Queue<int[]> q){
        
        if(r<0||r>=grid.length||c<0||c>=grid[0].length||visited[r][c]||grid[r][c]==0)
            return;
        
        q.add(new int[]{r,c});
        visited[r][c]=true;
        
        for(int[] dir:dirs){
            dfs(grid,r+dir[0],c+dir[1],visited,dirs,q);
        }
        
    }
    
}
