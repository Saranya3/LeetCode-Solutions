//Save node (actual node) & its value in a map
//Iterate map & mark random pointers to node

//1
//Recursive
class Solution {
    HashMap<Node,Node> map=new HashMap<>();
    
    public Node copyRandomList(Node head) {
        if(head==null)
            return head;
        
        if(map.containsKey(head))
            return map.get(head);
        else{
            Node cur=new Node(head.val);
            map.put(head,cur);
            cur.next=copyRandomList(head.next);
            cur.random=copyRandomList(head.random);
            return cur;
        }
        
    }
}
//2
class Solution {  
    
    public Node copyRandomList(Node head) {
        HashMap<Node,Node> map=new HashMap<>();
        
        if(head==null)
            return head;
        
        Node cur=head;
        
        while(cur!=null){
            map.put(cur,new Node(cur.val));
            cur=cur.next;
        }
        
        for(Node n:map.keySet()){
            Node node=map.get(n);
            node.next=map.get(n.next);
            node.random=map.get(n.random);
        }
        
        return map.get(head);
        
    }
}
