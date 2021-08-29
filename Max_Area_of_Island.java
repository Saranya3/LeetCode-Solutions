class Solution {
     //DFS
    int ctr;
    void dfs(int[][] grid, int r, int c){
        if(r<0 || c<0 || r>=grid.length || c>=grid[0].length || grid[r][c]!=1)
            return;
        
        ctr++;
        grid[r][c]=2;
        
        dfs(grid,r+1,c);
        dfs(grid,r-1,c);
        dfs(grid,r,c+1);
        dfs(grid,r,c-1);
    }
    public int maxAreaOfIsland(int[][] grid) {
        int max=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    ctr=0;
                    dfs(grid,i,j);
                    max=Math.max(max,ctr);
                }
            }
        }
        return max;
    }
}
