package datastructure.collections.tree.bst;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {

    TreeNode root;

    // non-recursive
    public boolean insert(int value){
        TreeNode newNode = new TreeNode(value);
        if(root == null){
            root = newNode;
            return true;
        }
        TreeNode temp = root;
        while(true){
            if(newNode.value == temp.value) return false;
            if(newNode.value < temp.value ){
                if(temp.left == null){
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left;
            }else{
                if(temp.right == null){
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;
            }
        }
    }

    // non-recursive
    public boolean contains(int value){
        if(root == null) return false;
        TreeNode temp = root;
        while(temp != null){
            if(value < temp.value){
                temp = temp.left;
            }else if(value > temp.value){
                temp = temp.right;
            }else{
                return true;
            }
        }
        return false;
    }

    // non-recursive
    public int maxValue(){
        if(root == null){
            System.out.println("BST is empty");
            return Integer.MIN_VALUE;
        }
        TreeNode currNode = root;
        while(currNode.right != null){
            currNode = currNode.right;
        }
        return currNode.value;
    }

    public ArrayList<Integer> breathFirstSearch() {
        TreeNode currentNode = root;
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> results = new ArrayList<>();
        if (currentNode != null) {
            queue.add(currentNode);
        }

        while (queue.size() > 0) {
            currentNode = queue.remove();
            if (currentNode != null) { 
                results.add(currentNode.value);
                queue.add(currentNode.left);  
                queue.add(currentNode.right);
            }
        }
        return results;
    }

    // In-Order Suceccsor Defination : Successor of a given nonde is the node with the smallest key greater than node.val
    public TreeNode inorderSuccessor(TreeNode node) {
        if (node == null)
            return null;

        // If the right subtree of the node is not null,
        // then the successor is the leftmost node in the right subtree
        if (node.right != null) {
            TreeNode current = node.right;
            while (current.left != null) {
                current = current.left;
            }
            return current;
        }

        // If the right subtree of the node is null,
        // then the successor is one of the ancestors of the node
        TreeNode successor = null;
        TreeNode ancestor = root;
        while (ancestor != node) {
            if (node.value < ancestor.value) {
                successor = ancestor;
                ancestor = ancestor.left;
            } else {
                ancestor = ancestor.right;
            }
        }
        return successor;
    }

    public int lenght(){
        return length(root);
    }

    // recursive method
    private int length(TreeNode root){
        if(root == null) return 0;
        else return 1 + length(root.left) + length(root.right);
    }

    public boolean rContains(int value){
        return rContains(root, value);
    }
    
    // recursive method
    private boolean rContains(TreeNode currNode, int value){
        if(currNode == null) return false;
        if(currNode.value == value) return true;
        if(value < currNode.value){
            return rContains(currNode.left, value);
        }else{
            return rContains(currNode.right, value);
        }
    }

    public void rInsert(int value){
        if(root == null) root = new TreeNode(value);
        rInsert(root, value);
    }

    // recursive method
    private TreeNode rInsert(TreeNode currNode, int value){
        if(currNode == null) return new TreeNode(value);
        if(value < currNode.value){
            currNode.left = rInsert(currNode.left, value);
        }else if(value > currNode.value){
            currNode.right = rInsert(currNode.right, value);
        }
        return currNode;
    }

    public void rDelete(int value){
        if(root == null) return;
        rDelete(root, value);
    }

    // recursive method
    public TreeNode rDelete(TreeNode currNode, int value){
        if(currNode == null) return null;
        if(value < currNode.value){
            currNode.left = rDelete(currNode.left, value);
        }else if(value < currNode.value){
            currNode.right = rDelete(currNode.right, value);
        }else {
            if(currNode.left == null && currNode.right == null){
                return null;
            }else if (currNode.left == null){
                currNode = currNode.right;
            }else if (currNode.right == null){
                currNode = currNode.left;
            }
        }
        return currNode;
    }

    public void invert() {
        root = invertTree(root);
    }

    // recursive method
    private TreeNode invertTree(TreeNode node) {
        if (node == null) return null;
    
        TreeNode temp = node.left;
        node.left = invertTree(node.right);
        node.right = invertTree(temp);
    
        return node;
    }
}
