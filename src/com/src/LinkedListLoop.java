
public class LinkedListLoop {

    public static void main(String[] args) {
        SinglyNode tail1 = new SinglyNode(null, 9);
        SinglyNode head1 = SinglyNode.addLinkedList(tail1, 8, 7, 5, 7, 8, 9);
        SinglyNode.printList(head1);
    }
}
