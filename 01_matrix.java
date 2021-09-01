class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int[][] res=new int[mat.length][mat[0].length];
        int range=mat.length*mat[0].length;
        //1st cell above & below 
        //All cells encountered before (i,j)
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                res[i][j]=range;
                if(mat[i][j]==0){
                    res[i][j]=0;
                }
                else{
                    
                    if(i-1>=0){
                        res[i][j]=Math.min(res[i][j],res[i-1][j]+1);
                    }
                    if(j-1>=0){
                        res[i][j]=Math.min(res[i][j],res[i][j-1]+1);
                    }
                }
            }
        }
        
        //All cells encountered after (i,j)
        for(int i=mat.length-1;i>=0;i--){
            for(int j=mat[0].length-1;j>=0;j--){
                if(mat[i][j]!=0){
                    if(j+1<mat[0].length){
                        res[i][j]=Math.min(res[i][j],res[i][j+1]+1);
                    }
                    if(i+1<mat.length){
                        res[i][j]=Math.min(res[i][j],res[i+1][j]+1);
                    }
                }
            }
        }
        
        
        
        return res;
    }
}
