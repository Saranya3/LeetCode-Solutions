/*
61. Rotate List
---------------
Given the head of a linked list, rotate the list to the right by k places.

Example 1:
Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]

Example 2:
Input: head = [0,1,2], k = 4
Output: [2,0,1]

*/
class Solution {
    int findLength(ListNode head){
        int size=0;
        
        while(head!=null){
            size++;
            head=head.next;
        }
        return size;
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||k==0)
            return head;
        int len=findLength(head);
        k=k%len;
        if(k==0)
            return head;
        k=len-k;
        
        ListNode prev=null,cur=head,dummy=head;
        while(k-->0){
            prev=cur;
            cur=cur.next;
        }
        prev.next=null;
        head=cur;
        while(head.next!=null){
            head=head.next;
        }
        head.next=dummy;
        head=cur;
        return head;
    }
}
