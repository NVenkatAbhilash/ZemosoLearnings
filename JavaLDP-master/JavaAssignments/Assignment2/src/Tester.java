public class Tester {
    public static void test(String input,boolean expected,int testNum){
        MatchAlphabets match = new MatchAlphabets(input);
        if(match.containsAllAlphabets()!=expected)
            System.out.println("test "+testNum+" failed for input : "+input);
    }

    public static void testAssignment2(){
        test("qwertyuiopasdfghjklzxcvbnm",true,1);
        test("1234567890-`][;'./ ",false,2);
        test("C:\\Program Files\\Java\\jdk-10.0.1\\bin\\java.exe\" \"-javaagent:C:\\Program Files\\JetBrains\\IntelliJ IDEA Community Edition 2018.2.1\\lib\\",false,3);
        System.out.println("Test completed");
    }
}
