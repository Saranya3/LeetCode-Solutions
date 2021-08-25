class Solution {
    
    void helper(List<List<Integer>> res,List<Integer> tmp,int idx,int n,int k){
        if(tmp.size()>k)
            return;
        else if(tmp.size()==k){
            
            res.add(new ArrayList<>(tmp));
            
        }
        else{
            for(int i=idx;i<=n;i++){
                if(tmp.contains(i)){
                    continue;   
                }
                tmp.add(i);
                //Can't reuse
                helper(res,tmp,i+1,n,k);
                //Backtrack
                tmp.remove(tmp.size()-1);
            }
        }
    }
    
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res=new ArrayList<>();
        
        helper(res,new ArrayList<>(),1,n,k);
        return res;
    }
}
