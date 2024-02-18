package datastructure.revision.tree;

public class Test {

    public static void main(String[] args) {
        
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(8);
        bst.insert(3);
        bst.insert(10);
        bst.insert(14);
        bst.insert(1);
        bst.insert(6);
        bst.insert(13);
        bst.insert(4);
        bst.insert(7);
    
        System.out.println(bst.root.left.left.value); // great! so insert method works fine
        // now let's create contains method.

        System.out.println(bst.contains(17));

        System.out.println("Max value: " + bst.findMaxValue());

        System.out.println("Length of BST: " + bst.length(bst.root));
    }
    
}
