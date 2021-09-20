
/*
692. Top K Frequent Words
--------------------------

Given an array of strings words and an integer k, return the k most frequent strings.
Return the answer sorted by the frequency from highest to lowest. 
Sort the words with the same frequency by their lexicographical order.

Example 1:
Input: words = ["i","love","leetcode","i","love","coding"], k = 2
Output: ["i","love"]
Explanation: "i" and "love" are the two most frequent words.
Note that "i" comes before "love" due to a lower alphabetical order.

Example 2:
Input: words = ["the","day","is","sunny","the","the","the","sunny","is","is"], k = 4
Output: ["the","is","sunny","day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words, with the number of occurrence being 4, 3, 2 and 1 respectively.

*/
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        //Map to hold str,count
        HashMap<String,Integer> map=new HashMap<>();
        
        for(String w:words){
            map.put(w,map.getOrDefault(w,0)+1);
        }
        
        //Min heap
        //Custom sort
        //When any 2 elements have same frequency, then sort wrt lexicographical order
        
        PriorityQueue<String> pq=new PriorityQueue<>((a,b)->(map.get(a)==map.get(b)?b.compareTo(a):map.get(a)-map.get(b)));
        
        for(String key:map.keySet()){
            pq.add(key);
            if(pq.size()>k)
                pq.poll();
        }
        //Resultant List
        List list = new ArrayList<>();
        //Stored in reverse, as it is min heap
        //Most frequent element must be stored first
        while(!pq.isEmpty()){
            list.add(0,pq.poll());
        }
        return list;
    }
}
