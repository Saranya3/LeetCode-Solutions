/*

709. To Lower Case
------------------
Given a string s, return the string after replacing every uppercase letter with the same lowercase letter.

Example 1:
Input: s = "Hello"
Output: "hello"

Example 2:
Input: s = "here"
Output: "here"

Example 3:
Input: s = "LOVELY"
Output: "lovely"

*/

//1
class Solution {
    public String toLowerCase(String s) {
        String res="";
        
        for(int i=0;i<s.length();i++){
            if((int)s.charAt(i)>=65 && (int)s.charAt(i)<=91)
                res+=(char)(s.charAt(i)+32);
            else
                res+=s.charAt(i);
        }
        return res;
    }
}

//2
class Solution {
    public String toLowerCase(String s) {
        StringBuilder res = new StringBuilder();
        
        for(int i=0;i<s.length();i++){
            res.append(Character.toLowerCase(s.charAt(i)));
        }
        
        return res.toString();
    }
}
