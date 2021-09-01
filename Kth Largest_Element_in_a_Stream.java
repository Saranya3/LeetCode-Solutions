//Heap
//Largest element -> min heap
class KthLargest {
    PriorityQueue<Integer> pq;
    int size;
    
    public KthLargest(int k, int[] nums) {
        pq=new PriorityQueue<>();
        size=k;
        
        for(int n:nums){
            pq.add(n);
            if(pq.size()>size){
                pq.poll();
            }
        }
        
    }
    
    public int add(int val) {
        pq.add(val);
        if(pq.size()>size){
                pq.poll();
        }
        return pq.peek();
    }
}
