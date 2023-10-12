class Solution {
    public int maxVowels(String s, int k) {
        char[] sArr = s.toCharArray();
        int[] letters = new int[26];
        letters[0] = 1;
        letters['e' - 'a'] = 1;
        letters['i' - 'a'] = 1;
        letters['o' - 'a'] = 1;
        letters['u' - 'a'] = 1;

        int maxLen = 0, subLen = 0;

        for (int r = 0; r < k; r++) {
            subLen += letters[sArr[r] - 'a'];
        }
        maxLen = subLen;

        for (int r = k; r < s.length(); r++) {
            subLen += letters[sArr[r] - 'a'];
            subLen -= letters[sArr[r-k] - 'a'];
            maxLen = Math.max(maxLen, subLen);
        }

        return maxLen;  
    }
}
