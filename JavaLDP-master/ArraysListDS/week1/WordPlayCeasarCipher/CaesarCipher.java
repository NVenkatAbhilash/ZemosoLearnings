
/**
 * Write a description of CaesarCipher here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import edu.duke.*;

public class CaesarCipher {
    public String encrypt(String input, int key) {
        StringBuilder encrypted = new StringBuilder(input);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char currCh;
        int ind;
        String shiftedAlpha = alphabet.substring(key) +
                alphabet.substring(0, key);
        for (int i = 0; i < encrypted.length(); i++) {
            currCh = encrypted.charAt(i);
            ind = alphabet.indexOf(Character.toUpperCase(currCh));
            if (ind != -1) {
                char newCh = shiftedAlpha.charAt(ind);
                if(Character.isLowerCase(currCh))
                    encrypted.setCharAt(i, Character.toLowerCase(newCh));
                else
                    encrypted.setCharAt(i, newCh);
            }
        }
        return encrypted.toString();
    }

    public String encryptTwoKeys(String input, int key1, int key2) {
        StringBuilder encrypted = new StringBuilder(input);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char currCh,newCh;
        int ind;
        String shiftedAlpha1 = alphabet.substring(key1) +
                alphabet.substring(0, key1);
        String shiftedAlpha2 = alphabet.substring(key2) +
                alphabet.substring(0, key2);
        for (int i = 0; i < encrypted.length(); i++) {
            currCh = encrypted.charAt(i);
            ind = alphabet.indexOf(Character.toUpperCase(currCh));
            if (ind != -1) {
                if(i%2==0)
                    newCh = shiftedAlpha1.charAt(ind);
                else
                    newCh = shiftedAlpha2.charAt(ind);
                if(Character.isLowerCase(currCh))
                    encrypted.setCharAt(i, Character.toLowerCase(newCh));
                else
                    encrypted.setCharAt(i, newCh);
            }
        }
        return encrypted.toString();
    }

    void testCaesar() {
        String msg = "At noon be in the conference room with your hat on for a surprise party. YELL LOUD!";
        System.out.println(encrypt(msg,15));
        int key = 17;
        FileResource fr = new FileResource();
        String message = fr.asString();
        String encrypted = encrypt(message, key);
        System.out.println("key is " + key + "\n" + encrypted);
        //String decrypted = encrypt(encrypted, 26-key);
        //System.out.println(decrypted);
    }
    
    void testEncryptTwoKeys(){
        // expected  “Czojq Ivdzle”
        System.out.println(encryptTwoKeys("First Legion", 23, 17));
        
        //System.out.println(encryptTwoKeys("Top ncmy qkff vi vguv vbg ycpx", 24, 6));
        //String msg = "At noon be in the conference room with your hat on for a surprise party. YELL LOUD!";
        //System.out.println(encryptTwoKeys(msg,8,21));
    }
}
