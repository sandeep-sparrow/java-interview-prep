package datastructure.collections.tree.bst;

public class Main {

    public static void main(String[] args) {

        BinarySearchTree myBinarySearchTree = new BinarySearchTree();
        System.out.println("root = " + myBinarySearchTree.root);

        myBinarySearchTree.insert(18);
        myBinarySearchTree.insert(13);
        myBinarySearchTree.insert(20);
        myBinarySearchTree.insert(10);
        myBinarySearchTree.insert(16);
        myBinarySearchTree.insert(24);
        myBinarySearchTree.insert(23);
        myBinarySearchTree.insert(14);
        myBinarySearchTree.insert(17);

        System.out.println(myBinarySearchTree.inorderSuccessor(myBinarySearchTree.root.left.left).value);


    }
}
