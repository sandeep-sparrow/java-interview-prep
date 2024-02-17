package interview.companies.here.dsa.generics.stack;

import interview.companies.here.dsa.generics.GenericNode;

// vertical DS
public class GenericStack<T> {

    private GenericNode<T> top;
    private int height;

    public GenericStack(Object T){
        this.top = new GenericNode<>(T);
        this.height = 1;
    }

    public GenericNode<T> getTop() {
        return top;
    }

    public void setTop(GenericNode<T> top) {
        this.top = top;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void printStack(){
        GenericNode<T> temp = top;
        while(temp!=null){
            System.out.println("Object: " + temp.T);
            temp = temp.next;
        }
    }

    public void push(Object T){
        // create a new node
        GenericNode<T> newNode = new GenericNode<>(T);
        if (height != 0) {
            newNode.next = top;
        }
        top = newNode;
        height++;
    }

    public GenericNode<T> pop(){ // LIFO
        if(height == 0) return null;
        GenericNode<T> temp = top;
        top = top.next;
        temp.next = null;
        height--;
        return temp;
    }
}
