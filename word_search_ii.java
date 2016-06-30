public class Solution {
    /**
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     */
    public ArrayList<String> wordSearchII(char[][] board, ArrayList<String> words) {
        // write your code here
        ArrayList<String> result = new ArrayList<String>();
        
        if (board == null || board.length == 0 || board[0].length == 0) {
            return result;
        }
        
        Trie dict = new Trie();
        for (String word : words) {
            dict.insert(word);
        }
        
        int m = board.length;
        int n = board[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, dict.root, i, j, result);
            }
        }
        
        return result;
    }
    
    private void dfs(char[][] board, TrieNode root, int i, int j,
                     ArrayList<String> result) {
        if (root.hasWord) {
            if (!result.contains(root.s)) {
                result.add(root.s);
            }
        }
        
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length
            || board[i][j] == '0') {
                return;
        }
        
        Character ch = board[i][j];
        
        if (root.map.containsKey(ch)) {
            board[i][j] = '0';
            dfs(board, root.map.get(ch), i + 1, j, result);
            dfs(board, root.map.get(ch), i - 1, j, result);
            dfs(board, root.map.get(ch), i, j + 1, result);
            dfs(board, root.map.get(ch), i, j - 1, result);
            board[i][j] = ch;
        }
        
    }
}
