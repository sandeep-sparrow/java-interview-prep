package interview.companies.micro1.dsa;

import java.util.ArrayList;
import java.util.List;

public class Trie {
    TrieNode root;

    public Trie(){
        root = new TrieNode();
    }

    // Car
    public void insert(String word){
        TrieNode node = root;
        System.out.println(node);
        for(char ch : word.toCharArray()){ // C a r
            node.children.putIfAbsent(ch, new TrieNode());
            node = node.children.get(ch);
        }
        node.isWord = true;
    }

    public List<String> search(String prefix){
        List<String> suggestions = new ArrayList<>();
        TrieNode node = root;
        for(char ch: prefix.toCharArray()) {
            if (!node.children.containsKey(ch)) {
                return suggestions;
            }
            node = node.children.get(ch);
        }
        findAllWordsWithPrefix(node, prefix, suggestions);
        return suggestions;
    }

    private void findAllWordsWithPrefix(TrieNode node, String prefix, List<String> suggestions) {
        if (node.isWord) {
            suggestions.add(prefix);
        }
        for (char ch : node.children.keySet()) {
            findAllWordsWithPrefix(node.children.get(ch), prefix + ch, suggestions);
        }
    }

    public void delete(String word){
        delete(root, word, 0);
    }

    // helper methos using recursion method calling
    private boolean delete(TrieNode current, String word, int index){
        if(index == word.length()){
            if(!current.isWord) return false;
            current.isWord = false;
            return current.children.isEmpty();
        }
        char ch = word.charAt(index);
        TrieNode node = current.children.get(ch);
        if(node == null) return false;
        boolean shouldDeleteCurrentNode = delete(node, word, index+1) &&
        !node.isWord;

        if(shouldDeleteCurrentNode){
            current.children.remove(ch);
            return current.children.isEmpty();
        }
        return false;
    }
}
