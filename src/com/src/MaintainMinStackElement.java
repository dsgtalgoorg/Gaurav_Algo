import java.util.Stack;

public class MaintainMinStackElement {
    static Stack<Integer> stackValues = new Stack<>();
    static Stack<Integer> minValues = new Stack<>();

    public static void push(Integer value) {
        stackValues.push(value);
        if (minValues.empty()) {
            minValues.push(value);
        } else {
            if (minValues.peek() > value) {
                minValues.push(value);
            }
        }
    }

    public static int pop() {
        int values = stackValues.pop();
        if (values == minValues.peek()) {
            minValues.pop();
        }
        return values;
    }

    public static int min() {
        return minValues.peek();
    }

    public static void main(String[] args) {
        push(2);
        push(11);
        push(18);
        push(12);
        push(1);
        System.out.println(min());
        System.out.println(pop());
        System.out.println(min());
        System.out.println(pop());
        System.out.println(pop());
        System.out.println(min());
        push(0);
        System.out.println(min());
    }
}
