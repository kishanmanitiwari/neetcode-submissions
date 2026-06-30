class MinStack {

    ArrayDeque<Integer> stack;
    long min;

    public MinStack() {
        stack = new ArrayDeque<>();
    }

    public void push(int val) {
        stack.push(val);
    }

    public void pop() {

        if (!stack.isEmpty()) {
            stack.pop();
        }
    }

    public int top() {

        return stack.peek();
    }

    public int getMin() {

        if (stack.isEmpty()) {
            return -1;
        }

        ArrayDeque<Integer> tmpStack = new ArrayDeque<>();

        int mini = stack.peek();

        while (!stack.isEmpty()) {

            mini = Math.min(mini, stack.peek());

            tmpStack.push(stack.pop());
        }

        while (!tmpStack.isEmpty()) {

            stack.push(tmpStack.pop());
        }

        return mini;
    }
}