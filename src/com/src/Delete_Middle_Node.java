// Delete middle node without travel

public class Delete_Middle_Node {
    public static void main(String[] args) {
        SinglyNode tail = new SinglyNode(null, 6);
        SinglyNode obj1 = new SinglyNode(tail, 1);
        SinglyNode obj2 = new SinglyNode(obj1, 4);
        SinglyNode obj3 = new SinglyNode(obj2, 5);
        SinglyNode obj4 = new SinglyNode(obj3, 7);
        SinglyNode obj5 = new SinglyNode(obj4, 8);
        SinglyNode obj6 = new SinglyNode(obj5, 9);
        SinglyNode obj7 = new SinglyNode(obj6, 10);
        SinglyNode head = new SinglyNode(obj7, 11);

        SinglyNode.printList(head);
        deleteMiddleNode(obj4);
        SinglyNode.printList(head);
    }

    private static void deleteMiddleNode(SinglyNode obj) {
        SinglyNode temp = obj.next;
        obj.value = temp.value;
        obj.next = temp.next;
    }
}
