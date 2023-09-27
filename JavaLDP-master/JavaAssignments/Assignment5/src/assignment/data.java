package assignment;

class First{
    private int integer;
    private char character;

    public void printInstanceVariables(){
        System.out.println(integer);
        System.out.println(character);
    }

    public void printLocalVariables(){
        int localInteger;
        char localCharacter;
        /*
        System.out.println(localInteger);
        System.out.println(localCharacter);

        member variables are initialised with default values
        such as integer with 0
        string with ""

        whereas local variables are not initialised with default values
        hence they result in build errors.
        */
    }
}