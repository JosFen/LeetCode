class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int l = 0, maxLen = 0;

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            l = Math.max(l, map.getOrDefault(c, l));
            map.put(c, r+1);
            maxLen = Math.max(maxLen, r-l+1);
        }

        return maxLen;
    }
}
