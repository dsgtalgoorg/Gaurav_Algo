/*
9->8->7->5 + 8->7->6->5      5789+5678=11467

9->5 +  8->7->6->5  -> 5678+59= 5737
 */


public class LinkedListAddition {

    public static void main(String[] args) {
        SinglyNode tail1 = new SinglyNode(null, 9);
        SinglyNode head1 = SinglyNode.addLinkedList(tail1, 8, 7, 5);
        SinglyNode tail2 = new SinglyNode(null, 8);
        SinglyNode head2 = SinglyNode.addLinkedList(tail2, 7, 6, 5);

        // SinglyNode.printList(head1); 9875+8765
        // SinglyNode.printList(head2);

        addListFromLeft(head1, head2);

        SinglyNode tail11 = new SinglyNode(null, 9);
        SinglyNode head11 = SinglyNode.addLinkedList(tail11, 5);
        SinglyNode tail12 = new SinglyNode(null, 8);
        SinglyNode head12 = SinglyNode.addLinkedList(tail12, 7, 6, 5);
        addListFromLeft(head11, head12);

    }

    private static void addListFromLeft(SinglyNode head1, SinglyNode head2) {
        int carry = 0;
        SinglyNode sumList = null;
        SinglyNode head = null;
        while (head1 != null && head1 != null) {
            int addValue = head1.value + head2.value + carry;
            if (addValue > 10) {
                int temp = addValue;
                addValue = addValue % 10;
                carry = temp / 10;
            } else {
                carry = 0;
            }

            if (sumList == null) {
                sumList = new SinglyNode(null, addValue);
                head = sumList;
            } else {
                SinglyNode newObj = new SinglyNode(null, addValue);
                head.next = newObj;
                head = newObj;
            }
            head1 = head1.next;
            head2 = head2.next;
        }

        if (head1 != null) {
            while (head1 != null) {
                int addValue = head1.value + carry;
                if (addValue > 10) {
                    int temp = addValue;
                    addValue = addValue % 10;
                    carry = addValue / 10;
                } else {
                    carry = 0;
                }
                SinglyNode newObj = new SinglyNode(null, addValue);
                head.next = newObj;
                head = newObj;
                head1 = head1.next;
            }
        }

        if (head2 != null) {
            while (head2 != null) {
                int addValue = head2.value + carry;
                if (addValue > 10) {
                    int temp = addValue;
                    addValue = addValue % 10;
                    carry = addValue / 10;
                } else {
                    carry = 0;
                }
                SinglyNode newObj = new SinglyNode(null, addValue);
                head.next = newObj;
                head = newObj;
                head2 = head2.next;
            }
        }
        if (carry > 0) {
            SinglyNode newObj = new SinglyNode(null, carry);
            head.next = newObj;
        }
        SinglyNode.printList(sumList);
    }

}
