/*
338. Counting Bits
------------------
Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), 
ans[i] is the number of 1's in the binary representation of i.

Example 1:
Input: n = 2
Output: [0,1,1]
Explanation:
0 --> 0
1 --> 1
2 --> 10

Example 2:
Input: n = 5
Output: [0,1,1,2,1,2]
Explanation:
0 --> 0
1 --> 1
2 --> 10
3 --> 11
4 --> 100
5 --> 101
 
*/



class Solution {
    public int[] countBits(int n) {
        int[] res=new int[n+1];
        for(int i=1;i<=n;i++){
            res[i]=res[i&(i-1)]+1;
        }
        return res;
    }
}

class Solution {
    public int[] countBits(int num) {
        int[] res=new int[num+1];
        res[0]=0;
        if(num==0)
            return res;
        res[1]=1;
        for(int i=2;i<num+1;i++){
            int x=(i%2==0)?0:1;
            res[i]=res[(int)i/2]+x;
        }
        return res;
    }
}
