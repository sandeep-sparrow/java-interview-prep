package datastructure.collections.tree.bst;

public class Main {

    public static void main(String[] args) {

        BinarySearchTree myBinarySearchTree = new BinarySearchTree();
        System.out.println("root = " + myBinarySearchTree.root);

        myBinarySearchTree.insert(47);
        myBinarySearchTree.insert(21);
        myBinarySearchTree.insert(76);
        myBinarySearchTree.insert(18);
        myBinarySearchTree.insert(52);
        myBinarySearchTree.insert(82);

        boolean result = myBinarySearchTree.insert(27);
        System.out.println("Insert Success? " + result);
        result = myBinarySearchTree.contains(27);
        System.out.println("Cotains? " + result);
        System.out.println(myBinarySearchTree.root.left.right.value);
    }
}
