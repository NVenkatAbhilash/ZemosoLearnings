
/**
 * Write a description of CaesarBreaker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;

public class CaesarBreaker {
    String decrypt(String encrypted){
        CaesarCipher cc = new CaesarCipher();
        int key = getKey(encrypted);
        String message = cc.encrypt(encrypted,26 - key);
        return message;
    }
    
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
    
    String decryptTwoKeys(String encrypted){
        //System.out.println(encrypted);
        String firstHalf = halfOfString(encrypted,0);
        String secondHalf = halfOfString(encrypted,1);        
        int key1 = getKey(firstHalf);
        int key2 = getKey(secondHalf);
        System.out.println("Key 1 : "+key1);
        System.out.println("Key 2 : "+key2);
        CaesarCipher cc = new CaesarCipher();        
        return cc.encryptTwoKeys(encrypted,26-key1,26-key2);
    }
   
    void testDecrypt(){
        //expected : "At noon be in the conference room with your hat on for a surprise party. YELL LOUD!";
        CaesarCipher cc = new CaesarCipher();
        String encrypted = cc.encrypt("Just a test string with lots of eeeeeeeeeeeeeeeees",6);
        System.out.println(decrypt(encrypted));
    }   
    
    void testDecryptTwoKeys(){
        System.out.println(decryptTwoKeys("Gwpv c vbuq pvokki yfve iqqu qc bgbgbgbgbgbgbgbgbu"));
        System.out.println(decryptTwoKeys("Akag tjw Xibhr awoa aoee xakex znxag xwko"));
    }
}
