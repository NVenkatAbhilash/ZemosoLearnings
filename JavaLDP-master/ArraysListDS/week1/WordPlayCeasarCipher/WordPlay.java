
/**
 * Write a description of WordPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WordPlay {
    boolean isVowel(char ch){
        ch = Character.toLowerCase(ch);
        if(ch == 'a' || ch == 'e' ||ch == 'i' ||ch == 'o' ||ch == 'u' )
            return true;
        return false;
    }
    
    String replaceVowels(String phrase, char ch){
        StringBuilder modified = new StringBuilder(phrase);
        for(int i=0;i<phrase.length();i++){
            if(isVowel(phrase.charAt(i))){
                modified.setCharAt(i,ch);
            }
        }
        return modified.toString();
    }
    
    String emphasize(String phrase,char ch){
        StringBuilder modified = new StringBuilder(phrase);
        char letter;
        char lowerCh = Character.toLowerCase(ch);
        char upperCh = Character.toUpperCase(ch);
        for(int i=0;i<phrase.length();i++){
            letter = phrase.charAt(i);
            if(letter==upperCh || letter==lowerCh){
                if(i%2==0)
                    modified.setCharAt(i,'*');
                else
                    modified.setCharAt(i,'+');
            }
        }
        return modified.toString();
    }
    
    void testIsVowel(){
        System.out.println(isVowel('I'));
        System.out.println(isVowel('2'));
        System.out.println(isVowel('*'));
    }
    
    void testReplaceVowels(){
        System.out.println(replaceVowels("aeiou",'*'));
        System.out.println(replaceVowels("AE***BEDOU",'*'));
        System.out.println(replaceVowels("2a3E4i5O6u&",'*'));
    }
    
    void testEmphasize(){
        //expected “dn* ctg+*+ctg+”
        System.out.println(emphasize("dna ctgaaactga", 'a'));
        //expected “M+ry Bell+ +br*c*d*br+”
        System.out.println(emphasize("Mary Bella Abracadabra", 'a'));
    }
}
