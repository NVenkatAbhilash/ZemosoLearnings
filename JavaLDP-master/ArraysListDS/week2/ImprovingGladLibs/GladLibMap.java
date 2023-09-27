import edu.duke.FileResource;
import edu.duke.URLResource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class GladLibMap {
    private ArrayList<String> trackWords;
    private ArrayList<String> consideredWords;
    private HashMap<String, ArrayList<String>> wordFileMap;
    private Random myRandom;
    private int numberOfWords;

    private static String dataSourceURL = "http://dukelearntoprogram.com/course3/data";
    private static String dataSourceDirectory = "datalong";

    public GladLibMap() {
        initializeFromSource(dataSourceDirectory);
        trackWords = new ArrayList<>();
        myRandom = new Random();
        consideredWords = new ArrayList<>();
    }

    public GladLibMap(String source) {
        initializeFromSource(source);
        trackWords = new ArrayList<>();
        myRandom = new Random();
        consideredWords = new ArrayList<>();
    }

    private void initializeFromSource(String source) {
        wordFileMap = new HashMap<>();
        wordFileMap.put("adjective", readIt(source + "/adjective.txt"));
        wordFileMap.put("noun", readIt(source + "/noun.txt"));
        wordFileMap.put("color", readIt(source + "/color.txt"));
        wordFileMap.put("country", readIt(source + "/country.txt"));
        wordFileMap.put("name", readIt(source + "/name.txt"));
        wordFileMap.put("animal", readIt(source + "/animal.txt"));
        wordFileMap.put("timeframe", readIt(source + "/timeframe.txt"));
        wordFileMap.put("verb", readIt(source + "/verb.txt"));
        wordFileMap.put("fruit", readIt(source + "/fruit.txt"));
    }

    private String randomFrom(ArrayList<String> source) {
        int index = myRandom.nextInt(source.size());
        return source.get(index);
    }

    private String getSubstitute(String label) {
        if (wordFileMap.containsKey(label))
            return randomFrom(wordFileMap.get(label));
        if (label.equals("number")) {
            return "" + myRandom.nextInt(50) + 5;
        }
        return "**UNKNOWN**";
    }

    private String processWord(String w) {
        int first = w.indexOf("<");
        int last = w.indexOf(">", first);
        if (first == -1 || last == -1) {
            return w;
        }
        numberOfWords++;
        String prefix = w.substring(0, first);
        String suffix = w.substring(last + 1);
        String sub, groupName = w.substring(first + 1, last);
        if (!consideredWords.contains(groupName))
            consideredWords.add(groupName);
        do {
            sub = getSubstitute(groupName);
        } while (trackWords.indexOf(sub)!= -1);
        trackWords.add(sub);
        return prefix + sub + suffix;
    }

    private void printOut(String s, int lineWidth) {
        int charsWritten = 0;
        for (String w : s.split("\\s+")) {
            if (charsWritten + w.length() > lineWidth) {
                System.out.println();
                charsWritten = 0;
            }
            System.out.print(w + " ");
            charsWritten += w.length() + 1;
        }
    }

    private String fromTemplate(String source) {
        String story = "";
        trackWords.clear();
        numberOfWords = 0;
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for (String word : resource.words()) {
                story = story + processWord(word) + " ";
            }
        } else {
            FileResource resource = new FileResource(source);
            for (String word : resource.words()) {
                story = story + processWord(word) + " ";
            }
        }
        return story;
    }

    private ArrayList<String> readIt(String source) {
        ArrayList<String> list = new ArrayList<String>();
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for (String line : resource.lines()) {
                list.add(line);
            }
        } else {
            FileResource resource = new FileResource(source);
            for (String line : resource.lines()) {
                list.add(line);
            }
        }
        return list;
    }

    int totalWordsInMap() {
        int total = 0;
        for (ArrayList<String> list : wordFileMap.values()) {
            total += list.size();
        }
        return total;
    }

    int totalWordsConsidered() {
        int total = 0;
        for (String groupName : consideredWords) {
            if(wordFileMap.containsKey(groupName))
                total += wordFileMap.get(groupName).size();
        }
        return total;
    }


    public void makeStory() {
        System.out.println("\n");
        String story = fromTemplate("data/madtemplate2.txt");
        printOut(story, 60);
        System.out.println("Total number of words replaced are " + numberOfWords);
        System.out.println("Total words in map are " + totalWordsInMap());
        System.out.println("Total Words Considered are "+totalWordsConsidered());
    }

}
