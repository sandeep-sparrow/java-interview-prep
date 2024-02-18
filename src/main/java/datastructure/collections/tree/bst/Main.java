package datastructure.collections.tree.bst;

public class Main {

    public static void main(String[] args) {

        BinarySearchTree bst = new BinarySearchTree();
        System.out.println("root = " + bst.root);

        bst.insert(18);
        bst.insert(13);
        bst.insert(20);
        bst.insert(10);
        bst.insert(16);
        bst.insert(24);
        bst.insert(23);
        bst.insert(14);
        bst.insert(17);

        System.out.println(bst.inorderSuccessor(bst.root.left.left).value);

        System.out.println("Contains using Recusrion: " + bst.rContains(44));


    }
}
