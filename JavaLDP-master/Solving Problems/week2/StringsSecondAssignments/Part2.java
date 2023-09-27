
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    int howMany(String stringa,String stringb){
        int searchFrom=0,count=0;
        while(true){
            searchFrom = stringb.indexOf(stringa,searchFrom);
            if(searchFrom == -1)
                break;
            count+=1;
            searchFrom += stringa.length();
        }
        return count;
    }
    
    void testHowMany(){
        //test 1
        if(howMany("GAA", "ATGAACGAATTGAATC")!=3)
            System.out.println("test 1 failed");
        //test 2
        if(howMany("AA", "AAAA")!=2)
            System.out.println("test 2 failed");
        //test 3
        if(howMany("ABCD", "ABCD")!=1)
            System.out.println("test 3 failed");
        //test 4
        if(howMany("QWE", "ATGAACGAATTGAATC")!=0)
            System.out.println("test 4 failed");
        System.out.println("Test set passed");
    }
}
