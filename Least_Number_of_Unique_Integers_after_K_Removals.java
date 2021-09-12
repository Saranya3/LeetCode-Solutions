class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
        
        for(int key:map.keySet()){
            pq.add(new int[]{key,map.get(key)});
        }
        
        while(!pq.isEmpty()){
            if(k==0)
                break;
            int ctr[]=pq.poll();
            //System.out.println(ctr[0]+" "+ctr[1]);
            
            if(k>=ctr[1]){
                k-=ctr[1];
            }
            else{
                ctr[1]-=k;
                k=0;
                pq.add(ctr);
            }
        }
        
        return pq.size();
    }
}
