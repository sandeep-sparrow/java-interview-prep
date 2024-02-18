package datastructure.revision.hasttable;

public class HashTable<K, V> {

    public int size = 7;
    public HashNode<K, V>[] dataMap;

    @SuppressWarnings("unchecked")
    public HashTable(){
        this.dataMap = new HashNode[size];
    }

    public static class HashNode<K, V>{
        K key;
        V value;
        HashNode<K, V> next;

        public HashNode(K key, V value){
            this.key = key;
            this.value = value;
        }
    }

    public void printTable(){
        for(int i = 0; i < dataMap.length; i++){
            System.out.println(i + ":");
            HashNode<K, V> temp = dataMap[i];
            while (temp != null){
                System.out.println(" {" + temp.key + "= " + temp.value + "}");
                temp = temp.next;
            }
        }
    }

    public int hasCode(K key){
        int hash = 0;
        char[] keyChars = key.toString().toCharArray();
        for(int i = 0; i < keyChars.length; i++){
            int asciiValue = keyChars[i];
            hash = (hash + asciiValue * 23) % dataMap.length;
        }
        return hash;
    }

    public void set(K key, V value){
        int index = hasCode(key);

        @SuppressWarnings({ "rawtypes", "unchecked" })
        HashNode<K, V> newNode = new HashNode(key, value);
        if(dataMap[index] == null){
            dataMap[index] = newNode;
        }else{
            HashNode<K, V> temp = dataMap[index];
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public V get(K key){
        int index = hasCode(key);
        HashNode<K, V> temp = dataMap[index];
        while (temp != null) {
            if(temp.key.equals(key)) return temp.value;
            temp = temp.next;
        }
        return null;
    }
    
}
