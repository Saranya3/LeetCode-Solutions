class Solution {
    //Rotate matrix 90 degrees
    void rotate(int[][] mat){
        int n=mat.length,tmp=0;
        
        //Transpose
        for(int r=0;r<n;r++){
           for(int c=0;c<n;c++){
               if(r<c){
                   tmp=mat[r][c];
                   mat[r][c]=mat[c][r];
                   mat[c][r]=tmp;
               }
           } 
        }
        
        //Reverse Columns
        for(int r=0;r<n;r++){
           for(int c=0;c<n/2;c++){
               
               tmp=mat[r][c];
               mat[r][c]=mat[r][n-c-1];
               mat[r][n-c-1]=tmp;
               
           } 
        }
        
    }
    
    public boolean findRotation(int[][] mat, int[][] target) {
        //4 times - 0,1,2,3
        
        for(int i=0;i<4;i++){
            if(Arrays.deepEquals(mat,target)){
                return true;
            }
            rotate(mat);
        }
        return false;
    }
}
