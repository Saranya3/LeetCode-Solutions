/*
242. Valid Anagram
------------------

Given two strings s and t, return true if t is an anagram of s, and false otherwise.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, 
typically using all the original letters exactly once.

Example 1:
Input: s = "anagram", t = "nagaram"
Output: true

Example 2:
Input: s = "rat", t = "car"
Output: false

*/

class Solution {
    public boolean isAnagram(String s, String t) {
        int[] alpha=new int[26];
        
        for(char c:s.toCharArray()){
            alpha[c-'a']++;
        }
        for(char c:t.toCharArray()){
            alpha[c-'a']--;
        }
        for(int i=0;i<26;i++){
            if(alpha[i]!=0)
                return false;
        }
        return true;
    }
