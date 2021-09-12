
/*
415. Add Strings
----------------

Given two non-negative integers, num1 and num2 represented as string, return the sum of num1 and num2 as a string.
You must solve the problem without using any built-in library for handling large integers (such as BigInteger). 
You must also not convert the inputs to integers directly.

Example 1:

Input: num1 = "11", num2 = "123"
Output: "134"
Example 2:

Input: num1 = "456", num2 = "77"
Output: "533"
Example 3:

Input: num1 = "0", num2 = "0"
Output: "0"
*/
class Solution {
    public String addStrings(String num1, String num2) {
        String res="";
        int i=num1.length()-1,j=num2.length()-1,carry=0,sum=0;
        
        while(i>=0 || j>=0){
            if(i>=0)
                sum+=Character.getNumericValue(num1.charAt(i));
            if(j>=0)
                sum+=Character.getNumericValue(num2.charAt(j));
            sum+=carry;
            carry=sum/10;
            sum%=10;
            
            res=(sum)+res;
            
            sum=0;
            i--;
            j--;            
        }
        if(carry>0){
            res=carry+res;
        }
        return res;
    }
}
