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
