package faang.dsa.tree.avl;

public class Main {

    public static void main(String[] args) {
        AVL newAvl = new AVL();
        newAvl.insert(5);
        newAvl.insert(10);
        newAvl.insert(15);
        newAvl.insert(20);
        newAvl.levelOrder();
        newAvl.delete(5);
        System.out.println();
        newAvl.levelOrder();
    }
}
