class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int r=0,c=0,row=matrix.length,col=matrix[0].length;
        //Resultant Array
        List<Integer> res=new ArrayList<>();
       
        while(r<row && c<col){
            
            //left->right
            for(int i=c;i<col;i++){
                res.add(matrix[r][i]);
            }
            r++;
            
            //top->bottom
            for(int i=r;i<row;i++){
                res.add(matrix[i][col-1]);
            }
            col--;
            
            //right->left
            if(r<row){
                for(int i=col-1;i>=c;i--){
                    res.add(matrix[row-1][i]);
                }
                row--;
            }
            
            //bottom->up
            if(c<col){
                for(int i=row-1;i>=r;i--){
                    res.add(matrix[i][c]);
                }
                c++;
            }
            
        }
        
        return res;
    }
}
