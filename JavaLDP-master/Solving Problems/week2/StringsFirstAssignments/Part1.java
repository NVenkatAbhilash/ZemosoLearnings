
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {
    String findSimpleGene(String dna){
        int startIndex,endIndex;
        String result;
        startIndex = dna.indexOf("ATG");
        if(startIndex==-1)
            return "";
        endIndex = dna.indexOf("TAA",startIndex+3);
        if(endIndex==-1 || (endIndex - startIndex)%3 != 0)
            return "";
        result = dna.substring(startIndex,endIndex+3);        
        return result;
    }
    
    void testSimpleGene(){
        String dna = "GCATCCTAGGTAACG";
        System.out.println("dna is : "+dna);
        System.out.println("gene is : "+findSimpleGene(dna));
        
        dna = "ATATGCCTAGGTA";
        System.out.println("dna is : "+dna);
        System.out.println("gene is : "+findSimpleGene(dna));
        
        dna = "CCATCCTAGGTATT";
        System.out.println("dna is : "+dna);
        System.out.println("gene is : "+findSimpleGene(dna));
        
        dna = "GCATGCCTAGGTAAT";
        System.out.println("dna is : "+dna);
        System.out.println("gene is : "+findSimpleGene(dna));
        
        dna = "GGATGCTAGGTAAT";
        System.out.println("dna is : "+dna);
        System.out.println("gene is : "+findSimpleGene(dna));        
    }
}
