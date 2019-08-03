import java.util.ArrayList;
import java.util.List;

public class StackArray {
    List<Integer> nextAvailable = null;
    private int lastIndex = 0;
    private int[] elements = null;
    private Stack[] stacks = null;

    public StackArray(int stackCount, int arraySize) {
        elements = new int[arraySize];
        stacks = new Stack[stackCount];
        nextAvailable = new ArrayList<>();
    }

    public boolean isFull() {
        return lastIndex == elements.length - 1;
    }

    public int pop(int stack) {
        if (stack > stacks.length - 1) {
            throw new ArrayIndexOutOfBoundsException(stack);
        }
        Stack obj = stacks[stack - 1];
        int value = elements[obj.currentIndex];
        elements[obj.currentIndex] = 0;
        nextAvailable.add(obj.currentIndex);
        stacks[stack] = stacks[obj.previousElement];
        return value;
    }

    public void push(int value, int stack) {
        if (isFull()) {
            throw new ArrayIndexOutOfBoundsException(lastIndex);
        }
        if (!nextAvailable.isEmpty()) {
            int currentIndex = nextAvailable.get(nextAvailable.size() - 1);
            nextAvailable.remove(nextAvailable.size() - 1);
            Stack obj = stacks[stack - 1];
            Stack newObject = null;
            if (obj != null) {
                newObject = new Stack(value, obj.currentIndex, currentIndex);
            } else {
                newObject = new Stack(value, 0, currentIndex);
            }
            elements[currentIndex] = value;
            stacks[stack - 1] = newObject;
        } else {
            Stack obj = stacks[stack - 1];
            Stack newObject = null;
            if (obj != null) {
                newObject = new Stack(value, obj.currentIndex, lastIndex);
            } else {
                newObject = new Stack(value, 0, lastIndex);
            }
            stacks[stack - 1] = newObject;
            elements[lastIndex] = value;
            ++lastIndex;
        }
    }

    public void print() {
        System.out.println("=======================");
        for (int i : elements) {
            System.out.println(i);
        }
    }

    class Stack {
        int value;
        int previousElement;
        int currentIndex;

        public Stack(int value, int previousElement, int currentIndex) {
            this.value = value;
            this.previousElement = previousElement;
            this.currentIndex = currentIndex;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public int getPreviousElement() {
            return previousElement;
        }

        public void setPreviousElement(int previousElement) {
            this.previousElement = previousElement;
        }

        public int getCurrentIndex() {
            return currentIndex;
        }

        public void setCurrentIndex(int currentIndex) {
            this.currentIndex = currentIndex;
        }
    }
}
