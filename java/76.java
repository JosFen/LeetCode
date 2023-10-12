class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length() || t.isEmpty()) return "";
        
        int[] tMap = new int[128];
        int need = t.length();
        int start = -1, minLen = s.length()+1;

        for (char c : t.toCharArray()) tMap[c]++;

        for (int l = 0, r = 0; r < s.length(); r++) {
            if (--tMap[s.charAt(r)] >= 0) need--;

            while (need == 0) {
                if (minLen > r - l + 1) {
                    start = l;
                    minLen  = r-l+1;
                }
                if (++tMap[s.charAt(l++)] > 0) need++;
            }
        }
        return start == -1 ? "" : s.substring(start, start+minLen);
    }
}
