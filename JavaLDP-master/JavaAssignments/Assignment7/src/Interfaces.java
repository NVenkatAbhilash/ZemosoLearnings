interface FirstInterface {
    void firstInterfaceFirstMethod();
    void firstInterfaceSecondMethod();
}

interface SecondInterface {
    void secondInterfaceFirstMethod();
    void secondInterfaceSecondMethod();
}

interface ThirdInterface {
    void thirdInterfaceFirstMethod();
    void thirdInterfaceSecondMethod();
}

interface AddingAllInterfaces extends FirstInterface,SecondInterface,ThirdInterface{
    void newMethod();
}

class ConcreteClass{}

class FinalClass extends ConcreteClass implements AddingAllInterfaces {
    public void firstInterfaceFirstMethod(){}
    public void firstInterfaceSecondMethod(){}

    public void secondInterfaceFirstMethod(){}
    public void secondInterfaceSecondMethod(){}

    public void thirdInterfaceFirstMethod(){}
    public void thirdInterfaceSecondMethod(){}

    public void newMethod(){}

    public void firstMethod(FirstInterface object){
        System.out.println("This function takes FirstInterface as argument");
    }

    public void secondMethod(SecondInterface object){
        System.out.println("This function takes SecondInterface as argument");
    }

    public void thirdMethod(ThirdInterface object){
        System.out.println("This function takes ThirdInterface as argument");
    }

    public void fourthMethod(AddingAllInterfaces object){
        System.out.println("This function takes AddingAllInterfaces as argument");
    }
}



