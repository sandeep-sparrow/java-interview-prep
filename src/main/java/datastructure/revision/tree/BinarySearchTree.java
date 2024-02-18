package datastructure.revision.tree;

public class BinarySearchTree {

    TreeNode root;

    public static class TreeNode{
        int value;
        TreeNode left, right;

        public TreeNode(int value){
            this.value = value;
        }
    }

    public boolean insert(int value){
        TreeNode newNode = new TreeNode(value);
        if(root == null){
            root = newNode;
            return true;
        }
        TreeNode temp = root;
        while(true){
            if(newNode.value == temp.value) return false;
            if(newNode.value < temp.value){
                if(temp.left == null){
                    temp.left = newNode;
                }
                temp = temp.left;
            }
            if(newNode.value > temp.value){
                if(temp.right == null){
                    temp.right = newNode;
                }
                temp = temp.right;
            }
        }
    }

    public boolean contains(int value){
        if(root == null) return false;
        TreeNode temp = root;
        while(temp != null){
            if(value < temp.value){
                temp = temp.left;
            }
            if(value > temp.value){
                temp = temp.right;
            }else{
                return true;
            }
        }
        return false;        
    }

    public int findMaxValue(){
        if(root == null){
            System.out.println("BST is empty!");
            return Integer.MIN_VALUE;
        }
        TreeNode currNode = root;
        while(currNode.right != null){
            currNode = currNode.right;
        }
        return currNode.value;
    }

    public TreeNode findInOrderSuccessor(TreeNode node){
        if(node == null){
            return null;
        }

        //If the right substree of the node is null,
        // then the successor is the lestmost node in right subtree
        if(node.right != null){
            TreeNode current = node.right;
            while(current.left != null){
                current = current.left;
            }
            return current;
        }

        // if the right subree of the node is null
        // than the successor is one of the ancestors of the node
        TreeNode successor = null;
        TreeNode ancestor = root;
        while (ancestor != node) {
            if(node.value < ancestor.value){
                successor = ancestor;
                ancestor = ancestor.left;
            }else{
                ancestor = ancestor.right;
            }
        }
        return successor;
    }

    // to find the length of a BST, you can implement a recursive function that traveres
    // the tree and counts the node
    public int length(TreeNode root){
        if(root == null)
            return 0;
        else
            return 1 + length(root.left) + length(root.right);
    }
    
}
