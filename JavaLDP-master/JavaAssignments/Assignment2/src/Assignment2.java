import java.util.Scanner;

/*
Time Complexity     :  O(n)
Space Complexity    :  O(n)
 */
class MatchAlphabets {
    private boolean checkAlphabets[];
    private String input;

    MatchAlphabets(String input) {
        checkAlphabets = new boolean[26];
        this.input = input.toLowerCase();
    }

    private boolean isAlphabet(char ch) {
        if (ch >= 'a' && ch <= 'z')
            return true;
        return false;
    }

    public boolean containsAllAlphabets() {
        int count = 0;
        for (char ch : input.toCharArray()) {
            if (isAlphabet(ch) && !checkAlphabets[ch - 'a']) {
                checkAlphabets[ch - 'a'] = true;
                count++;
                if (count == 26)
                    break;
            }
        }
        if (count == 26) {
            System.out.println("contains all alphabets");
            return true;
        }
        System.out.println("do not contain all alphabets");
        return false;
    }
}

public class Assignment2 {
    public static void main(String args[]) {
        boolean takeInput = false;
        if(takeInput) {
            Scanner sc = new Scanner(System.in);
            String input = sc.next();
            MatchAlphabets match = new MatchAlphabets(input);
            match.containsAllAlphabets();
        }
        else
            Tester.testAssignment2();
    }
}
