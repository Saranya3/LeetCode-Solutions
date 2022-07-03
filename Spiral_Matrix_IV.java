/*
2326. Spiral Matrix IV
----------------------
You are given two integers m and n, which represent the dimensions of a matrix.
You are also given the head of a linked list of integers.
Generate an m x n matrix that contains the integers in the linked list presented in spiral order (clockwise), 
starting from the top-left of the matrix. If there are remaining empty spaces, fill them with -1.

Return the generated matrix.

Example 1:
Input: m = 3, n = 5, head = [3,0,2,6,8,1,7,9,4,2,5,5,0]
Output: [[3,0,2,6,8],[5,0,-1,-1,1],[5,2,4,9,7]]
Explanation: The diagram above shows how the values are printed in the matrix.
Note that the remaining spaces in the matrix are filled with -1.

Example 2:
Input: m = 1, n = 4, head = [0,1,2]
Output: [[0,1,2,-1]]
Explanation: The diagram above shows how the values are printed from left to right in the matrix.
The last space in the matrix is set to -1.

*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        //Result
        int[][] res=new int[m][n];
        int r=0,c=0,col=n-1,row=m-1;
        
        while(r<=row && c<=col){
            for(int i=c;i<=col;i++){
                if(head!=null){
                  res[r][i]=head.val;
                  head=head.next;   
                }
                else
                  res[r][i]=-1;
            }
            r++;
            
            for(int i=r;i<=row;i++){
                if(head!=null){
                  res[i][col]=head.val;
                  head=head.next;   
                }
                else
                    res[i][col]=-1;
            }
            col--;
            
            if(r<=row){
               for(int i=col;i>=c;i--){
                    if(head!=null){
                        res[row][i]=head.val;
                        head=head.next;   
                    }
                    else
                        res[row][i]=-1;
                }
                row--;
            }
            
            if(c<=col){
               for(int i=row;i>=r;i--){
                    if(head!=null){
                        res[i][c]=head.val;
                        head=head.next;   
                    }
                    else
                        res[i][c]=-1;
                }
                c++;
            }
            
        }
        
        return res;
    }
}
