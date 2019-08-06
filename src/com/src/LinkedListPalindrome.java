
import java.util.Stack;

public class LinkedListPalindrome {
    public static void main(String[] args) {
        SinglyNode tail1 = new SinglyNode(null, 9);
        SinglyNode head1 = SinglyNode.addLinkedList(tail1, 8, 7, 5, 7, 8, 9);

        System.out.println(validatePalindromeWIthStack(head1));

        SinglyNode tail2 = new SinglyNode(null, 9);
        SinglyNode head2 = SinglyNode.addLinkedList(tail2, 8, 7, 5, 7, 8);

        System.out.println(validatePalindromeWIthStack(head2));
    }

    // Add first half in stack and then start comparison with last half singly linked list
    private static Boolean validatePalindromeWIthStack(SinglyNode head1) {

        Stack<Integer> stack = new Stack<Integer>();
        SinglyNode slowPointer = head1;
        SinglyNode fastPointer = head1;

        while (fastPointer != null && fastPointer.next != null) {
            stack.push(slowPointer.value);
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        if (fastPointer != null) {
            slowPointer = slowPointer.next;
        }

        while (slowPointer != null) {
            if (slowPointer.value != stack.pop()) {
                return false;
            }
            slowPointer = slowPointer.next;
        }

        return true;
    }
}
