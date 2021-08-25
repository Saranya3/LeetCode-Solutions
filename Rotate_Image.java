class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length,tmp=0;
        
        //Transpose
        for(int r=0;r<n;r++){
            for(int c=0;c<n;c++){
                if(r<c){
                    tmp=matrix[r][c];
                    matrix[r][c]=matrix[c][r];
                    matrix[c][r]=tmp;
                }
            }
        }
        
        for(int r=0;r<n;r++){
            for(int c=0;c<n/2;c++){
                tmp=matrix[r][c];
                matrix[r][c]=matrix[r][n-c-1];
                matrix[r][n-c-1]=tmp;
            }
        }
    }
}
