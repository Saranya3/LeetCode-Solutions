class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int maxCur=0,max=Integer.MIN_VALUE,min=Integer.MAX_VALUE,minCur=0;
        int sum=0;
        
        for(int n:nums){
            maxCur=Math.max(maxCur+n,n);
            max=Math.max(max,maxCur);
            
            minCur=Math.min(minCur+n,n);
            min=Math.min(min,minCur);
            
            sum+=n;
        }
        
        return (max>0) ? Math.max(max,sum-min):max;
    }
}
