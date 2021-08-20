class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk=new Stack<>();
        
        for(int i=0;i<s.length();i++){
            //Open bracket
            if(s.charAt(i)=='('||s.charAt(i)=='{'||s.charAt(i)=='['){
                stk.push(s.charAt(i));
            }
            //Close bracket
            else{
               if(!stk.isEmpty()){
                   if(stk.peek()=='(' && s.charAt(i)==')'){
                       stk.pop();
                   }
                   else if(stk.peek()=='[' && s.charAt(i)==']'){
                       stk.pop();
                   }
                   else if(stk.peek()=='{' && s.charAt(i)=='}'){
                       stk.pop();
                   }
                   else{
                       return false;
                   }
               } 
                //Empty
                else{
                    return false;
                }
            }
        }
        
        return stk.isEmpty();
    }
}
