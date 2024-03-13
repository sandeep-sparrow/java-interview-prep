package faang.dsa.tree;

public class BinaryTreeArrayMain {

    public static void main(String[] args) {
        BinaryTreeArray bTreeArray = new BinaryTreeArray(9);
        bTreeArray.insert("N1");
        bTreeArray.insert("N2");
        bTreeArray.insert("N3");
        bTreeArray.insert("N4");
        bTreeArray.insert("N5");
        bTreeArray.insert("N6");
        bTreeArray.insert("N7");
        bTreeArray.insert("N8");
        bTreeArray.insert("N9");
        System.out.println(" ");
        bTreeArray.preOrder(1);
        System.out.println(" ");
        bTreeArray.levelOrder();
        System.out.println(" ");
        System.out.println(bTreeArray.search("N6"));
    }
    
}
