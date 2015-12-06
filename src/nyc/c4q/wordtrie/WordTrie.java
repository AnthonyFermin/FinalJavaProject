package nyc.c4q.wordtrie;

import java.util.ArrayList;
import java.util.List;

public class WordTrie {

    TrieNode root;
    int size;

    public WordTrie(){
        size = 0;
    }

    private int upperCaseLetterToIndex(char letter){

        int index = ((int) letter) - 65;

        if(index < 0 || index > 25) {
            return -1;
        }
        System.out.println(letter + " = " + index);
        return index;
    }

    public void add(String word) {
        // FIXME: Implement this.
        if(root == null){
            root = new TrieNode();
        }
        TrieNode currentNode = root;
        for(char letter : word.toCharArray()){
            int index = upperCaseLetterToIndex(letter);
            currentNode = currentNode.addChild(index, new TrieNode());
        }
        currentNode.setIsEnd(true);
        size++;
    }

    public boolean contains(String word) {
        if(root == null) {
            return false;
        }

        TrieNode currentNode = root;
        for(int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            int currentIndex = upperCaseLetterToIndex(currentChar);

            currentNode = currentNode.getChild(currentIndex);

            if(currentNode == null) {
                return false;
            }

        }
        return true;
    }

    public List<String> toList() {
        List<String> words = new ArrayList<String>();
        // FIXME: Implement this.
        return words;
    }

    private class TrieNode {

        private TrieNode[] children;
        private boolean isEnd;

        public TrieNode(){
            // default constructor
            children = new TrieNode[26];
        }

        public TrieNode(int index){
            this();
            addChild(index, new TrieNode());
        }

        public TrieNode addChild(int index, TrieNode child){
            children[index] = child;
            return child;
        }

        public TrieNode getChild(int index){
            return children[index];
        }

        public void setIsEnd(boolean isEnd){
            this.isEnd = isEnd;
        }

        public boolean isEnd(){
            return isEnd;
        }
    }

    public static void main(String[] args)
    {
        WordTrie trie = new WordTrie();
        trie.add("TEST");
        trie.add("TICK");
        System.out.println(trie.contains("TEST"));
        System.out.println(trie.contains("TACK"));
        System.out.println(trie.contains("TICK"));
    }

}