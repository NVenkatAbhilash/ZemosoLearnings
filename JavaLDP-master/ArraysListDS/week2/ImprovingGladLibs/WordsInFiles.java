import java.util.*;
import edu.duke.*;
import java.io.*;

public class WordsInFiles {
    private HashMap<String,ArrayList<String>> wordMap;
    WordsInFiles(){
        wordMap = new HashMap<>();
    }

    void addWordsFromFile(File f){
        String fileName = f.getName();
        FileResource fr = new FileResource(f);
        for(String word:fr.words()){
            if(wordMap.containsKey(word)){
                if(!wordMap.get(word).contains(fileName)){
                    wordMap.get(word).add(fileName);
                }
            }
            else{
                wordMap.put(word,new ArrayList<String>());
                wordMap.get(word).add(fileName);
            }
        }
    }

    void buildWordFileMap(){
        wordMap.clear();
        DirectoryResource dir = new DirectoryResource();
        for(File f:dir.selectedFiles()){
            addWordsFromFile(f);
        }
    }

    int maxNumber(){
        int maxFiles = 0;
        for(ArrayList<String> list:wordMap.values()){
            int count = list.size();
            if(count>maxFiles){
                maxFiles = count;
            }
        }
        return maxFiles;
    }

    ArrayList<String> wordsInNumFiles(int number){
        ArrayList<String> wordList = new ArrayList<>();
        for(String word:wordMap.keySet()){
            if(wordMap.get(word).size()==number)
                wordList.add(word);
        }
        return wordList;
    }

    void printFilesIn(String word){
        ArrayList<String> list = wordMap.get(word);
        for(String fileName:list){
            System.out.println(fileName);
        }
    }

    void tester(){
        buildWordFileMap();
        int num = maxNumber();
        //int num = 4;
        System.out.println(num);
        ArrayList<String> list = wordsInNumFiles(num);
        System.out.println("Total words "+list.size());
        for(String word:list){
            System.out.println(word+" is present in following files");
            printFilesIn(word);
            System.out.println();
        }
        System.out.println("------------");
        
    }
}
