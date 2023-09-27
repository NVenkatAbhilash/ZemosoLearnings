public class Main {
    private static void invokePart1() {
        Rodent array[] = new Rodent[3];
        array[0] = new Mouse();
        array[1] = new Rat();
        array[2] = new Hamster();
        System.out.println("\nObjects created\n");
        for (int i = 0; i < 3; i++) {
            array[i].display();
        }
        System.out.println();
    }

    private static void invokePart2() {
        Unicycle cycle1 = new Unicycle();
        Bicycle cycle2 = new Bicycle();
        Tricycle cycle3 = new Tricycle();
        Cycle cycleArray[] = new Cycle[3];
        cycleArray[0] = (Cycle) cycle1;
        cycleArray[1] = (Cycle) cycle2;
        cycleArray[2] = (Cycle) cycle3;

        /*
        displays error because class Cycle doesn't have balance function
        cycleArray[0].balance();
        cycleArray[1].balance();
        cycleArray[2].balance();
        */

        ((Unicycle) cycleArray[0]).balance();
        ((Bicycle) cycleArray[1]).balance();
        //displays error because class Tricycle doesn't have balance function
        //((Tricycle)cycleArray[2]).balance();
        System.out.println();
    }

    private static void invokePart3() {
        FirstInterface firstIObject = new FinalClass();
        //DownCasting must be done to invoke the four methods
        ((FinalClass) firstIObject).firstMethod(firstIObject);

        //below three methods shows build errors FirstInterface can not be converted to ..
        //so respective casting must be performed
        ((FinalClass) firstIObject).secondMethod((SecondInterface) firstIObject);
        ((FinalClass) firstIObject).thirdMethod((ThirdInterface) firstIObject);
        ((FinalClass) firstIObject).fourthMethod((AddingAllInterfaces) firstIObject);
        System.out.println();
    }

    private static void invokePart4() {
        CycleFactory uniFactory = new UnicycleFactory();
        Cycle unicycleObject = uniFactory.createCycle();
        CycleFactory biFactory = new BicycleFactory();
        Cycle bicycleObject = biFactory.createCycle();
        CycleFactory triFactory = new TricycleFactory();
        Cycle tricycleObject = triFactory.createCycle();
    }

    private static void invokePart5() {
        SecondClass object = new SecondClass(1);
    }

    public static void main(String args[]) {
        //part 1
        invokePart1();

        //part2
        invokePart2();

        //part3
        invokePart3();

        //part4
        invokePart4();

        //part5
        invokePart5();
    }
}
