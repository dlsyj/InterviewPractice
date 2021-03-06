package leetcode;
/* Implement a trie with insert, search, and startsWith methods.

Note:
You may assume that all inputs are consist of lowercase letters a-z.

Applications of Trie Tree:
(1) Autocomplete
(2) Spell checker
(3) IP routing (Longest prefix matching)
(4) T9 predictive text
(5) Solving word games
https://leetcode.com/articles/implement-trie-prefix-tree/
 * 
 */
public class lc_208_implementTrie {
	
	class TrieNode {
	    private TrieNode[] children;
	    public boolean isLast;
	    
	    // Initialize your data structure here.
	    public TrieNode() {
	        children = new TrieNode[26];
	        isLast = false;
	    }
	    
	    public void insert(String word, int index){
	        if (index == word.length()){
	            this.isLast = true;
	            return;
	        }
	        int pos = word.charAt(index) - 'a';
	        if (children[pos] == null){
	            children[pos] = new TrieNode();
	        }
	        children[pos].insert(word,index+1);
	    }
	    
	    public TrieNode find(String word, int index){
	        if (index == word.length()){
	            return this;
	        }
	        int pos = word.charAt(index) - 'a';
	        if (children[pos] == null){
	            return null;
	        }
	        return children[pos].find(word,index+1);
	    }
	}

	public class Trie {
	    private TrieNode root;

	    public Trie() {
	        root = new TrieNode();
	    }

	    // Inserts a word into the trie.
	    public void insert(String word) {
	        root.insert(word,0);
	    }

	    // Returns if the word is in the trie.
	    public boolean search(String word) {
	        TrieNode node = root.find(word,0);
	        return (node != null && node.isLast);
	    }

	    // Returns if there is any word in the trie
	    // that starts with the given prefix.
	    public boolean startsWith(String prefix) {
	        TrieNode node = root.find(prefix,0);
	        return node != null;
	    }
	}

	// Your Trie object will be instantiated and called as such:
	// Trie trie = new Trie();
	// trie.insert("somestring");
	// trie.search("key");
}
