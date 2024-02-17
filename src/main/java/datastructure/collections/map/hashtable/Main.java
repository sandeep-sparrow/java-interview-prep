package datastructure.collections.map.hashtable;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        HashTable myHashTable = new HashTable();

        myHashTable.set("nails", 100);
        myHashTable.set("nuts", 500);
        myHashTable.set("tile", 250);
        myHashTable.set("bolts", 80);

        myHashTable.printTable();

        System.out.println("----------");
        System.out.println(myHashTable.get("tile"));
        System.out.println(myHashTable.get("bolts"));
        System.out.println("----------");

        ArrayList<String> allKeys = myHashTable.keys();
        for (String key: allKeys){
            System.out.println(key);
        }
    }
}
