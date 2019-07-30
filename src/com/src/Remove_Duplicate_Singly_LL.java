//Remove duplicate from singly list without using buffer/cache like set

public class Remove_Duplicate_Singly_LL {

    public static void main(String[] args) {
        SinglyNode tail = new SinglyNode(null, 6);
        SinglyNode head = SinglyNode.addLinkedList(tail, 6, 7, 8, 9, 0, 5, 6, 5, 6, 1, 1, 4);


        SinglyNode.printList(head);
        removeDuplicateElement(head);
        SinglyNode.printList(head);

    }

    private static void removeDuplicateElement(SinglyNode current) {
        while (current.next != null) {
            SinglyNode l_node = current.next;
            SinglyNode previousNode = current;
            while (l_node.next != null) {
                if (current.value == l_node.value) {
                    previousNode.next = l_node.next;
                }
                previousNode = l_node;
                l_node = l_node.next;
            }
            current = current.next;
        }
    }
}
