class MyStack {

    /** Initialize your data structure here. */
    Queue<Integer> q1;
    Queue<Integer> q2;
    int top;
    
    public MyStack() {
        q1=new LinkedList<>();
        q2=new LinkedList<>();
        top=-1;
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        q1.add(x);
        top=x;
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while(q1.size()>1){
            top=q1.remove();
            q2.add(top);
        }
        int res=q1.remove();
        //Swap
        Queue<Integer> tmp=q1;
        q1=q2;
        q2=tmp;
        return res;
    }
    
    /** Get the top element. */
    public int top() {
        if(!empty())
            return top;
        return -1;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        if(q1.isEmpty() && q2.isEmpty())
            return true;
        return false;
    }
}
