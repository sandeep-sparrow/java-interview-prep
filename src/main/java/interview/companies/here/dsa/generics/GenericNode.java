package interview.companies.here.dsa.generics;

public class GenericNode<T>{
    public Object T;
    public GenericNode<T> next;

    public GenericNode(Object T){
        this.T = T;
    }
}
