// O(1) space
class Solution {
    public void setZeroes(int[][] matrix) {
       int m = matrix.length;
       int n = matrix[0].length;

    // decide whether to make the first row/col all zeros at the end 
       boolean isFirstRowZero = false;
       boolean isFirstColZero = false;
       for (int j = 0; j < n; j++) {
           if (matrix[0][j] == 0) {
               isFirstRowZero = true;
                break;
           }
       }
       for (int i = 0; i < m; i++) {
           if (matrix[i][0] == 0) {
               isFirstColZero = true;
               break;
           } 
       }
    //    System.out.println("isFirstRowZero : " + isFirstRowZero);
    //    System.out.println("isFirstColZero : " + isFirstColZero);
    
       // go through rest entries and mark on the first row/col if there is a 0: 
       for (int i = 1; i < m; i++) {
           for (int j = 1; j < n; j++) {
               if (matrix[i][j] == 0) {
                   matrix[i][0] = 0;
                   matrix[0][j] = 0;
               }
           }
       }

       for (int j = 1; j < n ; j++) {
           if (matrix[0][j] == 0) {
               for (int i = 1; i < m; i++) matrix[i][j] = 0;
           }
       }
       for (int i = 1; i < m ; i++) {
           if (matrix[i][0] == 0) {
               for (int j = 1; j < n ; j++) matrix[i][j] = 0;
           }
       }

       if (isFirstRowZero) {
           for (int j = 0; j < n ; j++) matrix[0][j] = 0;
        }

       if (isFirstColZero) {
           for (int i = 0; i < m ; i++) matrix[i][0] = 0;
        }

    }
}


// // O(m + n) space
// class Solution {
//     public void setZeroes(int[][] matrix) {
//         int m = matrix.length, n = matrix[0].length;
//         boolean[] rows = new boolean[m];
//         boolean[] cols = new boolean[n];
//         for (int i = 0; i < m; ++i) {
//             for (int j = 0; j < n; ++j) {
//                 if (matrix[i][j] == 0) {
//                     rows[i] = true;
//                     cols[j] = true;
//                 }
//             }
//         }
//         for (int i = 0; i < m; ++i) {
//             for (int j = 0; j < n; ++j) {
//                 if (rows[i] || cols[j]) {
//                     matrix[i][j] = 0;
//                 }
//             }
//         }
//     }
// }
