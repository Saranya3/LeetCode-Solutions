class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        
        if(head==null)
            return head;
        if(head.next==null)
            return head;
        
        ListNode prev=head;
        ListNode cur=head.next;
        
        while(cur!=null ){
            if(prev.val==cur.val){
                prev.next=cur.next;
            }
            else{
                prev=cur;
            }
            cur=cur.next;
        }
        return head;
    }
}
