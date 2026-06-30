class MinStack {

    ArrayDeque<Long> stack;
    long min;

    public MinStack() {

        stack = new ArrayDeque<>();
    }

    public void push(int val) {

        long value = val;

        // first element
        if (stack.isEmpty()) {

            stack.push(value);
            min = value;
        }

        // normal push
        else if (value >= min) {

            stack.push(value);
        }

        // encoded push
        else {

            stack.push(2 * value - min);

            min = value;
        }
    }

    public void pop() {

        long top = stack.pop();

        // encoded value
        if (top < min) {

            min = 2 * min - top;
        }
    }

    public int top() {

        long top = stack.peek();

        // encoded marker
        if (top < min) {

            return (int) min;
        }

        return (int) top;
    }

    public int getMin() {

        return (int) min;
    }
}