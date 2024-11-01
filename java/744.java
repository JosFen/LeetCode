// Iteration: 
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int l = 0, r = letters.length - 1, m = 0;

        while (l <= r) {
            m = (l + r) / 2;
            if (letters[m] <= target) l = m + 1; // increment l till letters[l]> target
            else r = m - 1; // decrement r till letters[l] <=  target
        }
        /**
        1. When all letters greater than target, return  l = 0 (r = -1 eventually)
        2. When letters[m] == target, l = m + 1 && letters[l] > target
        3. When all letters smaller than target, l == letters.length
         */
        return letters[l % letters.length]; 
    }
}

// Recursion:
class Solution {
    private int find(char[] letters, char target, int l, int r) {
        if (l > r) return 0;

        int m = (l + r) / 2;
        if (letters[m] <= target) return find(letters, target, m+1, r);
        else if (m >= 1 && letters[m-1] > target) return find(letters, target, l, m-1);

        return m;
    }

    public char nextGreatestLetter(char[] letters, char target) {
        int i = find(letters, target, 0, letters.length-1);
        return letters[i];
    }
}
