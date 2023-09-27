import java.util.Map;

public class Main {
    private static void test(){
        String fileName = "Sample3.txt";
        CharacterFrequency characterFrequencyObject =  new CharacterFrequency(fileName);
        characterFrequencyObject.evaluateAndwriteToFile();
    }


    public static void main(String args[]){
        boolean testing = true;
        if(testing){
           test();
        }
        else{
            if(args.length==0){
                System.out.println("Enter file name as argument");
            }
            else {
                CharacterFrequency characterFrequencyObject =  new CharacterFrequency(args[0]);
                characterFrequencyObject.evaluateAndwriteToFile();
            }
        }
    }
}
