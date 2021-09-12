class Solution {
    //DFS
    void dfs(char[][] grid,int r,int c){
        if(r>=grid.length || c>=grid[0].length || c<0 || r<0 || grid[r][c]!='1')
            return;
        
        grid[r][c]='0';
        
        dfs(grid,r+1,c);
        dfs(grid,r,c+1);
        dfs(grid,r-1,c);
        dfs(grid,r,c-1);
    }
    public int numIslands(char[][] grid) {
        int count=0;
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    dfs(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }
}
