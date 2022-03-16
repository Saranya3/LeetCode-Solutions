/*
1572. Matrix Diagonal Sum
-------------------------
Given a square matrix mat, return the sum of the matrix diagonals.
Only include the sum of all the elements on the primary diagonal and all the elements 
on the secondary diagonal that are not part of the primary diagonal.

Example 1:
Input: mat = [[1,2,3],
              [4,5,6],
              [7,8,9]]
Output: 25
Explanation: Diagonals sum: 1 + 5 + 9 + 3 + 7 = 25
Notice that element mat[1][1] = 5 is counted only once.

Example 2:
Input: mat = [[1,1,1,1],
              [1,1,1,1],
              [1,1,1,1],
              [1,1,1,1]]
Output: 8

Example 3:
Input: mat = [[5]]
Output: 5

*/


//1
class Solution {
    public int diagonalSum(int[][] mat) {
        int off=0,main=0;
        int r=0,c=mat[0].length-1;
        
        for(int i=0;i<mat.length;i++){
            main+=mat[i][i];
        }
        
        while(r<mat.length && c>=0){
            if(r!=c)
                off+=mat[r][c];
            r++;
            c--;
        }
        
        return main+off;
    }
}

//2
class Solution {
    public int diagonalSum(int[][] mat) {
        int sum=0;
        int n=mat.length;
        int mid=(n%2==0)?(int)n/2-1:(int)n/2;
        for(int i=0;i<n;i++){
            sum+=mat[i][i];
            if(i!=n-1-i){
                sum+=mat[i][n-1-i];
            }
        }
        return sum;
    }
}
