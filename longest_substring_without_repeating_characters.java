class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i=0,j=0,n=s.length(),ctr=0;
        Set<Character> set=new HashSet<>();
        
        while(i<n && j<n){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ctr=Math.max(ctr,j-i);
            }
            else{
                set.remove(s.charAt(i++));
            }
        }
        return ctr;
    }
}
