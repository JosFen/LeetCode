// Recursion - version 1
class Solution {
    public boolean validPalindrome(String s) {
        if (s.length() == 1) return true;

        for (int l = 0, r = s.length() - 1; l < r; l++, r--) {
            if (s.charAt(l) != s.charAt(r)) {
                return isPalindrome(s, l+1, r) || isPalindrome(s, l, r-1);
            }
        }
        
        return true;
    }

    private boolean isPalindrome(final String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}

// Recursion - version 2
class Solution {
    public boolean validPalindrome(String s) {
        if (s.length() == 1) return true;
        int l = 0, r = s.length() - 1;
        return isPalindrome(s, l, r, false);
    }

    private boolean isPalindrome(final String s, int l, int r, boolean isDeleted) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                if (isDeleted) return false;
                return isPalindrome(s, l+1, r, true) || isPalindrome(s, l, r-1, true);
            } 
            l++;
            r--;
        }
        return true;
    }
}

