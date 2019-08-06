
public class LinkedListInterSection {
    public static void main(String[] args) {
        SinglyNode tail1 = new SinglyNode(null, 9);
        SinglyNode head1 = SinglyNode.addLinkedList(tail1, 8, 7, 5, 7, 8, 9);

        SinglyNode tail2 = new SinglyNode(null, 7);
        SinglyNode head2 = SinglyNode.addLinkedList(tail2, 8, 9);

        validIntersection(head1, 7, head2, 3);


        SinglyNode tail11 = new SinglyNode(null, 9);
        SinglyNode head11 = SinglyNode.addLinkedList(tail11, 8, 7, 5, 7, 8, 9);

        SinglyNode tail21 = new SinglyNode(null, 5);
        SinglyNode head21 = SinglyNode.addLinkedList(tail21, 6, 9);

        validIntersection(head21, 3, head11, 7);
    }


    private static void validIntersection(SinglyNode first, int len1, SinglyNode second, int len2) {

        //traverse longest till shortest length
        SinglyNode intersectionNode = null;

        if (len1 > len2) {
            while (len1 != len2) {
                first = first.next;
                --len1;
            }
            intersectionNode = first;
        } else {
            while (len1 != len2) {
                second = second.next;
                --len2;
            }
            intersectionNode = second;
        }

        //Compare both linked list
        while (first != null && second != null && first.value == second.value) {
            first = first.next;
            second = second.next;

        }
        if (first == null)
            SinglyNode.printList(intersectionNode);
        else System.out.println("Nothing");
    }
}
