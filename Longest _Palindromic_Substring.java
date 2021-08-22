class Solution {
    boolean isPalindrome(String str){
        int l=0,r=str.length()-1;
        
        while(l<r){
            if(str.charAt(l)!=str.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }
    public String longestPalindrome(String s) {
        String res="";
        
        for(int i=0;i<s.length();i++){
            for(int j=s.length()-1;j>i;j--){
                String str = s.substring(i,j+1);
                if(str.length()>res.length() && isPalindrome(str))
                {
                    res = str;
                    break;
                }
            }
        }
        
        return (res.length()>0?res:""+s.charAt(0));
    }
}
