class MinStack {
    Stack<Integer> origianlStack;
    Stack<Integer> minStack;

    public MinStack() {
        origianlStack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        origianlStack.push(val);

        if(minStack.isEmpty() || getMin() >= val){
            minStack.push(val);
        }
    }
    
    public void pop() {
        int popVal = origianlStack.pop();

        if(popVal == minStack.peek()){
            minStack.pop();
        }       
    }
    
    public int top() {
        return origianlStack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
        
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */