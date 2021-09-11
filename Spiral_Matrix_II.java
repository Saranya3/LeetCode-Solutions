//1
//Simulation
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] mat=new int[n][n];
        int ctr=1;
        int r=mat.length,c=mat[0].length,col=0,row=0;
        
        while(col<c && row<r){
            for(int i=col;i<c;i++){
                mat[row][i]=ctr;
                ctr++;
            }
            row++;
            for(int i=row;i<r;i++){
                mat[i][c-1]=ctr;
                ctr++;
            }
            c--;
            if(row<r){
               for(int i=c-1;i>=col;i--){
                   mat[r-1][i]=ctr;
                   ctr++;
               } 
               r--;
            }
            if(col<c){
                for(int i=r-1;i>=row;i--){
                    mat[i][col]=ctr;
                    ctr++;
                }
                col++;    
            }
        }
        return mat;
    }
}
//2
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int cnt = 1;
        int dir[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int d = 0;
        int row = 0;
        int col = 0;
        while (cnt <= n * n) {
            result[row][col] = cnt++;
            int r = Math.floorMod(row + dir[d][0], n);
            int c = Math.floorMod(col + dir[d][1], n);

            // change direction if next cell is non zero
            if (result[r][c] != 0) d = (d + 1) % 4;

            row += dir[d][0];
            col += dir[d][1];
        }
        return result;
    }
}
