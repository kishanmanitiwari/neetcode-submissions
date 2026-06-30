class Solution {
    public boolean isValid(String s) {
        var stack = new ArrayDeque<Character>();

        for (var ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty())
                    return false;

                char top = stack.peek();

                if ((ch == ')' && top != '(') || (ch == '}' && top != '{')
                    || (ch == ']' && top != '[')) {
                    return false;
                }

                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
