class Solution {
    void dfs(int[][] isConnected,int i,int j){
        if(i<0||j<0||i>=isConnected.length||j>=isConnected[0].length||isConnected[i][j]==0){
            return;
        }
        isConnected[i][j]=0;
        isConnected[j][i]=0;
        
        for(int k=0;k<isConnected[i].length;k++){
            if(isConnected[i][k]==1){
                dfs(isConnected,i,k);
            }
        }
        
        for(int k=0;k<isConnected[j].length;k++){
            if(isConnected[j][k]==1){
                dfs(isConnected,j,k);
            }
        }
        
    }
    public int findCircleNum(int[][] isConnected) {
        int count=0;
        for(int i=0;i<isConnected.length;i++){
            
            for(int j=0;j<isConnected[0].length;j++){
                if(isConnected[i][j]==1){
                    dfs(isConnected,i,j);
                    count++;
                }
            }
        }
        return count;
    }
}
