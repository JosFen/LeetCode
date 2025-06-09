// v3: Follow up: What if the inputs contain Unicode characters? 
import java.util.*;

class Main {
    public static void main(String[] args) {
        String s = "rat";
        String t = "cat";
        
        System.out.println(isAnagram(s, t));
        System.out.println(isAnagram("déjà", "àjéd")); // true
        System.out.println(isAnagram("你好", "好你"));   // true
        System.out.println(isAnagram("abc", "def"));    // false

    }
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        
       Map<Character, Integer> count = new HashMap<>(); // use HashMap
       
       for (char c : s.toCharArray()) {
           count.put(c, count.getOrDefault(c, 0) + 1); // update HashMap
       }
       
       for (char c : t.toCharArray()) {
           if (!count.containsKey(c)) return false; 
           count.put(c, count.get(c) - 1);
           
           if (count.get(c) == 0) count.remove(c); // remove if a equal number of a char is reached
       }
       
       return count.isEmpty();  // check if there's any remaining key/value?
    }
}


// v2: improvement on speed, but only covers 26 lower-case:
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
