class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> hm=new HashMap<>();
        
        for(int i=0;i<strs.length;i++){
            char[] tmp=strs[i].toCharArray();
            Arrays.sort(tmp);
            String key=String.valueOf(tmp);
            
            if(!hm.containsKey(key))
                hm.put(key,new ArrayList());
            
            hm.get(key).add(strs[i]);
        }
        return new ArrayList(hm.values());
        
    }
}
