/*
148. Sort List
--------------
Given the head of a linked list, return the list after sorting it in ascending order.

Example 1:
Input: head = [4,2,1,3]
Output: [1,2,3,4]

Example 2:
Input: head = [-1,5,3,4,0]
Output: [-1,0,3,4,5]

Example 3:
Input: head = []
Output: []
*/

class Solution {
    ListNode merge(ListNode head1,ListNode head2){
        ListNode dummy=new ListNode(-1);
        ListNode res=dummy;
        
        while(head1!=null && head2!=null){
            if(head1.val<=head2.val){
                res.next=head1;
                head1=head1.next;
            }
            else{
                res.next=head2;
                head2=head2.next;
            }
            res=res.next;
        }
        while(head1!=null){
            res.next=head1;
            head1=head1.next;
            res=res.next;
        }
        while(head2!=null){
            res.next=head2;
            head2=head2.next;
            res=res.next;
        }
        return dummy.next;
    }
    
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        
        ListNode slow=head,fast=head,prev=null;
        
        while(fast!=null && fast.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        prev.next=null;
        
        ListNode l1=sortList(head);
        ListNode l2=sortList(slow);
        
        return merge(l1,l2);
    }
}
