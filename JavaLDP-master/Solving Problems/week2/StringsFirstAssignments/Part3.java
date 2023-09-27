
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
    boolean twoOccurrences(String stringa,String stringb){
        int firstIndex = stringb.indexOf(stringa);
        int searchSecondIndexFrom = firstIndex+stringa.length();
        if(firstIndex==-1 || searchSecondIndexFrom>=stringb.length())
            return false;
        int secondIndex = stringb.indexOf(stringa,searchSecondIndexFrom);
        if(secondIndex != -1)
            return true;
        else
            return false;
    }
    
    String lastPart(String stringa, String stringb){
        int firstIndex = stringb.indexOf(stringa);
        if(firstIndex==-1)
            return stringb;
        else
            return stringb.substring(firstIndex+stringa.length(),stringb.length());
    }
    
    void displayTest(String stringa,String stringb){
        System.out.println("Stringa : "+stringa +" Stringb : "+stringb);
        if(twoOccurrences(stringa,stringb)){
            System.out.println("result : true");
        }
        else
            System.out.println("result : false");
    }
    
    void testing(){
        //true cases
        displayTest("by","A story by Abby Long");
        displayTest("a","banana");
        //false cases
        displayTest("atg","ctgtatgta");
        
        //test Last Part
        System.out.println(lastPart("an","banana"));
        System.out.println(lastPart("zoo","forest"));        
    }
}
