class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode cur=head,prev=null,tmp=null;
        
        while(cur!=null){
            tmp=cur.next;
            cur.next=prev;
            prev=cur;
            cur=tmp;
        }
        
        return prev;
    }
}
