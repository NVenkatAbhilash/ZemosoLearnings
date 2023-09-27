class FirstClass {
    //InnerClass must be static inorder to be inherited
    static class InnerClass{
        InnerClass(){}
        InnerClass(int oneInteger){
            System.out.println("InnerClass non-default constructor invoked");
        }
    }
}

//build error FirstClass.InnerClass doesn't have default constructor
class SecondClass extends FirstClass.InnerClass{
    SecondClass(int oneInteger){
        super(oneInteger);
    }
}

