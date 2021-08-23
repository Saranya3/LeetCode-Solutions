class Trie {
    class TrieNode{
        TrieNode[] children=new TrieNode[26];
        boolean end;
        
        TrieNode(){
            end=false;
            for(int i=0;i<26;i++)
                children[i]=null;
        }
        public boolean containsKey(char ch){
            return children[ch-'a']!=null;
        }

        public boolean isEnd() {
            return end;
        }
    }
    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root=new TrieNode();
    }
    
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur=root;
        int len=word.length();
        
        for(int i=0;i<len;i++){
            int idx=word.charAt(i)-'a';
            if(cur.children[idx]==null)
                cur.children[idx]=new TrieNode();
            cur=cur.children[idx];
        }
        cur.end=true;
    }
    
    public TrieNode helper(String word){
        TrieNode cur=root;
        
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            
            if(cur.containsKey(ch))
                cur=cur.children[ch-'a'];
            else
                return null;
        }
        return cur;
    }
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur=helper(word);
        return cur!=null && cur.end==true;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur=helper(prefix);
        return cur!=null;
    }
}
