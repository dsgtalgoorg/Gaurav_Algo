// Maintain Sorting in stack elements using 2 stacks

import java.util.Stack;

public class SortStackWith2Stacks {

    private Stack<Integer> mainStack = new Stack<>();
    private Stack<Integer> backupStack = new Stack<>();

    public static void main(String[] args) {
        SortStackWith2Stacks obj = new SortStackWith2Stacks();
        obj.push(7);
        obj.push(6);
        obj.push(1);
        obj.push(2);
        obj.push(5);
        obj.push(10);
        obj.push(4);
        obj.push(1);
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());

    }

    private Integer pop() {
        if (mainStack.isEmpty()) return null;

        return mainStack.pop();
    }

    // Push element to other stack if new coming element is bigger than stack element and than
    // add new element and add moved element back to stack
    private void push(int value) {
        if (mainStack.isEmpty() || mainStack.peek() >= value) {
            mainStack.push(value);
        } else {
            while (!mainStack.isEmpty() && mainStack.peek() < value) {
                backupStack.push(mainStack.pop());
            }
            mainStack.push(value);
            while (!backupStack.isEmpty()) {
                mainStack.push(backupStack.pop());
            }
        }
    }

}
