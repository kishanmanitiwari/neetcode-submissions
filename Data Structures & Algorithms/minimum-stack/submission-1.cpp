class MinStack {
   public:
    stack<int> stk;
    MinStack() {}

    void push(int val) { stk.push(val); }

    void pop() { stk.pop(); }

    int top() { return stk.top(); }

    int getMin() {
        if (stk.empty()) return -1;

        stack<int> temp;
        int mini = stk.top();
        while (!stk.empty()) {
            mini = min(mini, stk.top());
            temp.push(stk.top());
            stk.pop();
        }

        while (!temp.empty()) {
            stk.push(temp.top());
            temp.pop();
        }

        return mini;
    }
};
