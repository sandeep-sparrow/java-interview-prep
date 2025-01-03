package datastructure.collections.trie;

import java.util.ArrayList;
import java.util.List;

public class Trie {

    TrieNode root;

    public Trie(){
        root = new TrieNode();
    }

    public void insert(String word){
        TrieNode node = root;
        for(Character cha : word.toCharArray()){
            node.children.putIfAbsent(cha, new TrieNode());
            node = node.children.get(cha);
        }
        node.isWord = true;
    }

        public List<String> search(String prefix){
        List<String> suggestions = new ArrayList<>();
        TrieNode node = root;
        for(char c : prefix.toCharArray()){
            if(!node.children.containsKey(c)){
                return suggestions;
            }
            node = node.children.get(c);
        }
        finalAllWordsWithPrefix(node, prefix, suggestions);
        return suggestions;

    }

    private void finalAllWordsWithPrefix(TrieNode node, String prefix, List<String> suggestions) {
        if(node.isWord){
            suggestions.add(prefix);
        }
        for(char c : node.children.keySet()){
            finalAllWordsWithPrefix(node.children.get(c), prefix + c, suggestions);
        }
    }

    public void delete(String word){
        delete(root, word, 0);
    }

    // helper methos using recursion method calling
    private boolean delete(TrieNode current, String word, int index) {
        if(index == word.length()){
            if(!current.isWord){return false;}
            current.isWord = false;
            return current.children.isEmpty();
        }
        char ch = word.charAt(index);
        TrieNode node = current.children.get(ch);
        if(node == null){ return false;}
        boolean shouldDeleteCurrentNode = delete(node, word, index+1) &&
        !node.isWord;

        if(shouldDeleteCurrentNode){
            current.children.remove(ch);
            return current.children.isEmpty();
        }
        return false;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("application");
        trie.insert("apply");

        System.out.println(trie.search("app").toString());
        System.out.println(trie.search("asp").toString());
    }
}
