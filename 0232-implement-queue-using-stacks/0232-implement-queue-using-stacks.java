class MyQueue {
    private Stack<Integer> mainStack;
    private Stack<Integer> subStack;

    public MyQueue() {
        mainStack = new Stack<>();
        subStack = new Stack<>();
    }
    
    public void push(int x) {
        if(!empty()){
            while(!empty()){
                subStack.push(pop());
            }
        }
        mainStack.push(x);
        while(!subStack.empty()){
            mainStack.push(subStack.pop());
        }
    }
    
    public int pop() {
        return mainStack.pop();
    }
    
    public int peek() {
        return mainStack.peek();
    }
    
    public boolean empty() {
        return mainStack.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */