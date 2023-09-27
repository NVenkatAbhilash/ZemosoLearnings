
/**
 * Write a description of CaesarCipherTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CaesarCipherTwo {
    private String alphabet,shiftedAlphabet1,shiftedAlphabet2;
    int key1,key2;
    CaesarCipherTwo(int key1,int key2){
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet1 = alphabet.substring(key1) +
                alphabet.substring(0, key1);
        shiftedAlphabet2 = alphabet.substring(key2) +
                alphabet.substring(0, key2);
        this.key1 = key1;
        this.key2 = key2;
    }
    
    String encrypt(String input){
        StringBuilder encrypted = new StringBuilder(input);
        char currCh,newCh;
        int ind;
        for (int i = 0; i < encrypted.length(); i++) {
            currCh = encrypted.charAt(i);
            ind = alphabet.indexOf(Character.toUpperCase(currCh));
            if (ind != -1) {
                if(i%2==0)
                    newCh = shiftedAlphabet1.charAt(ind);
                else
                    newCh = shiftedAlphabet2.charAt(ind);
                if(Character.isLowerCase(currCh))
                    encrypted.setCharAt(i, Character.toLowerCase(newCh));
                else
                    encrypted.setCharAt(i, newCh);
            }
        }
        return encrypted.toString();
    }
    
    String decrypt(String input){
        CaesarCipherTwo cc = new CaesarCipherTwo(26-key1,26-key2);
        return cc.encrypt(input);
    }    
}
