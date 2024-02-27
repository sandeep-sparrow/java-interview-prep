package faang.dsa.tree;

import java.util.Queue;
import java.util.LinkedList;

public class BinaryTreeLL {

    BinaryNode root;

    public BinaryTreeLL() {
        this.root = null;
    }

    // ALERT: Depth First Search
    // Type1: Pre-order traversal
    // visit root node, then left node, then right node
    void preOrder(BinaryNode node) {
        if(node == null) {
            return;
        }
        System.out.print(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    // Type2: In-order traversal
    // visit left node, then root node, then right node
    void inOrder(BinaryNode node) {
        if(node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.value + " ");
        inOrder(node.right);
    }

    // Type3: Post-order traversal
    // visit left node, then right node, then root node
    void postOrder(BinaryNode node){
        if(node == null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value + " ");
    }
    
    // ALERT: Breath First Search
    // Type0: Level-order traversal
    // visit each node from left to right on each layer/level
    void levelOrder(){
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            BinaryNode currBinaryNode = queue.remove();
            System.out.print(currBinaryNode.value + " ");
            if(currBinaryNode.left != null){
                queue.add(currBinaryNode.left);
            }
            if(currBinaryNode.right != null){
                queue.add(currBinaryNode.right);
            }
        }
    }

    // SEARCH Operation - always use Level - Order traversal aka BFS
    void search(String value){
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            BinaryNode currentBinaryNode = queue.remove();
            if(currentBinaryNode.value == value){
                System.out.println("The Value: " + value + " is found in Tree");
                return;
            } else {
                if(currentBinaryNode.left != null){
                    queue.add(currentBinaryNode.left);
                }
                if(currentBinaryNode.right != null){
                    queue.add(currentBinaryNode.right);
                }
            }
        }
        System.out.println("The Value: " + value + " is not found in Tree");
        
    }
}
