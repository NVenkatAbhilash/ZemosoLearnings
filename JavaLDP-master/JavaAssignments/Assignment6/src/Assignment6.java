import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Assignment6 {

    public static void main(String args[]){
        //Assignment part 1
        VampireNumber vampireObject = new VampireNumber(100);
        vampireObject.displayFirstNVampireNumbers();

        //Assignment part 2
        TwoOverloadedConstructors object = new TwoOverloadedConstructors(2,3);

        //Assignment part 3
        ArrayOfObjects array[] = new ArrayOfObjects[3];

        //Assignment part 4
        array[0] = new ArrayOfObjects("first Object");
        array[1] = new ArrayOfObjects("second Object");
        array[2]  = new ArrayOfObjects("third Object");
    }
}
