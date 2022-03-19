/*
1309. Decrypt String from Alphabet to Integer Mapping
-----------------------------------------------------
You are given a string s formed by digits and '#'. We want to map s to English lowercase characters as follows:
Characters ('a' to 'i') are represented by ('1' to '9') respectively.
Characters ('j' to 'z') are represented by ('10#' to '26#') respectively.
Return the string formed after mapping.
The test cases are generated so that a unique mapping will always exist.

Example 1:
Input: s = "10#11#12"
Output: "jkab"
Explanation: "j" -> "10#" , "k" -> "11#" , "a" -> "1" , "b" -> "2".

Example 2:
Input: s = "1326#"
Output: "acz"
*/

class Solution {
    public String freqAlphabets(String s) {
        StringBuilder sb = new StringBuilder();
        char c =' ';
        int n=s.length();
        for (int i=0; i<n; i++){
            if (i<n-2 && s.charAt(i+2)=='#'){
                c=(char)(Integer.parseInt(s.substring(i,i+2))+'a'-1);
                sb.append(c);
                i=i+2;
            }else{
                int a = s.charAt(i)-'1'+'a';
                c = (char)a;
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
