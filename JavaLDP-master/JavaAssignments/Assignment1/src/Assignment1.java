import java.io.*;
import java.util.Scanner;
import java.util.regex.*;

/*
Documentation
File - to access files
Scanner - to take input
Pattern - to compile pattern
Matcher - to check match with pattern
 */

class Match {
    private Pattern pattern;

    Match(String input) {
        this.pattern = Pattern.compile(input);
    }

    public void printMatchingFiles(File folder) {
        for (File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory())
                printMatchingFiles(fileEntry);
            else {
                String fileName = fileEntry.getName();
                Matcher doMatch = pattern.matcher(fileName);
                if (doMatch.matches())
                    System.out.println(fileEntry.getPath());
            }
        }
    }

    public static File getHomeDirectory(){
        String homePath = System.getProperty("user.home");
        //String homePath = System.getProperty("user.dir");
        return new File(homePath);
    }
}

public class Assignment1 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter exit to stop");
        while (true) {
            String input = sc.next();
            if (input.equals("exit"))
                break;
            //pattern = Pattern.compile("[a-zA-Z0-9.]*");
            File folder = Match.getHomeDirectory();
            Match match = new Match(input);
            match.printMatchingFiles(folder);
        }
    }
}
