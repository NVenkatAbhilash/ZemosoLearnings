
/**
 * Write a description of CodonCount here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.*;
import edu.duke.*;

public class CodonCount {
    private HashMap<String, Integer> codonCount;

    CodonCount() {
        codonCount = new HashMap<>();
    }

    void buildCodonMap(int start, String dna) {
        codonCount.clear();
        for (int i = start+3; i <= dna.length(); i += 3) {
            String codon = dna.substring(i-3, i);
            if (codonCount.containsKey(codon)) {
                codonCount.put(codon, codonCount.get(codon) + 1);
            } else {
                codonCount.put(codon, 1);
            }
        }
    }

    String getMostCommonCodon() {
        String key = "";
        for (String codon : codonCount.keySet()) {
            if (key.equals("")) {
                key = codon;
                continue;
            }
            if (codonCount.get(codon) > codonCount.get(key))
                key = codon;
        }
        return key;
    }

    void printCodonCounts(int start, int end) {
        for (String codon : codonCount.keySet()) {
            int value = codonCount.get(codon);
            //System.out.println("outside "+codon + " : " + codonCount.get(codon));
            if (start <=value  && value <= end)
                System.out.println("inside "+codon + " : " + codonCount.get(codon));
        }
    }

    void tester() {
        FileResource fr = new FileResource();
        String dna = fr.asString().trim();
        for (int i = 0; i < 3; i++) {
            buildCodonMap(i, dna);
            System.out.println("Reading frame starting with " + i + " results in " + codonCount.size() + " unique codons");
            String commonCodon = getMostCommonCodon();
            System.out.println("and most common codon is "+commonCodon+" with count "+codonCount.get(commonCodon));
            int start = 1,end = 5;
            System.out.println("Counts of codons between "+start+" and "+end+" inclusive are:");
            printCodonCounts(start,end);
        }
    }

}
