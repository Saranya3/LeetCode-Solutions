class Solution {
    public int[] sortedSquares(int[] nums) {
        int n=nums.length;
        int[] res=new int[n];
        
        int i=0,j=n-1;
        n-=1;
        //O(N)
        //N=nums.length
        //Two pointers
        while(i<=j){
            if(Math.abs(nums[i])>=Math.abs(nums[j])){
                res[n]=nums[i]*nums[i];
                i++;
            }
            else{
                res[n]=nums[j]*nums[j];
                j--;
            }
            n--;
        }
        return res;
    }
}
