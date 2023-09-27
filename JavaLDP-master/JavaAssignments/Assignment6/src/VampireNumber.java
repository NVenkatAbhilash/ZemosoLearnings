import java.util.LinkedList;
import java.util.List;

public class VampireNumber {
    private int numberOfVampireNumbers;
    VampireNumber(int numberOfVampireNumbers){
        this.numberOfVampireNumbers = numberOfVampireNumbers;
    }
    private int getFirstNumber(String numberAsString){
        int size = numberAsString.length();
        String firstHalf = numberAsString.substring(0,(int)size/2);
        if(firstHalf.charAt(0)=='0')
            return 0;
        int firstNumber = Integer.parseInt(firstHalf);
        return firstNumber;
    }

    private int getSecondNumber(String numberAsString){
        int size = numberAsString.length();
        String secondHalf = numberAsString.substring((int)size/2,size);
        if(secondHalf.charAt(0)=='0')
            return 0;
        int secondNumber = Integer.parseInt(secondHalf);
        return secondNumber;
    }

    private boolean isVampireNumber(int number){
        String numberAsString = String.valueOf(number);
        List<String> possiblePermutations = Permutaion.getPermutations(numberAsString);
        for(String eachNumberString:possiblePermutations){
            int firstNumber = getFirstNumber(eachNumberString);
            int secondNumber = getSecondNumber(eachNumberString);
            if(number==firstNumber*secondNumber){
                return true;
            }
        }
        return false;
    }

    public void displayFirstNVampireNumbers(){
        int start = 1000,end =10000;
        List<Integer> vampireNumbers = new LinkedList<>();
        while (true){
            for(int number = start;number<end;number++){
                if(numberOfVampireNumbers==0)
                    return;
                if(isVampireNumber(number)){
                    System.out.println(number);
                    numberOfVampireNumbers--;
                }
            }
            start*=100;
            end*=100;
        }
    }
}

/*
First few vampire numbers
1260, 1395, 1435, 1530, 1827, 2187, 6880, 102510, 104260, 105210, 105264, 105750, 108135, 110758, 115672, 116725, 117067, 118440, 120600, 123354, 124483, 125248, 125433, 125460, 125500
 */
