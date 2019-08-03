public class StackArrayMain {

    public static void main(String[] args) {
        StackArray object = new StackArray(2, 10);
        object.push(1, 1);
        object.print();
        object.push(2, 1);
        object.print();
        object.push(10, 2);
        object.print();
        object.pop(1);
        object.print();
        object.push(9, 2);
        object.print();
    }
}
