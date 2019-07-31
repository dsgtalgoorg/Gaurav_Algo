// return Kth element from last

import java.util.ArrayList;
import java.util.List;

public class LinkedList_KthElement {
    public static void main(String[] args) {
        SinglyNode tail = new SinglyNode(null, 6);
        SinglyNode head = SinglyNode.addLinkedList(tail, 6, 23, 8, 89, 0, 5, 6, 5, 6, 89, 1, 9);


        //SinglyNode.printList(head);
        findElement(head, 9);


        findElement(head, 90);

    }

    private static void findElement(SinglyNode head, int i) {
        List<SinglyNode> list = new ArrayList<>();
        while (head.next != null) {
            list.add(head);
            head = head.next;
        }
        int size = list.size();
        if (size > i)
            System.out.println(list.get(list.size() - i).value);
        else
            System.out.println("Invalid");

    }
}
