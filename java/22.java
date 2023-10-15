// 2nd version:
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        generateHelper(n, n, "", result);

        return result;
    }

    private void generateHelper(int l, int r, String output, List<String> result) {
        if (l < 0 || r < 0 || l > r) return;

        if (l == 0 && r == 0) {
            result.add(output);
            return;
        }

        generateHelper(l-1, r, output+"(", result);
        generateHelper(l, r-1, output+")", result);
    }
}

// 1st Version
// class Solution {
//     public List<String> generateParenthesis(int n) {
//         List<String> result = new ArrayList<>();

//         generateHelper(0, 0, n, "", result);

//         return result;
//     }

//     private void generateHelper(int l, int r, int max, String output, List<String> result) {
//         if (l > max || r > max || l < r) return;

//         if (l == max && r == max) {
//             result.add(output);
//             return;
//         }

//         generateHelper(l+1, r, max, output+"(", result);
//         generateHelper(l, r+1, max, output+")", result);
//     }
// }
