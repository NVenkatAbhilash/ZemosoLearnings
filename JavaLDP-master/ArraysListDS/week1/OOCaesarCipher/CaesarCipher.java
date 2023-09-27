
/**
 * Write a description of CaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CaesarCipher {
    private String alphabet,shiftedAlphabet;
    int mainKey;
    CaesarCipher(int key){
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet = alphabet.substring(key) +
                alphabet.substring(0, key);
        mainKey = key;
    }
    
    String encrypt(String input) {
        StringBuilder encrypted = new StringBuilder(input);
        char currCh;
        int ind;
        for (int i = 0; i < encrypted.length(); i++) {
            currCh = encrypted.charAt(i);
            ind = alphabet.indexOf(Character.toUpperCase(currCh));
            if (ind != -1) {
                char newCh = shiftedAlphabet.charAt(ind);
                if(Character.isLowerCase(currCh))
                    encrypted.setCharAt(i, Character.toLowerCase(newCh));
                else
                    encrypted.setCharAt(i, newCh);
            }
        }
        return encrypted.toString();
    }
    
    String decrypt(String encrypted){  
        CaesarCipher cc = new CaesarCipher(26 - mainKey);        
        return cc.encrypt(encrypted);
    }
}
