package leetcode.algorithm.design;

public class Trie {

	class TrieNode {
		
		private int N = 26;
		private boolean isEnd = false;
		private TrieNode[] children;
		
		TrieNode() {
			children = new TrieNode[N];
		}
		
		public boolean containsKey(char c) {
			return children[c - 'a'] != null;
		}
		
		public void put(char c, TrieNode node) {
			children[c - 'a'] = node;
		}
		
		public TrieNode get(char c) {
			return children[c - 'a'];
		}
		
		public void setEnd() {
			isEnd = true;
		}
		
		public boolean isEnd() {
			return isEnd;
		}
		
	}
	
	private TrieNode root;
	
	/** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
    	for (int i = 0; i < word.length(); i++) {
        	char c = word.charAt(i);
        	if (!node.containsKey(c))
        		node.put(c, new TrieNode());
        	node = node.get(c);
        }
    	node.setEnd();
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
    	for (int i = 0; i < word.length(); i++) {
        	char c = word.charAt(i);
        	node = node.get(c);
        	if (node == null)
        		return false;
        }
    	return (node != null) && (node.isEnd());
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
        	char c = prefix.charAt(i);
        	node = node.get(c);
        	if (node == null)
        		return false;
        }
        return (node != null);
    }
	
    
    public static void testCase1() {
    	Trie trie = new Trie();
    	trie.insert("apple");
    	System.out.println(trie.search("apple"));;
    	System.out.println(trie.search("app"));;
    	System.out.println(trie.startsWith("app"));
    	trie.insert("app");
    	System.out.println(trie.search("app"));;
    }
    
    public static void testCase2() {
    	Trie trie = new Trie();
    	trie.insert("app");
    	trie.insert("apple");
//    	trie.insert("bear");
//    	trie.insert("add");
//    	trie.insert("jam");
//    	trie.insert("rental");
    	System.out.println(trie.search("apps"));
    	System.out.println(trie.search("app"));
    }
    
    public static void main(String[] args) {
    	// testCase1();
    	testCase2();
    }
    
}
