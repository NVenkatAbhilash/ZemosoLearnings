
/**
 * Write a description of WordLengths here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;

public class WordLengths {
    void countWordLengths(FileResource resource, int counts[]){
        int maxInd = counts.length-1;
        int currentLen;
        for(String word:resource.words()){
            currentLen = word.length();
            if(!Character.isLetter(word.charAt(currentLen-1)))
                currentLen--;
            if(!Character.isLetter(word.charAt(0)) && currentLen!=0)
                currentLen--;
            if(currentLen>maxInd)
                currentLen = maxInd;
            counts[currentLen]+=1;
        }
    }
    
    int indexOfMax(int values[]){
        int index=0;
        for(int i=1;i<values.length;i++){
            if(values[index]<values[i])
                index = i;
        }
        return index;
    }
    
    void testCountWordLengths(){
        FileResource fr = new FileResource();
        int []counts = new int[31];
        countWordLengths(fr,counts);
        for(int i=1;i<counts.length;i++){
            if(counts[i]!=0)
                System.out.println(counts[i]+" words of length "+i);
        }
        System.out.println("max length index is "+indexOfMax(counts));
    }
}

