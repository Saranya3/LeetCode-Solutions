class Solution {
    public boolean canArrange(int[] arr, int k) {
        int n=arr.length;
        int[] freq=new int[k];
        //Arrays.fill(freq,0);
        
        for(int a:arr){
            int idx=a%k;
            if(idx<0)
                idx+=k;
            freq[idx]++;
        }
        
        if(freq[0]%2!=0)
            return false;
        
        for(int i=1;i<=k/2;i++){
            
            if(freq[i]!=freq[k-i]){
                return false;
            }
        }
        
        return true;
    }
}
