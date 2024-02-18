package datastructure.collections.tree.bst;

public class Main {

    public static void main(String[] args) {

        BinarySearchTree bst = new BinarySearchTree();
        System.out.println("root = " + bst.root);

        bst.rInsert(8);
        bst.rInsert(3);
        bst.rInsert(10);
        bst.rInsert(1);
        bst.rInsert(6);
        bst.rInsert(14);
        bst.rInsert(13);
        bst.rInsert(4);
        bst.rInsert(7);

        System.out.println(bst.inorderSuccessor(bst.root.left.left).value);

        System.out.println("Contains using Recusrion: " + bst.rContains(14));


    }
}
