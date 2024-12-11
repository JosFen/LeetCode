class Solution {
    public int maximumLength(String s) {
        int len = s.length();
        int currSubStrLen = 0;
        char prevChar = '#';
        int[][] count = new int[26][len + 1];
        int answer = -1;

        for (char c : s.toCharArray()) {
            if (c == prevChar) count[c - 'a'][++currSubStrLen]++;
            else {
                currSubStrLen = 1;
                count[c - 'a'][currSubStrLen]++;
                prevChar = c;
            }
        }
        for (int[] substrRow : count) {
            answer = Math.max(answer, getMaxSubstrLen(substrRow, len));
        }
        return answer;
    }

    private int getMaxSubstrLen(int[] substrRow, int len) {
        int freq = 0;
        for (int substrLen = len; substrLen >= 1; substrLen--) {
            freq += substrRow[substrLen];
            if (freq >= 3) return substrLen;
        }
        return -1;
    }
}  
