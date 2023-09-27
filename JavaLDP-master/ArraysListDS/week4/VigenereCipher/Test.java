
/**
 * Write a description of Test here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.util.*;

public class Test {
    void testSliceString(){
        VigenereBreaker vb = new VigenereBreaker();
        System.out.println(vb.sliceString("abcdefghijklm", 0, 3));
        System.out.println(vb.sliceString("abcdefghijklm", 2, 3) );
        System.out.println(vb.sliceString("abcdefghijklm", 2, 5));
        System.out.println(vb.sliceString("abcdefghijklm", 4, 5));
    }
    
    void testTryKeyLength(){
        FileResource fr = new FileResource();
        int []key;
        VigenereBreaker vb = new VigenereBreaker();
        int len = 38;
        key = vb.tryKeyLength(fr.asString(),len,'e');
        for(int i=0;i<len;i++){
            System.out.print(key[i]+" ");
        }
        System.out.println();
        /*
        VigenereCipher vc = new VigenereCipher(key);
        String decrypted = vc.decrypt(fr.asString());
        FileResource dicFile = new FileResource("dictionaries/English");
        HashSet<String> dictionaryWords =  vb.readDictionary(dicFile);
        System.out.println(vb.countWords(decrypted,dictionaryWords));
        */
    }

    public static void main(String args[]){
        VigenereBreaker vb = new VigenereBreaker();
        vb.breakVigenere();
    }
    
}
