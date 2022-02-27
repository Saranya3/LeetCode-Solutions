/*
2186. Minimum Number of Steps to Make Two Strings Anagram II
------------------------------------------------------------

You are given two strings s and t. In one step, you can append any character to either s or t.
Return the minimum number of steps to make s and t anagrams of each other.
An anagram of a string is a string that contains the same characters with a different (or the same) ordering.

Example 1:
Input: s = "leetcode", t = "coats"
Output: 7
Explanation: 
- In 2 steps, we can append the letters in "as" onto s = "leetcode", forming s = "leetcodeas".
- In 5 steps, we can append the letters in "leede" onto t = "coats", forming t = "coatsleede".
"leetcodeas" and "coatsleede" are now anagrams of each other.
We used a total of 2 + 5 = 7 steps.
It can be shown that there is no way to make them anagrams of each other with less than 7 steps.

Example 2:
Input: s = "night", t = "thing"
Output: 0
Explanation: The given strings are already anagrams of each other. Thus, we do not need any further steps.

*/
class Solution {
    public int minSteps(String s, String t) {
        int[] c=new int[26];
        for(int i=0;i<s.length();i++){
            c[s.charAt(i)-'a']++;
        }
        
        for(int i=0;i<t.length();i++){
            c[t.charAt(i)-'a']--;       
        }
        int count=0;
        for(int i=0;i<26;i++){
            if(c[i]!=0)
                count+=Math.abs(c[i]);       
        }
        return count;
    }
}
