// class Solution {
//     public boolean backspaceCompare(String s, String t) {
//         int sIndex = s.length() - 1;
//         int tIndex = t.length() - 1;
//         int bsCount = 0;


//         while(true) {
//             bsCount = 0;
//             while(sIndex >= 0 && (s.charAt(sIndex) == '#' || bsCount > 0)) {
//                 bsCount += (s.charAt(sIndex) == '#') ? 1 : -1;
//                 sIndex--;
//             }
//             bsCount = 0;
//             while(tIndex >= 0 && (t.charAt(tIndex) == '#' || bsCount > 0)) {
//                 bsCount += (t.charAt(tIndex) == '#') ? 1 : -1;
//                 tIndex--;
//             }

//             if (sIndex >= 0 && tIndex >= 0 && s.charAt(sIndex) == t.charAt(tIndex)) {
//                 sIndex--;
//                 tIndex--;
//             } else break;
//         }

//         return (sIndex == -1) && (tIndex == -1);
//     }
// }
class Solution {
    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;

        while (i >= 0 || j >= 0) { // While there may be chars in build(S) or build (T)
            while (i >= 0) { // Find position of next possible char in build(S)
                if (S.charAt(i) == '#') {skipS++; i--;}
                else if (skipS > 0) {skipS--; i--;}
                else break;
            }
            while (j >= 0) { // Find position of next possible char in build(T)
                if (T.charAt(j) == '#') {skipT++; j--;}
                else if (skipT > 0) {skipT--; j--;}
                else break;
            }
            // If two actual characters are different
            if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j))
                return false;
            // If expecting to compare char vs nothing
            if ((i >= 0) != (j >= 0))
                return false;
            i--; j--;
        }
        return true;
    }
}
