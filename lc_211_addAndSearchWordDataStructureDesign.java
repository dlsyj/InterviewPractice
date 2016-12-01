package leetcode;
/* Design a data structure that supports the following two operations:

void addWord(word)
bool search(word)
search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

For example:

addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true
Note: You may assume that all words are consist of lowercase letters a-z.
 * 
 */
public class lc_211_addAndSearchWordDataStructureDesign {
	public class TrieNode{
        public TrieNode[] children = new TrieNode[26];
        public String label = "";
    }
    
    private TrieNode root = new TrieNode();
    
    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()){
            if (node.children[c - 'a'] == null){
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.label = word;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return isMatch(word.toCharArray(), 0, root);
    }
    
    public boolean isMatch(char[] word, int index, TrieNode node){
        if (index == word.length){
            return !node.label.equals("");
        }
        if (word[index] == '.'){
            for (int i = 0; i < node.children.length; i ++){
                if (node.children[i] != null){
                    if (isMatch(word, index + 1, node.children[i])){
                        return true;
                    }
                }
            }
            return false;
        }else{
            return node.children[word[index]-'a'] != null && isMatch(word, index + 1, node.children[word[index]-'a']);
        }
    }
}
