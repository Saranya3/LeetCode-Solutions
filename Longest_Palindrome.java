/*
409. Longest Palindrome
-----------------------

Given a string s which consists of lowercase or uppercase letters, return the length 
of the longest palindrome that can be built with those letters.
Letters are case sensitive, for example, "Aa" is not considered a palindrome here.

Example 1:
Input: s = "abccccdd"
Output: 7
Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.

Example 2:
Input: s = "a"
Output: 1

Example 3:
Input: s = "bb"
Output: 2

*/

class Solution {
    public int longestPalindrome(String s) {
        int[] count = new int[128];
        for (char c: s.toCharArray())
            count[c]++;

        int ans = 0;
        for (int v: count) {
            ans += v / 2 * 2;
            if (ans % 2 == 0 && v % 2 == 1)
                ans++;
        }
        return ans;
    }
}

//2
class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        int len=0,isOdd=0;
        
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        
        for(char key:map.keySet()){
            if(map.get(key)%2==0){
                len+=map.get(key);
            }
            else{
                if(isOdd==0){
                    len+=map.get(key);
                    isOdd=1;
                }
                else{
                    len+=map.get(key)/2 * 2;
                }
            }
        }
        return len;
    }
}
