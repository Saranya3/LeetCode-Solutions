//1
class Solution {
    public Node connect(Node root) {
        Queue<Node> q=new LinkedList<>();
        if(root==null)
            return root;
        q.add(root);
        Node prev=null;
        
        while(!q.isEmpty()){
            int size=q.size();
            prev=null;
            
            while(size-->0){
                Node cur=q.poll();
                cur.next=null;
                if(prev!=null){
                    prev.next=cur;
                }
                prev=cur;
                if(cur.left!=null){
                    q.add(cur.left);
                }
                
                if(cur.right!=null){
                    q.add(cur.right);
                }
                
            }
        }
        return root;
    }
}
//2
class Solution {
    public Node connect(Node root) {
        Node start=root;
        while(start!=null){
            Node cur=start;
            while(cur!=null){
               if(cur.left!=null)
                   cur.left.next=cur.right;
               if(cur.right!=null && cur.next!=null)
                   cur.right.next=cur.next.left;
               cur=cur.next;
            }
            start=start.left;
        }
        return root;
    }
}
