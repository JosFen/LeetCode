class Solution {
    public int uniqueLetterString(String s) {
        int count = 0;
        int sLen = s.length();
        int[] latest = new int[26];
        int[] previous = new int[26];
        Arrays.fill(latest, -1);
        Arrays.fill(previous, -1);

        for (int i = 0; i < sLen; i++) {
            int c = s.charAt(i) - 'A';
            if (latest[c] != -1) {
                count += (i - latest[c]) * (latest[c] - previous[c]);
            }
            previous[c] = latest[c];
            latest[c] = i;
        }

        for (int c = 0; c < 26; c++) {
            count += (sLen - latest[c]) * (latest[c] - previous[c]);
        }
        return count;
    }
}
