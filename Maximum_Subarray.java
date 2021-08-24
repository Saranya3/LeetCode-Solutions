class Solution {
    public int maxSubArray(int[] nums) {
        //Kadane Algorithm
        int cur=0,sum=Integer.MIN_VALUE;
        for(int n:nums){
            cur+=n;
            sum=Math.max(sum,cur);
            if(cur<0)
                cur=0;
        }
        return sum;
    }
}
