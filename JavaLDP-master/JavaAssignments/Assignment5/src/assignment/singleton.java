package assignment;

class Second{
    private String string;

    public static Second staticMethod(String str){
        /*
        this.string = str;

        static method cannot access the member variables (anything related to "this" keyword)
        but they can create a new object of same class and
        initialise as shown below
         */
        Second obj = new Second();
        obj.string = str;
        return obj;
    }

    public void printString(){
        System.out.println(string);
    }
}