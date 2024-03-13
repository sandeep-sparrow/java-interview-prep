package faang.dsa.tree;

public class BinaryTreeArray {

    String[] arr;
    int lastUsedIndex;

    public BinaryTreeArray(int size){
        arr = new String[size+1];
        this.lastUsedIndex = 0;
        System.out.println("Blank Tree of size: " + size + " has been created");
    }

    // INSERT
    public boolean isFull(){
        if(arr.length-1 == lastUsedIndex){
            return true;
        }
        return false;
    }

    public void insert(String value){
        if(!isFull()){
            arr[lastUsedIndex+1]=value;
            lastUsedIndex++;
        }else{
            System.out.println("Binary Tree is full!");
        }
    }

    // DFS
    // PRE-ORDER traversal
    public void preOrder(int index){
        if(index > lastUsedIndex){
            return;
        }
        System.out.print(arr[index] + " ");
        preOrder(index * 2);
        preOrder((index * 2) + 1);
    }

    // IN-ORDER traversal
    public void inOrder(int index){
        if(index > lastUsedIndex){
            return;
        }
        inOrder(index * 2);
        System.out.print(arr[index] + " ");
        inOrder((index * 2) + 1);
    }

    // PRE-ORDER traversal
    public void postOrder(int index){
        if(index > lastUsedIndex){
            return;
        }
        postOrder(index * 2);
        postOrder((index * 2) + 1);
        System.out.print(arr[index] + " ");
    }

    // BFS
    // LEVEL-ORDER traversal
    public void levelOrder(){
        for(int i = 1; i <= lastUsedIndex; i++){
            System.out.print(arr[i] + " ");
        }
    }
    
    // SEARCH
    public String search(String value){
        for(int i = 1; i <= lastUsedIndex; i++){
            if(arr[i] == value){
                return value + " found at index " + i;
            }
        }
        return "not found!";
    }
}
