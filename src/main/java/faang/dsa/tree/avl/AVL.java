package faang.dsa.tree.avl;

import java.util.LinkedList;
import java.util.Queue;
public class AVL {

    BinaryNode root;

    public AVL() {
        root = null;
    }

    // PRE-ORDER traversal
    // NODE-LEFT-RIGHT
    public void preOrder(BinaryNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    // IN-ORDER traversal
    // LEFT-NODE-RIGHT
    public void inOrder(BinaryNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.value + " ");
        inOrder(node.right);
    }

    // POST-ORDER traversal
    // LEFT-RIGHT-NODE
    public void postOrder(BinaryNode node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value + " ");
    }

    // LEVEL-ORDER traversal
    public void levelOrder() {
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryNode presentNode = queue.remove();
            System.out.print(presentNode.value + " ");
            if (presentNode.left != null) {
                queue.add(presentNode.left);
            }
            if (presentNode.right != null) {
                queue.add(presentNode.right);
            }
        }
    } 

    // SEARCH
    public BinaryNode search(BinaryNode node, int value) {
        if (node == null) {
            System.out.println("Value: " + value + " not found");
            return null;
        } else if (node.value == value) {
            System.out.println("Value: " + value + " found");
            return node;
        } else if (value < node.value) {
            return search(node.left, value);
        } else {
            return search(node.right, value);
        }
    }

    // ROTATION IS REQUIRED
    // 4 conditions - LL, LR, RR, RL

    // ROTATION IS NOT REQUIRED

    // 30, 25, 35, 20, 15, 5, 10, 50, 60, 70, 65

    // check if tree is balanced
    // identify Disbalanced node
    // identify which condition

    // HELPER Methods
    // getHeight(node)
    public int getHeight(BinaryNode node){
        if(node == null){
            return 0;
        }else{
            return node.height;
        }
    }

    // rotateRight(node)
    // TIME COMPLEXITY - O(1)
    // SPACE COMPLEXITY = O(1)
    public BinaryNode rotateRight(BinaryNode disbalancedNode){
        BinaryNode newRoot = disbalancedNode.left;
        disbalancedNode.left = disbalancedNode.left.right;
        newRoot.right = disbalancedNode;
        // Update Height of Dis-Balanced-Node and newRoot
        disbalancedNode.height = 1 + Math.max(getHeight(disbalancedNode.left), getHeight(disbalancedNode.right));
        newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));
        return newRoot;
    }

    // rotateLeft(node)
    // TIME COMPLEXITY - O(1)
    // SPACE COMPLEXITY = O(1)
    public BinaryNode rotateLeft(BinaryNode disbalancedNode){
        BinaryNode newRoot = disbalancedNode.right;
        disbalancedNode.right = disbalancedNode.right.left;
        newRoot.left = disbalancedNode;
        // Update Height of Dis-Balanced-Node and newRoot
        disbalancedNode.height = 1 + Math.max(getHeight(disbalancedNode.left), getHeight(disbalancedNode.right));
        newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));
        return newRoot;
    }

    // getBalanced(node)
    public int getBalancedNode(BinaryNode node){
        if(node == null){
            return 0;
        }else{
            return getHeight(node.left) - getHeight(node.right);
        }
    }

    //INSERT
    private BinaryNode insertNode(BinaryNode node, int value) {
        if (node == null) {
            BinaryNode newNode = new BinaryNode();
            newNode.value = value;
            newNode.height = 1;
            System.out.println("Value Inserted: " + value);
            return newNode;
        } else if (value < node.value) {
            node.left = insertNode(node.left, value);
        } else {
            node.right = insertNode(node.right, value);
        }
        // check if this newNode cause disbalanced node or not?
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        int balance = getBalancedNode(node);

        if(balance > 1 && value < node.left.value){
            // L-L condition - Doing - RIGHT rotation
            return rotateRight(node);
        }

        if(balance > 1 && value > node.left.value){
            // L-R condition
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        if(balance < -1 && value > node.right.value){
            // R-R condition - Doing - LEFT rotation
            return rotateLeft(node);
        }

        if(balance < -1 && value < node.right.value){
            // R-L condition
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }

    public void insert(int value){
        root = insertNode(root, value);
    }

    // DELETION
    // Rotation is not required - 3 cases - leaf Node, 1 child, 2 children
    // Step1: Find the Node aka value [value < node.value = goLeft, node > node.value = gotRight, == found ]
    // Node is a leaf node, Node has 1 child, Node has 2 children
    // 1 child deletion -> Parent assign to child...
    // 2 children deletion -> find successor of given node (it is the minimum node at the right subtree) and make it root node...

    //DELETION
    // Rotation is required - upon above 3 condition we have 4 more condition for rotation
    // LL condition, LR condition, RR condition, RL condition

    public static BinaryNode minimumNode(BinaryNode root){
        if(root.left == null){
            return root;
        }
        return minimumNode(root.left);
    }

    // Delete Node
    private BinaryNode deleteNode(BinaryNode node, int value){
        // rotation is not required
        // 1st find out the node
        // then check if rotation is required or not
        if(node == null){
            System.out.println("Value not found in AVL");
            return node;
        }
        if(value < node.value){
            node.left = deleteNode(node.left, value);
        }else if(value > node.value){
            node.right= deleteNode(node.right, value);
        }else{
            // 3 cases, 1 CHILD, 2 CHILDREN, LEAF NODE
            if(node.left != null && node.right != null){
                // 2 CHILDREN
                // find successor
                BinaryNode mininumForRight = minimumNode(node.right);
                node.value = mininumForRight.value;
                node.right = deleteNode(node.right, mininumForRight.value);
            }else if(node.left != null){
                node = node.left;
            }else if(node.right != null){
                node = node.right;
            }else{
                node = null;
            }
        }

        // check if any disbalanced node
        int balance = getBalancedNode(node);
        if(balance > 1 && getBalancedNode(node.left) >= 0){
            return rotateRight(node);
        }
        if(balance > 1 && getBalancedNode(node.left) < 0){
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }
        if(balance < -1 && getBalancedNode(node.right) <= 0){
            return rotateLeft(node);
        }
        if(balance < -1 && getBalancedNode(node.right) > 0){
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }
        return node;
    }

    public void delete(int value){
        root = deleteNode(root, value);
    }

    public void deleteAVL(){
        root = null;
        System.out.println("The AVL tree has been successfully deleted");
    }
}
