package datastructure.collections.tree.bst;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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

        while (!queue.isEmpty()) {
            currentNode = queue.remove();
            if (currentNode != null) { 
                results.add(currentNode.value);
                queue.add(currentNode.left);  
                queue.add(currentNode.right);
            }
        }
        return results;
    }

    // Pre-Order DFS - uses recursion
    public ArrayList<Integer> DFSPreOrderRecursion() {
        ArrayList<Integer> results = new ArrayList<>();

        class Traverse{
            Traverse(TreeNode currentNode){
                results.add(currentNode.value);
                if(currentNode.left != null){
                    new Traverse(currentNode.left);
                }
                if(currentNode.right != null){
                    new Traverse(currentNode.right);
                }
            }
        }
        new Traverse(root);
        return results;
    }

    // Pre-Order DFS - using iteration
    public ArrayList<Integer> DFSPreOrderIteration(TreeNode root){
        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> results = new ArrayList<>();
        while(!stack.isEmpty() || current != null){
            if(current != null){
                results.add(current.value);
                stack.push(current.right);
                current = current.left;
            } else {
                current = stack.pop();
            }
        }
        return results;
    }

    // Post-Order DFS - using iteration
    public ArrayList<Integer> DFSPostOrderIteration(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        Stack<Boolean> visited = new Stack<>();
        ArrayList<Integer> results = new ArrayList<>();
        stack.push(root);
        visited.push(false);
        while(!stack.isEmpty()){
            TreeNode current = stack.pop();
            Boolean isVisited = visited.pop();
            if (current != null) {
                if (isVisited) {
                    results.add(current.value);
                } else {
                    stack.push(current);
                    visited.push(true);
                    stack.push(current.right);
                    visited.push(false);
                    stack.push(current.left);
                    visited.push(false);
                }
            }
        }
        return results;
    }

    // Post-Order DFS - users recursion
    public ArrayList<Integer> DFSPostOrderRecursion(){
        ArrayList<Integer> results = new ArrayList<>();

        class Traverse{
            Traverse(TreeNode currentNode){
                if(currentNode.left != null){
                    new Traverse(currentNode.left);
                }
                if(currentNode.right != null){
                    new Traverse(currentNode.right);
                }
                results.add(currentNode.value);
            }
        }
        new Traverse(root);
        return results;
    }

    // In-Order DFS - users recursion
    public ArrayList<Integer> DFSInOrderRecursion(){
        ArrayList<Integer> results = new ArrayList<>();

        class Traverse{
            Traverse(TreeNode currentNode){
                if(currentNode.left != null){
                    new Traverse(currentNode.left);
                }
                results.add(currentNode.value);
                if(currentNode.right != null){
                    new Traverse(currentNode.right);
                }
            }
        }
        new Traverse(root);
        return results;
    }

    public Boolean isValidBST(){
        // Perform an in-order traversal of the tree. This should
        // result in a list of node values in ascending order if
        // the tree is a valid binary search tree (BST).
        ArrayList<Integer> nodeValues = DFSInOrderRecursion();
        // Start from the second element (index 1) and compare each
        // element with its predecessor to ensure the list is in
        // strictly ascending order. The in-order traversal of a BST
        // should produce a sorted list of values where each value
        // is greater than the previous one.
        for (int i = 1; i < nodeValues.size(); i++) {
            // If the current value is less than or equal to the previous
            // value, it means the list is not in ascending order. Thus,
            // the tree is not a valid BST. Return false in this case.
            if (nodeValues.get(i) <= nodeValues.get(i - 1)) {
                return false; // Not in ascending order
            }
        }

        // If the loop completes without finding any out-of-order elements,
        // it means the in-order traversal resulted in a sorted list, and
        // therefore, the tree is a valid BST. Return true in this case.
        return true;
    }


    // In-Order Suceccsor Defination : Successor of a given node is the node with the smallest key greater than node.val
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
