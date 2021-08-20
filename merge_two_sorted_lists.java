//1
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

//2
//Recursive Solution
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null)
            return l2;
        if(l2==null)
            return l1;
        if(l1.val<l2.val){
            l1.next=mergeTwoLists(l1.next,l2);
            return l1;
        }
        else{
            l2.next=mergeTwoLists(l1,l2.next);
            return l2;
        }
    }
}
