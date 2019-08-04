//Implement Queue with  2 Stacks

import java.util.Stack;

public class QueueWIthStacks {
    private Stack<Integer> valueStack = new Stack();
    private Stack<Integer> backupStack = new Stack();

    public static void main(String[] args) {
        QueueWIthStacks obj = new QueueWIthStacks();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        obj.push(4);
        obj.push(5);
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        obj.push(6);
        obj.push(7);
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        obj.push(6);
        obj.push(7);
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
    }

    private void push(int value) {
        valueStack.push(value);
    }

    // copy all valueStack values to backupStack if backupStack is empty and then use backupStack for pop
    private Integer pop() {
        if (backupStack.empty()) {
            while (!valueStack.empty()) {
                backupStack.push(valueStack.pop());
            }
        }
        if (!backupStack.empty())
            return backupStack.pop();

        return null;
    }
}
