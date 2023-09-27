
/**
 * Write a description of TestCaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;

public class TestCaesarCipher {
    
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
        int key = getKey(input);
        CaesarCipher cc = new CaesarCipher(key);
        return cc.decrypt(input);
    }
    
    void simpleTests(){
        FileResource fr = new FileResource();
        String message = fr.asString();
        CaesarCipher cc = new CaesarCipher(18);
        String encrypted = cc.encrypt(message);
        System.out.println(encrypted);
        System.out.println(cc.decrypt(encrypted));
        //Just a test string with lots of eeeeeeeeeeeeeeeees
        message = "Just a test string with lots of eeeeeeeeeeeeeeeees";
        encrypted = cc.encrypt(message);
        System.out.println(breakCaesarCipher(encrypted));
    }
}
