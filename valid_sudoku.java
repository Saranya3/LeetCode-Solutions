class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++){
            Set<Character>row=new HashSet<>();
            Set<Character>col=new HashSet<>();
            Set<Character>cube=new HashSet<>();
            
            for(int j=0;j<9;j++){
              if(board[i][j]!='.' && !row.add(board[i][j])){
                  return false;
              }
              if(board[j][i]!='.' && !col.add(board[j][i])){
                  return false;
              }
             int r=3*(i/3);
             int c=3*(i%3);
            
             if(board[j/3+r][j%3+c]!='.' && !cube.add(board[j/3+r][j%3+c])){
                 return false;
             }
                
            }
            
        }
        return true;
    }
}
