package leetcode.algorithm.design;

public class WordDictionary {

	class TrieNode {
		
		private int N = 26;
		private boolean isEnd = false;
		private TrieNode[] children;
		
		TrieNode() {
			this.children = new TrieNode[N];
		}
		
		public boolean containsKey(char c) {
			return this.children[c - 'a'] != null;
		}
		
		public void addChild(char c, TrieNode node) {
			this.children[c - 'a'] = node;
		}
		
		public TrieNode getChild(char c) {
			return this.children[c - 'a'];
		}
		
		public TrieNode getChild(int i) {
			return this.children[i];
		}
		
		public void setEnd() {
			this.isEnd = true;
		}
		
		public boolean isEnd() {
			return this.isEnd;
		}
		
	}
	
	private TrieNode root;
	
	/** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = this.root;
        for (int i = 0; i < word.length(); i++) {
        	char currChar = word.charAt(i);
        	if (!node.containsKey(currChar)) {
        		node.addChild(currChar, new TrieNode());
        	}
        	node = node.getChild(currChar);
        }
        node.setEnd();
    }
    
    private boolean match(TrieNode node, String word, int index) {
    	if (index == word.length()) {
    		if (node.isEnd())
    			return true;
    		else
    			return false;
    	}
    	char currChar = word.charAt(index);
    	if (currChar == '.') {
    		for (int i = 0; i < node.children.length; i++) {
    			if (node.getChild(i) != null && match(node.getChild(i), word, index + 1))
    				return true;
    		}
    		return false;
    	} else {
    		return node.getChild(currChar) != null && match(node.getChild(currChar), word, index + 1);
    	}
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return match(root, word, 0);
    }
	
    public static void testCase1() {
    	WordDictionary dic = new WordDictionary();
    	dic.addWord("bad");
    	dic.addWord("dad");
    	dic.addWord("mad");
    	System.out.println(dic.search("pad"));
    	System.out.println(dic.search("bad"));
    	System.out.println(dic.search(".ad"));
    	System.out.println(dic.search("b.."));
    }
    
    public static void testCase2() {
    	WordDictionary dic = new WordDictionary();
    	dic.addWord("at");
    	dic.addWord("and");
    	dic.addWord("an");
    	dic.addWord("add");
    	System.out.println(dic.search("a"));
    }
    
    public static void main(String[] args) {
    	testCase1();
//    	testCase2();
    }
    
}
