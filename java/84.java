// https://medium.com/tech-life-fun/leet-code-84-largest-rectangle-in-histogram-graphically-explained-python3-solution-df7e0d37ae4d

// Time: O(n)
// Space: O(n)

// 2nd version: using array
class Solution {
  public int largestRectangleArea(int[] heights) {
      int[] stack = new int[heights.length];
      int top = -1;  
      int maxArea = 0;
      
      for (int i = 0; i <= heights.length; ++i) {
        // stack is empty or lower height encountered
        while (top != -1 && (i == heights.length || heights[stack[top]] > heights[i])) { 
          int h = heights[stack[top--]];
          int w = (top == -1) ? i : i - stack[top] - 1;
          maxArea = Math.max(maxArea, h * w);
        }
        stack[++top] = i;
      }

      return maxArea;
      }
  }


// 1st version: using Stack
// class Solution {
//   public int largestRectangleArea(int[] heights) {
//     int maxArea = 0;
//     Stack<Integer> stack = new Stack<>();

//     for (int i = 0; i <= heights.length; ++i) {
//       while (!stack.isEmpty() && (i == heights.length || heights[stack.peek()] > heights[i])) {
//         final int h = heights[stack.pop()];
//         final int w = stack.isEmpty() ? i : i - stack.peek() - 1;
//         maxArea = Math.max(maxArea, h * w);
//       }
//       stack.push(i); // push index in height-ascending order til a lower height/end of array encountered
//     }

//     return maxArea;
//   }
// }
