// SPACE O(1)
class Solution {
    public boolean isPalindrome(String s) {
        if (s.length() == 1) return true;

        int l = 0, r = s.length() - 1;

        while (l < r) {
            while (l < r && !Character.isLetterOrDigit(s.charAt(l))) l++;
            while (l < r && !Character.isLetterOrDigit(s.charAt(r))) r--;

            int lCh = Character.toLowerCase(s.charAt(l));
            int rCh = Character.toLowerCase(s.charAt(r));
            if (lCh != rCh) return false;
            l++;
            r--;
        }

        return true;
    }
}

// SPACE O(n)
// class Solution {
//     public boolean isPalindrome(String s) {
//         if (s.length() == 1) return true;

//         String sConverted = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
       
//         int strLen = sConverted.length();
//         System.out.println(sConverted +" " + strLen);
        

//         for (int i = 0; i < strLen; i++) {
//             if (sConverted.charAt(i) != sConverted.charAt(strLen - 1 - i)) return false;
//         }
//         return true;
//     }
// }
