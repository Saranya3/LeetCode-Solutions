class Solution {
    int fresh;
    Queue<int[]> q=new LinkedList<>();
    
    public void helper(int[][] grid,int i,int j){
        if(i<0||j<0||i>=grid.length||j>=grid[0].length||grid[i][j]!=1)
            return;
        grid[i][j]=2;
        fresh--;
        q.add(new int[]{i,j});
    }
    
    public int orangesRotting(int[][] grid) {
        
        int time=0;
        fresh=0;
    
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                //Fresh oranges
                if(grid[i][j]==1)
                    fresh++;
                //rotting oranges
                if(grid[i][j]==2)
                    q.add(new int[]{i,j});
            }
        }
        if(fresh==0)
            return 0;
        while(!q.isEmpty()){
            time++;
            int tmp=q.size();
            while(tmp-->0){
                int[] pt=q.poll();
                helper(grid,pt[0]+1,pt[1]);
                helper(grid,pt[0]-1,pt[1]);
                helper(grid,pt[0],pt[1]+1);
                helper(grid,pt[0],pt[1]-1);
            }
        }
        
        return (fresh==0)?time-1:-1;
        
    }
}
