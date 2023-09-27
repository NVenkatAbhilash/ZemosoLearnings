
/**
 * Write a description of TestCaesarCipherTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;

public class TestCaesarCipherTwo {
    int[] countLetters(String message){
        int freq[] = new int[26];
        for(int i=0;i<message.length();i++){
            char ch = message.charAt(i);
            if(Character.isLetter(ch)){
                ch = Character.toLowerCase(ch);
                freq[(int)ch-'a']+=1;
            }
        }
        return freq;
    }
    
    int maxIndex(int values[]){
        int index=0;
        for(int i=1;i<values.length;i++){
            if(values[index]<values[i])
                index = i;
        }
        return index;
    }
    
    String halfOfString(String message, int start){
        StringBuilder st = new StringBuilder("");
        for(int i=start;i<message.length();i+=2){
            st.append(message.charAt(i));
        }
        return st.toString();
    }
    
    int getKey(String s){
        int freq[] = countLetters(s);
        int maxInd = maxIndex(freq);
        int key = maxInd - 4;
        if(maxInd<4){
            key = 26 - (4 - maxInd);
        }
        return key;
    }
    
    String breakCaesarCipher(String input){
        String firstHalf = halfOfString(input,0);
        String secondHalf = halfOfString(input,1);        
        int key1 = getKey(firstHalf);
        int key2 = getKey(secondHalf);
        System.out.println("Key 1 : "+key1);
        System.out.println("Key 2 : "+key2);
        CaesarCipherTwo cc = new CaesarCipherTwo(key1,key2);        
        return cc.decrypt(input);
    }
    
    void simpleTests(){
        FileResource fr = new FileResource();
        String message = fr.asString();
        CaesarCipherTwo cc = new CaesarCipherTwo(17,3);
        String encrypted = cc.encrypt(message);
        System.out.println(encrypted);
        System.out.println(cc.decrypt(encrypted));
        
        message = "Just a test string with lots of eeeeeeeeeeeeeeeees";
        encrypted = cc.encrypt(message);
        System.out.println(breakCaesarCipher(encrypted));        
    }
}
