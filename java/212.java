class Trie {
    Trie[] children;
    String word;

    public Trie() {
        children = new Trie[26];
        word = null;
    }
    
    public void insert(String word) {
        Trie node = this; // initial or first level trie node is empty-valued
        for (char c : word.toCharArray()) { // toLowerCase() if case-sensitive
            c -= 'a';
            if (node.children[c] == null) node.children[c] = new Trie();
            node = node.children[c];
        }
        node.word = word; // save the inserted word string on the last trie node
    }
    
}


class Solution {
    private Trie root = new Trie(); // create a trie

    public List<String> findWords(char[][] board, String[] words) {
        for (String word : words) root.insert(word); // insert all words into trie
        List<String> result = new ArrayList<>();

        // DFS traverse matrix 
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, root, i, j, result);
            }
        }

        return result;
    }

    private void dfs(char[][] board, Trie root, int i, int j, List<String> result) {
        // stop or return if i or j is out of index range：
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return;
        // stop or return if the same letter cell has been used once:
        if (board[i][j] == '#') return;

        char c = board[i][j];
        Trie childNode = root.children[c - 'a'];
        
        if (childNode == null) return; // fall off the trie 

        if (childNode.word != null) { // find a word
            result.add(childNode.word);
            childNode.word = null; // mark it null to prevent future duplicate adding
        }

        board[i][j] = '#'; // mark the letter used once for the word
        // search 4 adjacent cells:
        dfs(board, childNode, i + 1, j, result);
        dfs(board, childNode, i - 1, j, result);
        dfs(board, childNode, i, j + 1, result);
        dfs(board, childNode, i, j - 1, result);

        board[i][j] = c; // *** Backtracking: revert the used letter for searching other words ***
    }
}
