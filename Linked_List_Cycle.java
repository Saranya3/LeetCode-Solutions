//1
//Fsat-Slow ptr
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow=head,fast=head;
        
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            
            if(fast==slow)
                return true;
        }
        
        return false;
    }
}
//2
public class Solution {
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        
        while(head !=null){
            if(!set.add(head)){
                return true;
            }
            head = head.next;
        }
        return false;
    }
}
