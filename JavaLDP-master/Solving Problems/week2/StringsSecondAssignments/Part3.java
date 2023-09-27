
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
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
    
    int countGenes(String dna){
        int startIndex = 0,count = 0;
        while(true){
            String gene = findGene(dna,startIndex);
            if(gene.equals(""))
                break;
            count+=1;
            startIndex = dna.indexOf(gene,startIndex)+gene.length();
        }    
        return count;
    }
    
    void testCountGenes(){
        //test 1
        if(countGenes("ATGCCTGTAAGCTAA")!=1)
            System.out.println("test 1 failed");
        //test 2
        if(countGenes("ATGCCTGTAAGCTA")!=0)
            System.out.println("test 2 failed");
        //test 3
        if(countGenes("ATGTAAATGCCCTAG")!=2)
            System.out.println("test 3 failed");
        System.out.println("tests completed");
    }
}
