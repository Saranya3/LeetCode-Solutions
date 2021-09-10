class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode prev=dummy;
        ListNode cur=head;
        while(cur!=null){
            while(cur.next!=null && cur.next.val==prev.next.val)
                cur=cur.next;
            if(prev.next==cur)
                prev=prev.next;
            else
                prev.next=cur.next;
            cur=cur.next;
        }
        return dummy.next;
    }
}
