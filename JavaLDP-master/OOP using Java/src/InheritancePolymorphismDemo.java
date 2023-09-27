class Parent{
    Parent(){
        super();
        System.out.println("Parent default constructor called");
    }

    Parent(int a){
        this();
        System.out.println("Parent parametrised constructor called");
    }


    void methodOverriding(){
        System.out.println("Parent method overriding");
    }

    void methodOverloading(){
        System.out.println("Method Overloading with no parameters");
    }

    void methodOverloading(int a){
        System.out.println("Method Overloading with one parameters");
    }

    void parentMethod(){
        this.methodOverriding();
        System.out.println("Parent Method called");
    }
}

class Child extends Parent{
    Child(){
        super();
        System.out.println("Child default constructor called");
    }

    Child(int a){
        super(a);
        System.out.println("Child parametrised constructor called");
    }

    void methodOverriding(){
        System.out.println("Child method overriding");
    }

    void typeCasting(){
        System.out.println("Type Casting is carried out");
    }
}

public class InheritancePolymorphismDemo {
    public static void main(String args[]){
        Parent obj = new Child();
        System.out.println("------1------");
        Parent obj1 = new Child(1);
        System.out.println("------2------");
        obj.methodOverloading();
        System.out.println("------3------");
        obj.methodOverloading(0);
        System.out.println("------4------");
        obj.methodOverriding();
        System.out.println("------5------");
        ((Child) obj).typeCasting();
        System.out.println("------6------");
        obj.parentMethod();
    }
}
