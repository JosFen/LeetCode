class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEnd = false;
}

class WordDictionary {
    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode node = this.root;
        for (char c : word.toCharArray()) {
            c -= 'a';
            if (node.children[c] == null) node.children[c] = new TrieNode();
            node = node.children[c];
        }
        node.isEnd = true;
    }
    
    public boolean search(String word) {
        return dfs(word, 0, this.root);
    }

    private boolean dfs(String word, int i, TrieNode node) {
        if (i == word.length()) return node.isEnd; // check the last letter node's isEnd

        // if the character is a lowercase letter:
        if (word.charAt(i) != '.') {
            TrieNode nextNode = node.children[word.charAt(i) - 'a'];
            if (nextNode == null) return false;
            return dfs(word, i + 1, nextNode); 
        }

        // if the character is . :
        for (int j = 0; j < 26; j++) {
            if (node.children[j] != null && dfs(word, i+1, node.children[j])) return true;
        }
        return false;
    }

}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
