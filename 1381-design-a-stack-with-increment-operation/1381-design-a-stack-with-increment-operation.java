class CustomStack {

    private final int maxSize;
    private final Deque<Integer> stack;

    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new ArrayDeque(maxSize);
    }
    
    public void push(int x) {
        if (stack.size() < maxSize) {
            stack.add(x);
        }
    }
    
    public int pop() {
        return stack.isEmpty() ? -1 : stack.removeLast();
    }
    
    public void increment(int k, int val) {
        int count = 0;
        int element;
        while (count < stack.size()) {
            element = stack.pop();
            element = count < k ? element + val : element;
            
            stack.add(element);

            count++;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */