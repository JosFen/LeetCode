class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int maxF = 0, l = 0, res = 0;

        for (int r = 0; r < s.length(); r++) {
            count[s.charAt(r) - 'A']++;
            maxF = Math.max(maxF, count[s.charAt(r) - 'A']);

            while (r - l + 1 - maxF > k) {
                count[s.charAt(l) - 'A']--;
                l++;
            }
            res = Math.max(res, r-l+1);
        }

        return res;
    }
}
