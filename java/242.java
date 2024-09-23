class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] count = new int[26];

        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            count[c - 'a']--;
        }

        for (int j = 0; j < 26; j++) {
            if (count[j] != 0) return false;
        }

        return true;
    }
}

// Slower solution: (1st version):
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            a[s.charAt(i) - 'a']++;
            a[t.charAt(i) - 'a']--;
        }
        // System.out.println(Arrays.toString(a));

        for (int j = 0; j < 26; j++) {
            if (a[j] != 0) return false;
        }

        return true;
    }
}
