class Solution {
    ListNode helper(ListNode l1,ListNode l2){
        ListNode res=new ListNode(0,null);
        ListNode dummy=res;
        
        while(l1!=null && l2!=null){
            if(l1.val<=l2.val){
                res.next=new ListNode(l1.val,null);
                l1=l1.next;
            }
            else{
                res.next=new ListNode(l2.val,null);
                l2=l2.next;
            }
            res=res.next;
        }
        while(l1!=null){
           
            res.next=new ListNode(l1.val,null);
            l1=l1.next;
            res=res.next;
        }
        while(l2!=null){
    
            res.next=new ListNode(l2.val,null);
            l2=l2.next;
            res=res.next;
        }
        
        return dummy.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0){
            return null;
        }
        ListNode result=lists[0];
        for(int i=1;i<lists.length;i++){
            result=helper(result,lists[i]);
        }
        return result;
    }
}
