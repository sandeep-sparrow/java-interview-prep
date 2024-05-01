package interview.companies.micro1.dsa;

public class TrieMain {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("Car");
        trie.insert("Cat");

        System.out.println(trie.search("Ca").toString());
    }
    
}
