
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {
    int findStopCodon(String dna, int startIndex, String stopCodon){
        int endIndex,searchFrom = startIndex+3;
        while(true){
            endIndex = dna.indexOf(stopCodon,searchFrom);
            if(endIndex==-1)
                return dna.length();
            if((endIndex - startIndex)%3 == 0)
                return endIndex;  
            else
                searchFrom = endIndex+1;
        }
    }
    
    String findGene(String dna, int startFrom){
        int startIndex = dna.indexOf("ATG",startFrom),stopIndex;
        int taaIndex, tagIndex, tgaIndex;
        while(startIndex!=-1){
            taaIndex = findStopCodon(dna,startIndex,"TAA");
            tagIndex = findStopCodon(dna,startIndex,"TAG");
            tgaIndex = findStopCodon(dna,startIndex,"TGA");
            stopIndex = Math.min(taaIndex,tagIndex);
            stopIndex = Math.min(stopIndex,tgaIndex);
            if(stopIndex != dna.length())
                return dna.substring(startIndex,stopIndex+3);            
            startIndex = dna.indexOf("ATG",startIndex+1);
        }
        return  "";
    }
    
    void printAllGenes(String dna){
        int startIndex = 0;
        while(true){
            String gene = findGene(dna,startIndex);
            if(gene.equals(""))
                break;
            System.out.println(gene);
            startIndex = dna.indexOf(gene,startIndex)+gene.length();
        }    
    }
    
    void testFindGene(){
        System.out.println("Expected : \"\" Actual : \""+findGene("ATTCCTGTAAGCTAA",0)+"\"\n");
        System.out.println("Expected : \"ATGCCTGTAAGCTAA\"  Actual : \""+findGene("ATGCCTGTAAGCTAA",0)+"\"\n");
        System.out.println("Expected : \"ATGCCTGTAAGCTGA\"  Actual : \""+findGene("ATGCCTGTAAGCTGATAATAG",0)+"\"\n");
        System.out.println("Expected : \"\"  Actual : \""+findGene("ATGCCTGTAAGCTAC",0)+"\"\n");
    }
    
    void testFindStopCodon(){
        //test 1          012345678901234
        if(findStopCodon("ATGCCTGTAAGCTAA",0,"TAA")!=12)
            System.out.println("test 1 failed");
        //test 2               012345678901234
        if(findStopCodon("ATGCCTGTAAGCTAC",0,"TAA")!=15)
            System.out.println("test 2 failed");
        //test 3               012345678901234
        if(findStopCodon("CTCATGGTAAGCTAA",3,"TAA")!=12)
            System.out.println("test 3 failed");  
        //test 4               012345678901234
        if(findStopCodon("CTCATGGTAAGCATG",12,"TAA")!=15)
            System.out.println("test 4 failed");  
        System.out.println("tests completed");      
    }
    
    void testPrintAllGenes(){
        printAllGenes("CTCATGGTAAGCTAAATGCCTGTAAGCTAAATGCCTGTAAGCTAC");
    }
}
