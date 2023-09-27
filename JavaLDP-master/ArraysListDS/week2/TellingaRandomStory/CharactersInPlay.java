
/**
 * Write a description of CharactersInPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import edu.duke.*;

class CharactersInPlay {
    private ArrayList<String> characters;
    private ArrayList<Integer> count;
    CharactersInPlay(){
        characters = new ArrayList<>();
        count = new ArrayList<>();        
    }
    
    void update(String name){
        int ind = characters.indexOf(name);
        if(ind==-1){
            characters.add(name);
            count.add(1);
        }
        else{
            int value = count.get(ind);
            count.set(ind,value+1);
        }
    }
    
    void findAllCharacters(){
        characters.clear();
        count.clear();
        FileResource fr = new FileResource();
        for(String line:fr.lines()){
            int ind = line.indexOf('.');
            if(ind!=-1) {
                String name = line.substring(0, ind);
                update(name);
            }
        }
    }

    public int findIndexOfMax(){
        int maxFreqInd = 0;
        for(int i = 1;i<count.size();i++){
            int currFreq = count.get(i);
            if(currFreq>count.get(maxFreqInd))
                maxFreqInd = i;
        }
        return maxFreqInd;
    }

    void charactersWithNumParts(int num1,int num2){
        for(int i=0;i<characters.size();i++){
            if(count.get(i)>=num1 && count.get(i)<=num2)
                System.out.println(characters.get(i));
        }
    }

    void tester(){
        findAllCharacters();
        int ind = findIndexOfMax();
        System.out.println("Main character is "+characters.get(ind)+" wiht frequency "+count.get(ind));
        charactersWithNumParts(10,15);
    }


}
