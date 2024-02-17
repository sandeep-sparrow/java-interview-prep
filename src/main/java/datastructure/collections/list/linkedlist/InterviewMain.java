package datastructure.collections.list.linkedlist;

public class InterviewMain {

    public static void main(String[] args) {
        // find if loop exists in given linkedList
        LinkedList linkedList = new LinkedList(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.append(5);

        // create a loop by connecting the tail to second node
        linkedList.getTail().next = linkedList.getHead().next;

        System.out.println("Has Loop?");
        System.out.println(linkedList.hasLoop());

        LinkedList myLinkedList = new LinkedList(1);
        myLinkedList.append(2);
        myLinkedList.append(3);
        myLinkedList.append(4);
        myLinkedList.append(3);
        myLinkedList.append(5);

        System.out.println("Remove Duplicates!");
        myLinkedList.removeDuplicates();
        myLinkedList.printAll();
    }
}
