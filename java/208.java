class Trie {
    Trie[] children;
    boolean isEnd;

    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }
    
    public void insert(String word) {
        Trie node = this; // initial or first level trie node is empty-valued
        for (char c : word.toCharArray()) { // toLowerCase() if case-sensitive
            c -= 'a';
            if (node.children[c] == null) node.children[c] = new Trie();
            node = node.children[c];
        }
        node.isEnd = true; // end on and mark last letter trie node as end-of-word
    }
    
    public boolean search(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.children[index] == null) return false;
            node = node.children[index];
        }
        return node.isEnd; // end on the last letter of word
    }
    
    public boolean startsWith(String prefix) {
        Trie node = this;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) return false;
            node = node.children[index];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
