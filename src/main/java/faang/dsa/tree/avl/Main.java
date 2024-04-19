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

        AVL myAvl = new AVL();
        myAvl.insert(70);
        myAvl.insert(50);
        myAvl.insert(90);
        myAvl.insert(30);
        myAvl.insert(60);
        myAvl.insert(80);
        myAvl.insert(100);
        myAvl.insert(20);
        System.out.println("Debug Here!");
        myAvl.levelOrder();
        myAvl.delete(70);
        System.out.println();
        myAvl.levelOrder();
    }
}
