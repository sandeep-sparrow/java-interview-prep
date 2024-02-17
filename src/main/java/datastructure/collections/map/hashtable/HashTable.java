package datastructure.collections.map.hashtable;

import java.util.ArrayList;

public class HashTable {

    private int size = 7;
    private Node[] dataMap;

    public HashTable(){
        dataMap = new Node[size];
    }

    public static class Node {
        private String key;
        private int value;
        private Node next;

        public Node(String key, int value){
            this.key = key;
            this.value = value;
        }
    }

    public void printTable(){
        for(int i = 0; i < dataMap.length; i++){
            System.out.println(i + ":");
            Node temp = dataMap[i];
            while (temp != null){
                System.out.println(" {" + temp.key + "= " + temp.value + "}");
                temp = temp.next;
            }
        }
    }

    private int hash(String key){
        // key = "paint"
        int hash = 0;
        // ['p', 'a', 'i', 'n', 't']
        char[] keyChars = key.toCharArray();
        for(int i = 0; i < keyChars.length; i++){
            int asciiValue = keyChars[i];
            // number 23 is prime number it gives more random number
            hash = (hash + asciiValue * 23) % dataMap.length;
        }
        return hash;
    }

    public void set(String key, int value){
        // invoke hashing logic to get index of (0-6)
        int index = hash(key);

        // create node
        Node newNode = new Node(key, value);

        // Add to dataMap Node[]
        if(dataMap[index] == null){
            dataMap[index] = newNode;
        }else{
            Node temp = dataMap[index];
            while (temp.next != null){
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public int get(String key){
        // invoke hashing logic to get index of (0-6)
        int index = hash(key);

        // get Logic
        Node temp = dataMap[index];
        while(temp != null){
            if(temp.key.equals(key)) return temp.value;
            temp = temp.next;
        }
        return 0;
    }

    public ArrayList<String> keys(){
        ArrayList<String> allKeys = new ArrayList<>();

        // loop through the array
        for(int i = 0; i < dataMap.length; i++){
            Node temp = dataMap[i];
            // loop through linked list
            while(temp != null){
                allKeys.add(temp.key);
                temp = temp.next;
            }
        }
        return allKeys;
    }
}
