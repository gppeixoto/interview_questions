import java.util.LinkedList;

class Globals {
    public static int CAT = 1;
    public static int DOG = 0;
    public static int ANY = -1;
}

class Pet {
    int type;
    int timestamp;

    public Pet(int type, int timestamp) {
        this.type = type;
        this.timestamp = timestamp;
    }
}

class PetDeque {
    LinkedList<Pet> dogs, cats;
    int entry_time;

    public PetDeque() {
        this.dogs = new LinkedList<Pet>();
        this.cats = new LinkedList<Pet>();
        this.entry_time = 0;
    }

    public void enqueue(int type) {
        if (type == 0) dogs.add(new Pet(type, entry_time));
        else cats.add(new Pet(type, entry_time));
        this.entry_time += 1;
    }

    public Pet dequeue(int type) {
        if (type == 0) return dogs.removeFirst();
        else if (type == 1) return cats.removeFirst();
        if (dogs.peek().timestamp < cats.peek().timestamp) {
            return dogs.removeFirst();
        }
        return cats.removeFirst();
    }
}

public class c3p7 {
    public static void main(String[] args) {
        PetDeque pd = new PetDeque();
        pd.enqueue(Globals.CAT);
        pd.enqueue(Globals.DOG);
        pd.enqueue(Globals.CAT);
        pd.enqueue(Globals.CAT);
        pd.enqueue(Globals.DOG);
        pd.enqueue(Globals.CAT);
        System.out.println(pd.dequeue(Globals.ANY).type);
        System.out.println(pd.dequeue(Globals.ANY).type);
    }   
}