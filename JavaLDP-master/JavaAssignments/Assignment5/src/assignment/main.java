package assignment;

class Main {
    public static void main(String args[]){
        First firstObject = new First();
        firstObject.printInstanceVariables();
        firstObject.printLocalVariables();

        Second secondObject = Second.staticMethod("sample");
        secondObject.printString();

    }
}
