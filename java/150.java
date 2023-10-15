// 2nd Version: using array
class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens.length == 1) return Integer.parseInt(tokens[0]);
        
        int[] stack = new int[tokens.length];
        int top = -1;
        int result = 0;

        for (String c : tokens) {
            switch(c) {
                case "+":
                    result = stack[top - 1] + stack[top];
                    stack[--top] = result;
                    break;
                case "-":
                    result = stack[top - 1] - stack[top];
                    stack[--top] = result;
                    break;
                case "*":
                    result = stack[top - 1] * stack[top];
                    stack[--top] = result;
                    break;
                case "/":
                    result = stack[top - 1] / stack[top];
                    stack[--top] = result;
                    break;
                default:
                    stack[++top] = Integer.parseInt(c);
                    break;
            }
        }
        return stack[top];
        // return result;
    }
}

// 1st Version: using Stack
// class Solution {
//     public int evalRPN(String[] tokens) {
//         if (tokens.length == 1) return Integer.parseInt(tokens[0]);
//         String ops = "+-*/";
//         Stack<String> stack = new Stack<>();
//         int result = 0;

//         for (String c : tokens) {
//             if (!ops.contains(c)) stack.push(c);
//             else {
//                 int operand1 = Integer.parseInt(stack.pop());
//                 int operand2 = Integer.parseInt(stack.pop());
                
//                 switch(c) {
//                     case "+":
//                         result = operand2 + operand1;
//                         break;
//                     case "-":
//                         result = operand2 - operand1;
//                         break;
//                     case "*":
//                         result = operand2 * operand1;
//                         break;
//                     case "/":
//                         result = operand2 / operand1;
//                         break;
//                     default:
//                         break;
//                 }
//                 // System.out.println("op1, op2, result: " + operand1 + " , " + operand2 + " , " + result) ;
//                 stack.push(Integer.toString(result));
//             }
//         }
//         return result;
        
//     }
// }
