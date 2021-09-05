class Solution {
    //4-directional
    void dfs(char[][] board,int r,int c){
        if(r<0 || c<0 || r>=board.length || c>=board[0].length || board[r][c]!='O')
            return;
        
        board[r][c]='-';
        
        dfs(board,r+1,c);
        dfs(board,r-1,c);
        dfs(board,r,c+1);
        dfs(board,r,c-1);
    }
    
    public void solve(char[][] board) {
        int n=board.length,m=board[0].length;
        //Column
        for(int i=0;i<m;i++){
            if(board[0][i]=='O')
                dfs(board,0,i);
            if(board[n-1][i]=='O')
                dfs(board,n-1,i);
        }
        //Row
        for(int i=0;i<n;i++){
            if(board[i][0]=='O')
                dfs(board,i,0);
            if(board[i][m-1]=='O')
                dfs(board,i,m-1);
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='O')
                    board[i][j]='X';
                else if(board[i][j]=='-')
                    board[i][j]='O';
            }
        }
        
    }
}
