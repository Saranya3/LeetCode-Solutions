//1
//Using extra stack to store min values
class MinStack {
    Stack<Integer> s,min;
    /** initialize your data structure here. */
    public MinStack() {
        s=new Stack<>();
        min=new Stack<>();
    }
    
    public void push(int val) {
        s.push(val);
        if(min.isEmpty())
            min.push(val);
        else if(min.peek()>=val){
            min.push(val);
        }
    }
    
    public void pop() {
        int val=s.pop();
        if(min.peek()==val)
            min.pop();
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}

//2
//Design new stack-like structure
//Which holds min corresponding to each val in stack
class MinStack {
	private Node head;
        
    public void push(int x) {
        if (head == null) 
            head = new Node(x, x, null);
        else 
            head = new Node(x, Math.min(x, head.min), head);
    }
    
    public void pop() {
        head = head.next;
    }
    
    public int top() {
        return head.val;
    }
    
    public int getMin() {
        return head.min;
    }
        
    private class Node {
        int val;
        int min;
        Node next;
            
        private Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
}
