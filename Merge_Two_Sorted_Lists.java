class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head=new ListNode(0,null);
        ListNode dummy=head;
        
        while(l1!=null && l2!=null){
            if(l1.val<=l2.val){
                head.next=new ListNode(l1.val,null);
                l1=l1.next;
                head=head.next;
            }
            else {
                head.next=new ListNode(l2.val,null);
                l2=l2.next;
                head=head.next;
            }
            
        }
        while(l1!=null){
            head.next=new ListNode(l1.val,null);
            l1=l1.next;
            head=head.next;
        }
        while(l2!=null){
            head.next=new ListNode(l2.val,null);
            l2=l2.next;
            head=head.next;
        }
        return dummy.next;
    }
}
