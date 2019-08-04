import java.util.ArrayList;
import java.util.List;

public class LinkedList_Partition {
    public static void main(String[] args) {
        SinglyNode tail = new SinglyNode(null, 6);
        SinglyNode head = SinglyNode.addLinkedList(tail, 6, 23, 8, 89, 0, 5, 6, 5, 6, 89, 1, 9);

        SinglyNode.printList(head);

        partitionWith2List(head, 8);
    }

    private static void partition(SinglyNode head, SinglyNode tail, int i) {

        while (tail == head) {
            if (tail.value < i && head.value >= i) {
                SinglyNode temp = head;
                head.value = tail.value;
                head.next = tail.next;

                tail.value = temp.value;
                tail.next = temp.next;


                head = head.next;
                tail = tail.next;
            }

            if (tail.value < i) {

            }
        }
    }


    private static void partitionWith2List(SinglyNode head, int i) {
        List<SinglyNode> shortList = new ArrayList<SinglyNode>();
        List<SinglyNode> bigList = new ArrayList<SinglyNode>();
        SinglyNode finalhead = new SinglyNode();

        while (head.next != null) {
            if (head.value < i) {
                shortList.add(head);
            } else {
                bigList.add(head);
            }
            head = head.next;
        }

        SinglyNode previous = finalhead;
        for (SinglyNode node : shortList) {
            if (previous != null) {
                finalhead.next = node.next;
                finalhead.value = node.value;
                previous.next = finalhead.next;
                previous.value = finalhead.value;
            }
        }
        for (SinglyNode node : bigList) {
            if (previous != null) {
                finalhead.next = finalhead.next;
                finalhead.value = finalhead.value;
                previous.next = finalhead.next;
                previous.value = finalhead.value;
            }

        }
        SinglyNode.printList(finalhead);
    }
}
