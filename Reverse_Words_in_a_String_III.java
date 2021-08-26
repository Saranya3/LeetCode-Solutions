class Solution {
    String reverse(String s){
        String rev="";
        
        for(int i=0;i<s.length();i++){
            rev=s.charAt(i)+rev;
        }
        return rev;
    }
    public String reverseWords(String s) {
        String res="";
        String[] words=s.split(" ");
        int ctr=0;
        for(String word:words){
            if(ctr!=words.length-1)
                res+=reverse(word)+" ";
            else
                res+=reverse(word);
            ctr++;
        }
        return res;
    }
}
