// 3rd version: using Linked List Node:
class MinStack {
    private Node top;


    class Node {
        int val;
        int min;
        Node next;

        public Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }

    public MinStack() {
        this.top = null;
    }

    public void push(int val) {
        int min = (this.top == null) ? val : Math.min(val, this.top.min);
        this.top = new Node(val, min, this.top);
    
    }

    public void pop() {
       this.top = this.top.next;
    }

    public int top() {
        return this.top.val;
    }

    public int getMin() {
        return this.top.min;
    } 
}


// 2nd version: using 1 stack:
// class MinStack {
//     private Stack<int[]> stack = new Stack<>(); // {val, min}

//     public void push(int val) {
//         if (stack.isEmpty()) stack.push(new int[] {val, val});
//         else stack.push(new int[] {val, Math.min(val, stack.peek()[1])});
    
//     }

//     public void pop() {
//         stack.pop();
//     }

//     public int top() {
//         return stack.peek()[0];
//     }

//     public int getMin() {
//         return stack.peek()[1];
//     } 
// }

// 1st Version: using 2 stacks
// class MinStack {
//     private Stack<Integer> stack;
//     private Stack<Integer> minStack;

//     public MinStack() {
//         stack = new Stack<>();
//         minStack = new Stack<>();
//     }
    
//     public void push(int val) {
//         stack.push(val);
//         if (minStack.isEmpty() || minStack.peek() >= val) minStack.push(val);
//     }
    
//     public void pop() {
//         int poppedInt = stack.pop();
//         if (minStack.peek() == poppedInt) minStack.pop();
        
//     }
    
//     public int top() {
//         return stack.peek();
//     }
    
//     public int getMin() {
//         return minStack.peek();
//     }
// }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
