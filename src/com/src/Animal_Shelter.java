//An animal shelter holds only dogs and cats, and operates on a strictly "first in, first out" basis.
// People must adopt either the "oldest" (based on arrival time) of all animals at the shelter, or
// they can select whether they would prefer a dog or a cat (and will receive the oldest animal of that type).
// They cannot select which specific animal they would like.
// Create the data structures to maintain this system and implement operations such as enqueue, dequeueAny, dequeueDog and dequeueCat.


import java.util.LinkedList;
import java.util.List;

class Animal {
    private int order = 0;

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public boolean isShort(Animal a) {
        return this.order < a.order;
    }

}

class Cat extends Animal {

}

class Dog extends Animal {

}


public class Animal_Shelter {

    List<Animal> dogs = new LinkedList<>();
    List<Animal> cats = new LinkedList<>();
    private int mainOrder = 0;

    public static void main(String[] args) {
        Animal_Shelter animal_shelter = new Animal_Shelter();
        Animal obj1 = new Dog();
        Animal obj2 = new Dog();
        Animal obj3 = new Cat();
        Animal obj4 = new Dog();
        Animal obj5 = new Cat();
        Animal obj6 = new Cat();
        Animal obj7 = new Dog();
        Animal obj8 = new Cat();
        animal_shelter.enqueue(obj1);
        animal_shelter.enqueue(obj2);
        animal_shelter.enqueue(obj3);
        animal_shelter.enqueue(obj4);
        animal_shelter.enqueue(obj5);
        animal_shelter.enqueue(obj6);
        animal_shelter.enqueue(obj7);
        animal_shelter.enqueue(obj8);
        System.out.println(animal_shelter.dequeueCat().getOrder());
        System.out.println(animal_shelter.dequeueDog().getOrder());
        System.out.println(animal_shelter.dequeueAny().getOrder());
        System.out.println(animal_shelter.dequeueDog().getOrder());
        System.out.println(animal_shelter.dequeueCat().getOrder());
    }

    private void enqueue(Animal animal) {
        animal.setOrder(++mainOrder);
        if (animal.getClass() == Dog.class) {
            dogs.add(animal);
        }
        if (animal.getClass() == Cat.class) {
            cats.add(animal);
        }
    }

    private Animal dequeueAny() {
        int dogSize = dogs.size();
        int catSize = cats.size();
        if (dogSize == 0 || (dogs.get(dogSize - 1).isShort(cats.get(catSize - 1)))) {
            Animal obj = cats.get(catSize - 1);
            cats.remove(catSize - 1);
            return obj;
        } else if (catSize == 0 || !(dogs.get(dogSize - 1).isShort(cats.get(catSize - 1)))) {
            Animal obj = dogs.get(dogSize - 1);
            dogs.remove(dogSize - 1);
            return obj;
        } else {
            return null;
        }
    }

    private Animal dequeueDog() {
        if (!dogs.isEmpty()) {
            Animal obj = dogs.get(dogs.size() - 1);
            dogs.remove(dogs.size() - 1);
            return obj;
        }
        return null;
    }

    private Animal dequeueCat() {
        if (!cats.isEmpty()) {
            Animal obj = cats.get(cats.size() - 1);
            cats.remove(cats.size() - 1);
            return obj;
        }
        return null;
    }
}
