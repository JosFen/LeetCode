/** 1st VERSION: indexOf() */
class Solution {
    public boolean isSubsequence(String s, String t) {
        int sLen = s.length();
        int cursor = -1;
        
        for (int i = 0; i < sLen; i++) {
            cursor = t.indexOf(s.charAt(i), cursor + 1);
            if (cursor == -1) return false;
        }
        return true;
    }
}

/** 2nd VERSION: 2 pointers */

// class Solution {
//     public boolean isSubsequence(String s, String t) {
//        int i = 0, j = 0;

//        while (i < s.length() && j < t.length()) {
//            if (s.charAt(i) == t.charAt(j)) {
//                i++;
//            }
//            j++;
//        }
//        return (i == s.length());
//     }
// }
