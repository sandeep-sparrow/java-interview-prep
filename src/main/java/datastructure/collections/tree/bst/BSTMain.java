package datastructure.collections.tree.bst;

import java.util.List;

public class BSTMain {

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(47);
        bst.insert(21);
        bst.insert(76);
        bst.insert(18);
        bst.insert(27);
        bst.insert(52);
        bst.insert(82);

        // which of this Traversal gives an ascending order of node.value
        List<Integer> results = bst.DFSInOrder();
        for (Integer result : results) {
            System.out.print(result + " ");
        }
    }
}
