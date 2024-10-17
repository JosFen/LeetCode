// O(n+m) time, O(1) space
class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int circleStudents = 0, squareStudents = 0;

        for (int stu : students)  {
            if (stu == 0) circleStudents++;
            else squareStudents++;
        }

        for (int sw : sandwiches) {
            if (sw == 0 && circleStudents == 0) return squareStudents;
            if (sw == 1 && squareStudents == 0) return circleStudents;

            if (sw == 0) circleStudents--;
            else squareStudents--;
        }

        return 0;
    }
}

// Brute Force using queue&stack, O(n*m) time complexity, O(n+m) space
