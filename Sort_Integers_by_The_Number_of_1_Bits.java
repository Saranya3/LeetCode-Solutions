/*
1356. Sort Integers by The Number of 1 Bits
-------------------------------------------

You are given an integer array arr. Sort the integers in the array in ascending order by the number of 
1's in their binary representation and in case of two or more integers have the same number of 1's you have to sort them in ascending order.
Return the array after sorting it.

Example 1:
Input: arr = [0,1,2,3,4,5,6,7,8]
Output: [0,1,2,4,8,3,5,6,7]
Explantion: [0] is the only integer with 0 bits.
[1,2,4,8] all have 1 bit.
[3,5,6] have 2 bits.
[7] has 3 bits.
The sorted array by bits is [0,1,2,4,8,3,5,6,7]

Example 2:
Input: arr = [1024,512,256,128,64,32,16,8,4,2,1]
Output: [1,2,4,8,16,32,64,128,256,512,1024]
Explantion: All integers have 1 bit in the binary representation, you should just sort them in ascending order. 

*/

//1
class Solution {
    private int count(int n){
        int ctr=0;
        while(n>0){
            if(n%2==1)
                ctr++;
            n/=2;
        }
        return ctr;
    }
    public int[] sortByBits(int[] arr) {
        Map<Integer,PriorityQueue<Integer>> map=new TreeMap<>();
        
        for(int i=0;i<arr.length;i++){
            int ctr=count(arr[i]);
            if(!map.containsKey(ctr)){
                PriorityQueue<Integer> pq=new PriorityQueue<>();
                pq.add(arr[i]);
                map.put(ctr,pq);
            }
            else{
                PriorityQueue<Integer> pq=map.get(ctr);
                pq.add(arr[i]);
                map.put(ctr,pq);
            }
        }
        int[] res=new int[arr.length];
        int k=0;
        for(int key:map.keySet()){
            PriorityQueue<Integer> pq=map.get(key);
            while(!pq.isEmpty()){
                res[k++]=pq.poll();
            }
        }
        
        return res;
    }
}

//2
class Solution {
    public int[] sortByBits(int[] arr) {
        
        Arrays.sort(arr);
        List<Integer> tmp=new ArrayList<>();
        for(int i:arr){
            tmp.add(i);
        }
        
        Collections.sort(tmp,new BitCompare());
        
        for(int i=0;i<tmp.size();i++){
            arr[i]=tmp.get(i);
        }
        return arr;
    }
}
public class BitCompare implements Comparator<Integer>{
    
    public int compare(Integer i1,Integer i2){
        if(countSetBits(i1)==countSetBits(i2))
            return 0;
        else if(countSetBits(i1)>countSetBits(i2))
            return 1;
        else 
            return -1;
    }
    
    public int countSetBits(int n){
        int ctr=0;
        while(n>0){
            ctr+=(n&1);
            n=n>>1;
        }
        return ctr;
    }
}

//3
public int[] sortByBits(int[] arr) {
        return Arrays.stream(arr)
                     .boxed()
                     .sorted(Comparator.comparingInt(i -> Integer.bitCount(i) * 10000 + i))
                     .mapToInt(i -> i)
                     .toArray();
  }
