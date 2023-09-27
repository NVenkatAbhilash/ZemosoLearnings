import java.util.*;

public class Permutaion {
    private Set<String> possiblePermutations;
    char letters[];
    Permutaion(String input){
        possiblePermutations = new HashSet<>();
        letters = input.toCharArray();
    }

    private void swapLetters(int x,int y){
        char ch = letters[x];
        letters[x] = letters[y];
        letters[y] = ch;
    }

    private void generatePermutations(int start,int end){
        if(start == end-1){
            possiblePermutations.add(String.valueOf(letters));
            //System.out.println(letters);
            return;
        }
        for(int i=start;i<end;i++){
            swapLetters(start,i);
            generatePermutations(start+1,end);
            swapLetters(start,i);
        }
    }

    //acts like facade pattern
    public static List<String> getPermutations(String input) {
        Permutaion permutations = new Permutaion(input);
        permutations.generatePermutations(0,input.length());
        return new LinkedList<>(permutations.possiblePermutations);
    }
}
