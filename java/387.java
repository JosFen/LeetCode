// Brute force: O(n^2)
class Solution {
    public int firstUniqChar(String s) {
        if (s.length() == 1) return 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i))) return i;
        }
        return -1;
    }
}

// O(n)
class Solution {
    public int firstUniqChar(String s) {
        if (s.length() == 1) return 0;
        char[] sArr = s.toCharArray();
        int[] arr = new int[26];
        for (char c : sArr) {
            arr[c - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (arr[sArr[i] - 'a'] == 1) return i;
        }
        return -1;
    }
}
