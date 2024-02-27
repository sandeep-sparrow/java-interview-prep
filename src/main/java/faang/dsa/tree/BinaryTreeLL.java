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
        if(root == null){
            return;
        }
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
        if(root == null){
            return;
        }
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

    // INSERT operation - Level Order traversal - reaching each node level by level.
    void insert(String data){
        if(root == null){
            return;
        }
        BinaryNode newNode = new BinaryNode();
        newNode.value = data;
        if(root == null){
            root = newNode;
            System.out.println("Inserted new node at root");
            return;
        }
        // search for vacant place using level order traversal
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            BinaryNode currBinaryNode = queue.remove();
            if(currBinaryNode.left == null){
                currBinaryNode.left = newNode;
                System.out.println("Inserted new node at left");
                break;
            } else if(currBinaryNode.right == null){
                currBinaryNode.right = newNode;
                System.out.println("Inserted new node at right");
                break;
            } else {
                queue.add(currBinaryNode.left);
                queue.add(currBinaryNode.right);
            }
        }
    }

    // DELETE operation - using level order traversal
    // Step1: Find the node
    // Step2: Find the deepest Node
    // Step3: Set the deepest node to the current node
    // Step4: Delete deepest node
    void deleteNode(String data){
        if(root == null){
            return;
        }
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            BinaryNode currBinaryNode = queue.remove();
            if(currBinaryNode.value == data){
                currBinaryNode.value = getDeepestNode().value;
                deleteDeepestNode();
                System.out.println("The node is deleted!");
                return;
            }else{
                if(currBinaryNode.left != null) queue.add(currBinaryNode.left);
                if(currBinaryNode.right != null) queue.add(currBinaryNode.right);
            }
        }
        System.out.println("The Node does not exist, in this Binary Tree!");
        return;
    }

    BinaryNode getDeepestNode(){
        if(root == null){
            return null;
        }
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        BinaryNode currBinaryNode = null;
        while(!queue.isEmpty()){
            currBinaryNode = queue.remove();
            if(currBinaryNode.left != null){
                queue.add(currBinaryNode.left);
            }
            if(currBinaryNode.right != null){
                queue.add(currBinaryNode.right);
            }
        }
        return currBinaryNode;
    }

    void deleteDeepestNode(){
        if(root == null){
            return;
        }
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        BinaryNode previousNode, currentNode = null;
        while(!queue.isEmpty()){
            previousNode = currentNode;
            currentNode = queue.remove();
            if(currentNode.left == null){
                previousNode.right = null;
                return;
            }else if(currentNode.right == null){
                currentNode.left = null;
                return;
            }
            queue.add(currentNode.left);
            queue.add(currentNode.right);
        }
    }

    void deleteBT(){
        root = null;
        System.out.println("Binary Tree has been successfully deleted!");
    }
}
