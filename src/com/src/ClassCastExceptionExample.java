//https://www.softwaretestingo.com/classcastexception-exception/

//Object can be cast to parent class only if it is child object type

class Parent {
    public Parent() {
        System.out.println("An instance of the Parent class was created!");
    }
}

final class Child extends Parent {
    public Child() {
        // super();
        System.out.println("An instance of the Child class was created!");
    }
}

public class ClassCastExceptionExample {
    public static void main(String[] args) {
        Parent p = new Parent();
        Parent p1 = new Child();
        Child ch = new Child();
        ch = (Child) p1;
        ch = (Child) p; //This statement is not allowed.
    }
}