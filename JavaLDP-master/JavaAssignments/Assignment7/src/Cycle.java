public class Cycle {
}

class Unicycle extends Cycle{
    Unicycle(){
        System.out.println("Unicycle created");
    }
    public void balance(){
        System.out.println("balanced by single wheel");
    }
}

class Bicycle extends Cycle{
    Bicycle(){
        System.out.println("Bicycle created");
    }

    public void balance(){
        System.out.println("balanced by two wheel");
    }
}

class Tricycle extends Cycle{
    Tricycle(){
        System.out.println("Tricycle created");
    }

}


