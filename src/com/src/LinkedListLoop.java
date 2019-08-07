
public class LinkedListLoop {

    public static void main(String[] args) {
        SinglyNode list = new SinglyNode();
        list.next = new SinglyNode(50);
        list.next.next = new SinglyNode(20);
        list.next.next.next = new SinglyNode(15);
        list.next.next.next.next = new SinglyNode(4);
        list.next.next.next.next.next = new SinglyNode(10);
        list.next.next.next.next.next.next = list.next.next.next;// assigning node with 15 value

        findLoop(list);


        SinglyNode list1 = new SinglyNode();
        list1.next = new SinglyNode(50);
        list1.next.next = new SinglyNode(20);
        list1.next.next.next = new SinglyNode(15);
        list1.next.next.next.next = new SinglyNode(4);
        list1.next.next.next.next.next = new SinglyNode(10);
        list1.next.next.next.next.next.next = new SinglyNode(100);
        findLoop(list1);

    }

    private static void findLoop(SinglyNode list) {
        SinglyNode slowPointer = list.next;
        SinglyNode fastPointer = list.next.next;

        while (fastPointer != null && fastPointer.next != null) {
            if (fastPointer == slowPointer) {
                break;
            }
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        if (fastPointer == null || fastPointer != slowPointer) System.out.println("False");
        else System.out.println(fastPointer.value);
    }
}
