class Solution {
   public:
    int evalRPN(vector<string>& tokens) {
        stack<int> st;

        for (auto& ch : tokens) {
            // Push the operand
            if (ch.size() > 1 || isdigit(ch[0])) {
                st.push(stoi(ch));  // std::stoi handles both single and multi-digit numbers
            } else {
                // its a operand
                // Pop the top two operands for the operation
                int val2 = st.top();
                st.pop();
                int val1 = st.top();
                st.pop();

                // Perform the operation
                if (ch == "+")
                    st.push(val1 + val2);
                else if (ch == "-")
                    st.push(val1 - val2);
                else if (ch == "*")
                    st.push(val1 * val2);
                else if (ch == "/")
                    st.push(val1 / val2);
            }
        }
        return st.top();
    }
};
