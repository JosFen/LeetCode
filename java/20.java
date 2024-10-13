// Use static array:
class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 == 1) return false;
        char[] stack = new char[s.length()];

        int top = -1;
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack[++top] = c;
            }
            else if (top >= 0) {
                if ((c == ')' && stack[top] == '(')
                 || (c == '}' && stack[top] == '{') 
                 || (c == ']' && stack[top] == '[')) {
                    top--;
                 }
                else return false;
            }
            else return false;
        }
        return (top == -1);
    }
}

// Use Stack() class:
class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 == 1) return false;

        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(') stack.push(')');
            else if (ch == '{') stack.push('}');
            else if (ch == '[') stack.push(']');
            else {
                if (stack.empty() || stack.pop() != ch) return false;
            }
        }

        return stack.empty();
    }
}


// 1st Version: using Stack
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int sLen = s.length();

        if (sLen % 2 == 1) return false;
        
        String leftBrackets = "({[";
        String rightBrackets = ")}]";
        for (char c : s.toCharArray()) {
            if (leftBrackets.indexOf(c) > -1) stack.push(c);
            else {
                if (stack.isEmpty()) return false;

                char topChar = stack.peek();
                if (leftBrackets.indexOf(topChar) == rightBrackets.indexOf(c)) stack.pop();
                else return false;
            }
        }
        
       return stack.isEmpty();

    }
}
