class Solution {
    public String modifyString(String s) {
        char[] str=s.toCharArray();
        
        for(int i=0;i<s.length();i++){
            if(str[i]=='?'){
                for(int j=0;j<26;j++){
                    char prev = (i!=0) ? str[i-1] : (char) ('a'-1);
                    char next = (i!=s.length()-1) ? str[i+1] : ('z'+1);
                    if(prev!=(char)(j+'a') && next!=(char)(j+'a')){
                        str[i]=(char)(j+'a');
                        break;
                    }
                }
                
            }
        }
        
        return String.valueOf(str);
    }
}
