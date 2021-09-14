/*
917. Reverse Only Letters
--------------------------

Given a string s, reverse the string according to the following rules:

All the characters that are not English letters remain in the same position.
All the English letters (lowercase or uppercase) should be reversed.
Return s after reversing it.

Example 1:
Input: s = "ab-cd"
Output: "dc-ba"

Example 2:
Input: s = "a-bC-dEf-ghIj"
Output: "j-Ih-gfE-dCba"

Example 3:
Input: s = "Test1ng-Leet=code-Q!"
Output: "Qedo1ct-eeLg=ntse-T!"

*/

class Solution {
    public String reverseOnlyLetters(String S) {
        String res="";
        Stack<Character> stk=new Stack<>();
        for(int i=0;i<S.length();i++){
            if(Character.isLetter(S.charAt(i))){
                stk.push(S.charAt(i));
            }
        }
        
        for(int i=0;i<S.length();i++){
            if(Character.isLetter(S.charAt(i))){
                res+=stk.pop();
            }
            else{
                res+=S.charAt(i);
            }
        }
        return res;
    }
}
