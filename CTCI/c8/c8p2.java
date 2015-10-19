import java.util.ArrayList;

enum Type{
    Complaint, Problem, Failure, Billing, Lawsuit;
}

abstract class Employee{
    String name;
    ArrayList<Type> types;

    public Employee(String n){
        this.name = n;
        types = new ArrayList<Type>();
    }

    public abstract boolean can_handle(int c);
}

class Respondent extends Employee{
    public Respondent(String n){
        super(n);
        types.add(Type.Complaint);
        types.add(Type.Problem);
        types.add(Type.Failure);
    }

    public boolean can_handle(int c){return true;}
}



public class c8p2{
    public static void main(String[] args){
        return;
    }
}
