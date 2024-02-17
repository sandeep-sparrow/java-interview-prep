package datastructure.collections.list.linkedlist;

public class Main {

    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList(1);
        System.out.println("Head Value: " + linkedList.getHead().value);
        System.out.println("Tail Value: " + linkedList.getTail().value);
        System.out.println("Length :" + linkedList.getLength());

        linkedList.append(2);
        linkedList.append(3);
        linkedList.printList();
        System.out.println("Remove Last Node Value: " + linkedList.removeLast().value);
        linkedList.printList();
        System.out.println("Remove Last Node Value: " + linkedList.removeLast().value);
        System.out.println("Remove Last Node Value: " + linkedList.removeLast().value);
        linkedList.printList();
        // throw null PointerException when trying to access value;
        System.out.println("Remove Last Node Value: " + linkedList.removeLast());
        linkedList.prepend(2);
        linkedList.prepend(1);
        linkedList.printList();
        System.out.println("Remove First Value: " + linkedList.removeFirst().value);
        linkedList.printList();
        linkedList.prepend(1);
        linkedList.append(3);
        linkedList.printList();
        System.out.println("Get Method Value @Index 1: " + linkedList.get(1).value);
        System.out.println(linkedList.insert(1, 5));
        linkedList.printList();
        System.out.println("Get Method Value @Index 1: " + linkedList.get(1).value);
        System.out.println("Remove Node Value @Index 1: " + linkedList.remove(1).value);
        linkedList.printList();

        System.out.println("--- reverse ---");
        LinkedList myLinkedList = new LinkedList(1);
        myLinkedList.append(2);
        myLinkedList.append(3);
        myLinkedList.append(4);
        myLinkedList.reverse();
        myLinkedList.printList();

        LinkedNode kthNode = myLinkedList.findKthFromEnd(2); // 4, 3, 2, 1
        System.out.println("--- kth node ---");
        System.out.println(kthNode.value);
    }
}
