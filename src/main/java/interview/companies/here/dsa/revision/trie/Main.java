package interview.companies.here.dsa.revision.trie;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("Sun");
        trie.insert("Sunny");
        trie.insert("Sunday");
        trie.insert("Sandeep");
        trie.insert("Sandip");

        List<String> results = trie.search("sun");
        printResult(results);

        results = trie.search("San");
        printResult(results);
    }

    public static void printResult(List<String> results){
        for(String result : results){
            System.out.println(result);
        }
    }
}
