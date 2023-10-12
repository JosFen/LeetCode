// 2nd Version: using array
class Solution {
    public boolean isValid(String s) {
        int sLen = s.length();
        if (sLen % 2 == 1) return false;

        char[] stack = new char[sLen];
        int stackTopIdx = -1;
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack[++stackTopIdx] = c;
            } else if (c == ')' && (stackTopIdx == -1 || stack[stackTopIdx--] != '(')) {
                return false;
            } else if (c == ']' && (stackTopIdx == -1 || stack[stackTopIdx--] != '[')) {
                return false;
            } else if (c == '}' && (stackTopIdx == -1 || stack[stackTopIdx--] != '{')) {
                return false;
            }
        }

        return stackTopIdx == -1;

    }
}


// // 1st Version: using Stack
// class Solution {
//     public boolean isValid(String s) {
//         Stack<Character> stack = new Stack<>();
//         int sLen = s.length();

//         if (sLen % 2 == 1) return false;
        
//         String leftBrackets = "({[";
//         String rightBrackets = ")}]";
//         for (char c : s.toCharArray()) {
//             if (leftBrackets.indexOf(c) > -1) stack.push(c);
//             else {
//                 if (stack.isEmpty()) return false;

//                 char topChar = stack.peek();
//                 if (leftBrackets.indexOf(topChar) == rightBrackets.indexOf(c)) stack.pop();
//                 else return false;
//             }
//         }
        
//        return stack.isEmpty();

//     }
// }
