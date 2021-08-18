class Solution {
    public boolean isHappy(int n) {
        
        Set<Integer> s=new HashSet<>();
        
        while(n!=1){
            int tmp=n;
            int res=0;
            while(tmp!=0){
                res+=(tmp%10)*(tmp%10);
                tmp/=10;
            }
            if(s.contains(res)){
                return false;
            }
            s.add(res);
            n=res;
        }
        return true;
    }
}
