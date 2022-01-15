/*
1345. Jump Game IV
------------------
Given an array of integers arr, you are initially positioned at the first index of the array.

In one step you can jump from index i to index:

i + 1 where: i + 1 < arr.length.
i - 1 where: i - 1 >= 0.
j where: arr[i] == arr[j] and i != j.
Return the minimum number of steps to reach the last index of the array.

Notice that you can not jump outside of the array at any time. 

Example 1:
Input: arr = [100,-23,-23,404,100,23,23,23,3,404]
Output: 3
Explanation: You need three jumps from index 0 --> 4 --> 3 --> 9. Note that index 9 is the last index of the array.

Example 2:
Input: arr = [7]
Output: 0
Explanation: Start index is the last index. You do not need to jump.

Example 3:
Input: arr = [7,6,9,6,9,6,9,7]
Output: 1
Explanation: You can jump directly from index 0 to index 7 which is last index of the array.
 
*/
class Solution {
    public int minJumps(int[] arr) {
        if(arr.length<=1) {
            return 0;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i=0;i<arr.length;i++) {
            map.putIfAbsent(arr[i],new ArrayList<>());
            map.get(arr[i]).add(i);
        }
        
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited.add(0);
        int count = 0;
        
         while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0;i<size;i++) {
                int pop = queue.poll();
                if(pop==arr.length-1) {
                    return count;
                }
                if(pop>0 && visited.add(pop-1)) {
                    queue.add(pop-1);
                }
                if(pop<arr.length-1 && visited.add(pop+1)) {
                    queue.add(pop+1);
                }
                if(map.containsKey(arr[pop])) {
                    for (int index : map.get(arr[pop])) {
                        if(visited.add(index)) {
                            queue.add(index);
                        }
                    }
                    map.remove(arr[pop]); 
                }
            }
            count++;
        }
        return -1;
    }
}
