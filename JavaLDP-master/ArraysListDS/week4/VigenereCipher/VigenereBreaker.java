import java.util.*;
import edu.duke.*;
import java.io.*;

public class VigenereBreaker {
    public String sliceString(String message, int whichSlice, int totalSlices) {
        //REPLACE WITH YOUR CODE
        StringBuilder slicedMessage = new StringBuilder();
        for(int i=whichSlice;i<message.length();i+=totalSlices){
            slicedMessage.append(message.charAt(i));
        }
        return slicedMessage.toString();
    }

    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        int[] key = new int[klength];
        //WRITE YOUR CODE HERE
        for(int i=0;i<klength;i++){
            String slicedString = sliceString(encrypted,i,klength);
            CaesarCracker cc = new CaesarCracker(mostCommon);
            key[i] = cc.getKey(slicedString);
        }
        return key;
    }

    public void breakVigenere () {
        //WRITE YOUR CODE HERE
        FileResource fr = new FileResource("data/athens_keyflute.txt");
        String encrypted= fr.asString();
        HashMap<String,HashSet<String>> languages = new HashMap<>();
        DirectoryResource dir = new DirectoryResource();
        for(File f:dir.selectedFiles()){
            FileResource dicFile = new FileResource(f);
            HashSet<String> dictionaryWords =  readDictionary(dicFile);
            languages.put(f.getName(),dictionaryWords);
        }
        breakForAllLangs(encrypted,languages);
        //FileResource dicFile = new FileResource("dictionaries/English");
        //HashSet<String> dictionaryWords =  readDictionary(dicFile);
        //String message = breakForLanguage(encrypted,dictionaryWords);
        //System.out.println(message.substring(0,200));
    }
    
    public HashSet<String> readDictionary(FileResource fr){
        HashSet<String> words = new HashSet<>();
        for(String word : fr.lines()){
            words.add(word.toLowerCase());
        }
        return words;
    }
    
    public int countWords(String message, HashSet<String> dictionary){
        String words[] = message.split("\\W+");
        int count = 0;
        for(int i=0;i<words.length;i++){
            if(dictionary.contains(words[i].toLowerCase()))
                count++;
        }
        return count;
    }
    
    public String breakForLanguage(String encrypted, HashSet<String> dictionary){
        String message = "";
        int maxiWords = 0;
        int keyLength = 0;
        char commonChar = mostCommonCharIn(dictionary);
        for(int i=1;i<=100;i++){
            int key[] = tryKeyLength(encrypted,i,commonChar);
            VigenereCipher vc = new VigenereCipher(key);
            String decrypted = vc.decrypt(encrypted);
            int count = countWords(decrypted,dictionary);
            if(count>maxiWords){
                keyLength = i;
                maxiWords = count;
                message = decrypted;
            }
        }
        System.out.println("Key length : "+keyLength);
        System.out.println("Total valid words : "+maxiWords);
        return message;
    }
    
    public char mostCommonCharIn(HashSet<String> dictionary){
        int count[] = new int[26];
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        for(String word:dictionary){
            for(char ch: word.toLowerCase().toCharArray()){
                int ind = alphabet.indexOf(ch);
                if(ind!=-1)
                    count[ind]+=1;
            }
        }
        int maxi = 0;
        for(int i=1;i<26;i++){
            if(count[i]>count[maxi])
                maxi = i;
        }
        return alphabet.charAt(maxi);
    }
    
    public void breakForAllLangs(String encrypted, HashMap<String,HashSet<String>> languages){
        String message = "";
        int maxiWords = 0;
        int keyLength = 0;
        for(String language:languages.keySet()){
            HashSet<String> dictionary = languages.get(language);
            char commonChar = mostCommonCharIn(dictionary);
            for(int i=1;i<=100;i++){
                int key[] = tryKeyLength(encrypted,i,commonChar);
                VigenereCipher vc = new VigenereCipher(key);
                String decrypted = vc.decrypt(encrypted);
                int count = countWords(decrypted,dictionary);
                if(count>maxiWords){
                    keyLength = i;
                    maxiWords = count;
                    message = decrypted;
                }
            }
        } 
        System.out.println("Key length : "+keyLength);
        System.out.println("Total valid words : "+maxiWords);
        System.out.println(message);
    }
}
