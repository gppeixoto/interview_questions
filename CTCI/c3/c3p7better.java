import java.util.LinkedList;

abstract class Animal {
    private int order;
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public void set_order(int ord) {this.order = ord;}
    public int get_order() {return this.order;}
    public boolean is_older(Animal a) {
        return this.order < a.get_order();
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }
}

class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }
}

class AnimalQueue {
    private LinkedList<Dog> dogs;
    private LinkedList<Cat> cats;
    private int timestamp;

    public AnimalQueue() {
        timestamp = 0;
        dogs = new LinkedList<Dog>();
        cats = new LinkedList<Cat>();
    }

    public void enqueue(Animal a) {
        a.set_order(timestamp);
        timestamp += 1;

        if (a instanceof Dog) dogs.addLast((Dog) a);
        else if (a instanceof Cat) cats.addLast((Cat) a);
    }

    public Animal dequeue_any() {
        //check for null
        if (dogs.size() == 0) return cats.removeFirst();
        else if (cats.size() == 0) return dogs.removeFirst();
        else if (cats.size() == 0 && dogs.size() == 0) {
            System.out.println("error message");
            return null;
        } 

        if (dogs.peek().is_older(cats.peek()))
            return dogs.removeFirst();
        return cats.removeFirst();
    }

    public Dog dequeue_dog() {return dogs.removeFirst();}
    public Cat dequeue_cat() {return cats.removeFirst();}
}

public class c3p7better {
    public static void main(String[] args){

    }    
}