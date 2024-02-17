package datastructure.collections.trie;

public class MapTrie {

    TrieNode root;

    public MapTrie(){
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

    
}
