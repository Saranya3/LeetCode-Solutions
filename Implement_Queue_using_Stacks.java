
//1
//Pop based
class MyQueue {
    
    Stack<Integer> s1;
    Stack<Integer> s2;

    /** Initialize your data structure here. */
    public MyQueue() {
        s1=new Stack<>();
        s2=new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        //push to s1
        s1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        //pop from s2
        if(peek() != -1){
            return s2.pop();
        }
        return -1;
    }
    
    /** Get the front element. */
    public int peek() {
        if(!empty()){
           if(s2.isEmpty()){
               while(!s1.isEmpty())
                    s2.push(s1.pop());
           }
           return s2.peek();
        }
        return -1;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(s1.isEmpty() && s2.isEmpty())
            return true;
        return false;
    }
}
//2
//Push based
class MyQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    /** Initialize your data structure here. */
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        while(!stack1.isEmpty())
            stack2.push(stack1.pop());
        stack1.push(x);
        while(!stack2.isEmpty())
            stack1.push(stack2.pop());
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return stack1.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        return stack1.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty();
    }
}

