
/**
 * Write a description of Debug here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Debug {
    public void findAbc(String input){
       int index = input.indexOf("abc");
       while (true){
           System.out.println("index " + index);
           if (index == -1 || index >= input.length() - 3){
               break;
           }
           String found = input.substring(index+1, index+4);
           System.out.println(found+" "+index);
           index = input.indexOf("abc",index+3);
           //code
           System.out.println("index after updating " + index);
       }
   }

   public void test(){
       //findAbc("abcd");
       findAbc("abcabcabcabca");
   }
}
