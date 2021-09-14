/*
451. Sort Characters By Frequency
---------------------------------
Given a string s, sort it in decreasing order based on the frequency of characters, and return the sorted string.

Example 1:

Input: s = "tree"
Output: "eert"
Explanation: 'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.

Example 2:
Input: s = "cccaaa"
Output: "aaaccc"
Explanation: Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.

Example 3:
Input: s = "Aabb"
Output: "bbAa"
Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.

*/

class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap();        
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }      
        
        PriorityQueue <Character> pq = new PriorityQueue((a,b) -> map.get(b) - map.get(a));
        for (char c : map.keySet()) {
            pq.offer(c);
        }
        
        StringBuilder sb = new StringBuilder();       
        while (!pq.isEmpty()) {
            char c = pq.poll();
            for (int i = 0; i < map.get(c); i++) {
                sb.append(c);
            }
        }       
        return sb.toString();
    }
}
