package datastructure.collections.stack;

public class Stack {

    private Node top;
    private int height;

    public Stack(int value){
        this.top = new Node(value);
        height = 1;
    }

    public void printStack(){
        Node temp = top;
        while(temp != null){
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void getTop() {
        System.out.println("Top Value: " + top.value);
    }

    public void getheight() {
        System.out.println("height: " + height);
    }

    public void setheight(int height) {
        this.height = height;
    }

    public void setTop(Node top) {
        this.top = top;
    }
    
    public void push(int value){
        Node newNode = new Node(value);
        if (height != 0) {
            newNode.next = top;
        }
        top = newNode;
        height++;
    }

    public Node pop(){
        if(height == 0) return null;
        Node temp = top;
        top = top.next;
        temp.next = null;
        height--;
        return temp;
    }
}
