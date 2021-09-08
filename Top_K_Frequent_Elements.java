class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //Count occurances
        HashMap<Integer,Integer> map=new HashMap<>();  
        for(int n:nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }
        
        //Top-k occuring element 
        //Using min heap
        Queue<Integer> pq=new PriorityQueue<>((n1,n2) -> map.get(n1)-map.get(n2));
        for(int key:map.keySet()){
            pq.add(key);
            if(pq.size()>k){
                pq.poll();
            }
        }
        
        //Result
        int idx=0;
        int[] res=new int[k];
        while(!pq.isEmpty()){
            res[idx++]=pq.poll();
        }
        
        return res;
    }
}
