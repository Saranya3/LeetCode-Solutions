/*
707. Design Linked List
-----------------------
Design your implementation of the linked list. You can choose to use a singly or doubly linked list.
A node in a singly linked list should have two attributes: val and next. val is the value of the current node, and next is a pointer/reference to the next node.
If you want to use the doubly linked list, you will need one more attribute prev to indicate the previous node in the linked list. Assume all nodes in the linked list are 0-indexed.

Implement the MyLinkedList class:

MyLinkedList() Initializes the MyLinkedList object.
int get(int index) Get the value of the indexth node in the linked list. If the index is invalid, return -1.
void addAtHead(int val) Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
void addAtTail(int val) Append a node of value val as the last element of the linked list.
void addAtIndex(int index, int val) Add a node of value val before the indexth node in the linked list. If index equals the length of the linked list, the node will be appended to the end of the linked list. If index is greater than the length, the node will not be inserted.
void deleteAtIndex(int index) Delete the indexth node in the linked list, if the index is valid.
 

Example 1:
Input
["MyLinkedList", "addAtHead", "addAtTail", "addAtIndex", "get", "deleteAtIndex", "get"]
[[], [1], [3], [1, 2], [1], [1], [1]]
Output
[null, null, null, null, 2, null, 3]

Explanation
MyLinkedList myLinkedList = new MyLinkedList();
myLinkedList.addAtHead(1);
myLinkedList.addAtTail(3);
myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3
myLinkedList.get(1);              // return 2
myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
myLinkedList.get(1);              // return 3
*/
class MyLinkedList {
    class Node{
        int val;
        Node next,prev;
        Node(int val){
            this.val=val;
            this.next=null;
            this.prev=null;
        }
    }
    int size;
    Node head,tail;
    /** Initialize your data structure here. */
    public MyLinkedList() {
        head=new Node(-1);
        tail=new Node(-1);
        head.next=tail;
        tail.prev=head;
        size=0;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        int id=-1;
        Node cur=head.next;
        while(cur!=null ){
            id++;
            if(id==index)
                return cur.val;
            cur=cur.next;
        }
        return -1;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node tmp=new Node(val);
        tmp.next=head.next;
        tmp.prev=head;
        head.next.prev=tmp;
        head.next=tmp;  
        size++;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node tmp=new Node(val);
        tmp.prev=tail.prev;
        tail.prev.next=tmp;
        tail.prev=tmp;
        tmp.next=tail;
        size++;
        
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        int id=-1;
        Node node=new Node(val);
        Node cur=head.next;
        while(cur!=null){
            id++;
            if(id==index){
                node.prev=cur.prev;
                cur.prev.next=node;
                cur.prev=node;
                node.next=cur;
                break; 
            }
            cur=cur.next;
        }
        size++;
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        int id=-1;
        Node cur=head.next;
        while(cur!=null){
            id++;
            if(id==index && id<size){
                cur.next.prev=cur.prev;
                cur.prev.next=cur.next;
                size--;
                return; 
            }
            cur=cur.next;
        }
        
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
