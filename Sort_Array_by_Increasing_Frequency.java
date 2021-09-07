class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->(a[1]==b[1])?b[0]-a[0]:a[1]-b[1]);
        
        //Find count
        for(int n:nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }
        //Sort
        //Insert to pq
        for(int key:map.keySet()){
            pq.add(new int[]{key,map.get(key)});
        }
        
        int[] res=new int[nums.length];
        int idx=0;
        
        while(!pq.isEmpty()){
            int[] tmp=pq.poll();
            while(tmp[1]-->0){
                res[idx]=tmp[0];
                idx++;
            }
        }
        
        return res;
    }
}
