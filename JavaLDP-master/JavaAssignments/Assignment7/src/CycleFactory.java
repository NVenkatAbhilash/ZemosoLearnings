public interface CycleFactory {
    Cycle createCycle();
}

class UnicycleFactory implements CycleFactory{
    public Cycle createCycle(){
        return new Unicycle();
    }
}

class BicycleFactory implements CycleFactory{
    public Cycle createCycle(){
        return new Bicycle();
    }
}

class TricycleFactory implements CycleFactory{
    public Cycle createCycle(){
        return new Tricycle();
    }
}




