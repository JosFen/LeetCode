// bit count: O(1）
class Solution {
    public char kthCharacter(int k) {
        return (char)('a' + Integer.bitCount(k - 1));
    }
}

//Iteration:
class Solution {
    public char kthCharacter(int k) {

        StringBuilder sb1 = new StringBuilder(""+'a');

        while ( k >= sb1.length() ) {
            int n = sb1.length();
            for ( int i = 0; i < n ; i++ ) {    
                char ch = sb1.charAt(i);     
                if ( ch == 'z') ch = 'a';
                ch++;
                sb1.append(ch);
            }    
        }

        return sb1.charAt(k-1);
    }
}

//Recursion:
class Solution {
    String word = "a";
    public char kthCharacter(int k) {
        if(word.length() > k) {
            char[] charArray = word.toCharArray();
            return charArray[k-1];
        }
        String newWord = "";
        for(char ch: word.toCharArray()) {
            newWord = newWord + (char) (ch +1);
        }

        word = word + newWord;

        return kthCharacter(k);
    }
}
