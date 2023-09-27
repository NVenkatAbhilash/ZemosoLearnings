import java.util.regex.Pattern;

public class TestSentence {
    private static void test(String input, boolean expected, int testNumber) {
        Sentence sentenceObject = new Sentence(input);
        if (expected != sentenceObject.checkSentence()) {
            System.out.println("test case " + testNumber + " failed");
        }
    }

    private static void runAllTests() {
        test("This is a sentence.", true, 1);
        test("this is not a sentence.", false, 2);
        test("This is not a sentence", false, 3);
        test("T.", true, 4);
        System.out.println("Tests completed");
    }

    public static void main(String args[]) {
        runAllTests();
    }
}
