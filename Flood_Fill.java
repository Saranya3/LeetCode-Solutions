class Solution {
    //DFS
    void dfs(int[][] image, int r, int c,int oldColor, int newColor){
        if(r<0 || c<0 || r>=image.length || c>=image[0].length || image[r][c]!=oldColor)
            return;
        
        image[r][c]=newColor;
        
        dfs(image,r+1,c,oldColor,newColor);
        dfs(image,r-1,c,oldColor,newColor);
        dfs(image,r,c+1,oldColor,newColor);
        dfs(image,r,c-1,oldColor,newColor);
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc]!=newColor){
            dfs(image,sr,sc,image[sr][sc],newColor);
        }
        return image;
    }
}
