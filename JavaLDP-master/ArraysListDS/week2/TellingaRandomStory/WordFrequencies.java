
/**
 * Write a description of WordFrequencies here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import edu.duke.*;

class WordFrequencies {
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;
    
    public WordFrequencies() {
        myWords = new ArrayList<String>();
        myFreqs = new ArrayList<Integer>();
    }
    
    public void findUnique(){
        FileResource resource = new FileResource();
        myWords.clear();
        myFreqs.clear();
        for(String st:resource.words()){
            st = st.toLowerCase();
            int ind = myWords.indexOf(st);
            if(ind==-1){
                myWords.add(st);
                myFreqs.add(1);
            }
            else{
                int value = myFreqs.get(ind);
                myFreqs.set(ind,value+1);
            }                
        }
    }
    
    public int findIndexOfMax(){
        int maxFreqInd = 0;
        for(int i = 1;i<myFreqs.size();i++){
            int currFreq = myFreqs.get(i);
            if(currFreq>myFreqs.get(maxFreqInd))
                maxFreqInd = i;
        }
        return maxFreqInd;
    }
    
    public void tester(){
        findUnique();
        System.out.println("Total unique words : "+ myWords.size());
        int maxFreqInd = findIndexOfMax();
        System.out.println("Maximum word is \""+ myWords.get(maxFreqInd)+"\" with count "+
        myFreqs.get(maxFreqInd));        
    }
}
