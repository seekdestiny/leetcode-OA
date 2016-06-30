class TrieNode {
    public boolean hasWord;
    public Map<Character, TrieNode> map;
    public TrieNode() {
        map = new HashMap<Character, TrieNode>();    
        hasWord = false;
    }
}

public class WordDictionary {
    private TrieNode dict;
    
    public WordDictionary() {
        dict = new TrieNode();
    }

    // Adds a word into the data structure.
    public void addWord(String word) {
        // Write your code here
        TrieNode current = dict;
        for (int i = 0; i < word.length(); i++) {
            Character ch = word.charAt(i);
            if (!current.map.containsKey(ch)) {
                current.map.put(ch, new TrieNode());
            }
            current = current.map.get(ch);
        }
        
        current.hasWord = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        // Write your code here
        return find(dict, 0, word);
    }
    
    public boolean find(TrieNode root, int index, String word) {
        if (index == word.length()) {
            return root.hasWord;
        }
        
        Character ch = word.charAt(index);
        if (ch == '.') {
            for (Map.Entry<Character, TrieNode> item : root.map.entrySet()) {
                if (find(item.getValue(), index + 1, word)) {
                    return true;
                }
            }
        } else {
            if (root.map.containsKey(ch)) {
                return find(root.map.get(ch), index + 1, word);
            }
        }
        
        return false;
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
