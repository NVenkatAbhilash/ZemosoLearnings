public class TwoOverloadedConstructors {
    TwoOverloadedConstructors(int oneNumber){
        System.out.println("One parameter constructor is invoked");
    }

    TwoOverloadedConstructors(int firstNumber,int secondNumber){
        this(firstNumber);
        System.out.println("Two parameter constructor is invoked");
    }
}
