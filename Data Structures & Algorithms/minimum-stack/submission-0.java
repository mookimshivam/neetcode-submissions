class MinStack {
    Stack<Integer> stack;
    public MinStack() {
        this.stack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
    }
    
    public void pop() {
        if(!stack.isEmpty())
            stack.pop();
    }
    
    public int top() {
        if(!stack.isEmpty())
            return stack.peek();
        return 0;
    }
    
    public int getMin() {
        return stack.stream().min(Comparator.comparingInt(a->a)).orElse(0);
    }
}
