/*

856. Score of Parentheses
-------------------------
Given a balanced parentheses string s, return the score of the string.
The score of a balanced parentheses string is based on the following rule:

"()" has score 1.
AB has score A + B, where A and B are balanced parentheses strings.
(A) has score 2 * A, where A is a balanced parentheses string.
 
Example 1:
Input: s = "()"
Output: 1

Example 2:
Input: s = "(())"
Output: 2

Example 3:
Input: s = "()()"
Output: 2

*/

class Solution {
    public int scoreOfParentheses(String S) {
        Stack<Integer> stk=new Stack<>();
        int score=0;
        
        for(char c:S.toCharArray()){
            if(c=='('){
                stk.push(score);
                score=0;
            }
            else{
                score=stk.pop()+Math.max(score*2,1);
            }
        }
        return score;
    }
}
