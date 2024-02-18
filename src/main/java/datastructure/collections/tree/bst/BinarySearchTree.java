package datastructure.collections.tree.bst;

public class BinarySearchTree {

    TreeNode root;

    public boolean insert(int value){
        // create new node
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

    public int maxInBST(){
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


    // successor of a given nonde is the node with the smallest key greater than node.val
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
        return lenght(root);
    }

    private int lenght(TreeNode root){
        if(root == null) return 0;
        else return 1 + lenght(root.left) + lenght(root.right);
    }

    public boolean rContains(int value){
        return rContains(root, value);
    }
    
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

    private TreeNode rInsert(TreeNode currNode, int value){
        if(currNode == null) return new TreeNode(value);
        if(value < currNode.value){
            currNode.left = rInsert(currNode.left, value);
        }else if(value > currNode.value){
            currNode.right = rInsert(currNode.right, value);
        }
        return currNode;
    }
}
