
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    String findSimpleGene(String dna, String startCodon, String stopCodon  ){
        int startIndex,endIndex;
        String dnaCopy = dna;
        String result;
        dna = dna.toUpperCase();
        startCodon = startCodon.toUpperCase();
        stopCodon = stopCodon.toUpperCase();
        startIndex = dna.indexOf(startCodon);
        if(startIndex==-1)
            return "";
        endIndex = dna.indexOf(stopCodon,startIndex+3);
        if(endIndex==-1 || (endIndex - startIndex)%3 != 0)
            return "";
        result = dnaCopy.substring(startIndex,endIndex+3);        
        return result;
    }
    
    void testSimpleGene(){
        String dna = "GCATCCTAGGTAACG";
        System.out.println("dna is : "+dna);
        System.out.println("gene is : "+findSimpleGene(dna,"ATG","TAA"));
        
        dna = "ATATGCCTAGGTA";
        System.out.println("dna is : "+dna);
        System.out.println("gene is : "+findSimpleGene(dna,"ATG","TAA"));
        
        dna = "CCATCCTAGGTATT";
        System.out.println("dna is : "+dna);
        System.out.println("gene is : "+findSimpleGene(dna,"ATG","TAA"));
        
        dna = "GCATGCCTAGGTAAT";
        System.out.println("dna is : "+dna);
        System.out.println("gene is : "+findSimpleGene(dna,"ATG","TAA"));
        
        dna = "GGATGCTAGGTAAT";
        System.out.println("dna is : "+dna);
        System.out.println("gene is : "+findSimpleGene(dna,"ATG","TAA"));        
    }
}
