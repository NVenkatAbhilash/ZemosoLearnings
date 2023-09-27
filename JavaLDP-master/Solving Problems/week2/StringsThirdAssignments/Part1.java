import edu.duke.*;
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
        String dnaUpperCase = dna.toUpperCase();
        int startIndex = dnaUpperCase.indexOf("ATG",startFrom),stopIndex;
        int taaIndex, tagIndex, tgaIndex;
        while(startIndex!=-1){
            taaIndex = findStopCodon(dnaUpperCase,startIndex,"TAA");
            tagIndex = findStopCodon(dnaUpperCase,startIndex,"TAG");
            tgaIndex = findStopCodon(dnaUpperCase,startIndex,"TGA");
            stopIndex = Math.min(taaIndex,tagIndex);
            stopIndex = Math.min(stopIndex,tgaIndex);
            if(stopIndex != dna.length())
                return dna.substring(startIndex,stopIndex+3);            
            startIndex = dnaUpperCase.indexOf("ATG",startIndex+1);
        }
        return  "";
    }
    
    StorageResource getAllGenes(String dna){
        int startIndex = 0;
        StorageResource storage = new StorageResource();
        while(true){
            String gene = findGene(dna,startIndex);
            if(gene.equals(""))
                break;
            storage.add(gene);
            startIndex = dna.indexOf(gene,startIndex)+gene.length();
        }    
        return storage;
    }
    
    float cgRatio(String dna){
        if(dna.length()==0)
            return 0;
        int count = 0;
        for(char ch:dna.toCharArray()){
            if(ch=='C' || ch=='G' || ch=='c' || ch=='g')
                count++;
        }
        return (float)count/dna.length();
    }
    
    int countCTG(String stringb){
        int searchFrom=0,count=0;
        String stringa = "CTG";
        while(true){
            searchFrom = stringb.indexOf(stringa,searchFrom);
            if(searchFrom == -1)
                break;
            count+=1;
            searchFrom += stringa.length();
        }
        return count;
    }
    
    void processGenes(StorageResource sr){
        StorageResource longerStrings = new StorageResource();
        StorageResource higherCgRatio = new StorageResource();
        int longestStringLength = 0;
        for(String str:sr.data()){
            if(str.length()>60)
                longerStrings.add(str);
            if(cgRatio(str)>0.35)
                higherCgRatio.add(str);
            longestStringLength = Math.max(longestStringLength,str.length());
        }
        System.out.println("Strings longer than 60 characters are");
        for(String str:longerStrings.data())
            System.out.println(str);
        System.out.println("\nnumber of Strings longer than 60 characters : "
        +longerStrings.size());
        System.out.println("\nStrings whose C-G-ratio is higher than 0.35 are");
        for(String str:higherCgRatio.data())
            System.out.println(str);
        System.out.println("\nnumber of Strings  whose C-G-ratio is higher than 0.35 : "
        +higherCgRatio.size());
        System.out.println("\nLength of the longest gene is :"+longestStringLength+"\n");
    }

    void testProcessGenes(){
        //test1
        System.out.println("------TEST 1------");
        StorageResource test1 = getAllGenes("AGTCAGTCAGTC");
        processGenes(test1);
        //test2
        System.out.println("------TEST 2------");
        StorageResource test2 = getAllGenes("AGTTC");
        processGenes(test2);
        //test3
        System.out.println("------TEST 3------");
        StorageResource test3 = getAllGenes("ATGCCATAG");
        processGenes(test3);
        //test4
        System.out.println("------TEST 4------");
        StorageResource test4 = getAllGenes("ATGTAATC");
        processGenes(test4);
        //test5
        System.out.println("------TEST 5------");
        StorageResource test5 = getAllGenes("CTCATGGTAAGCTAAATGCCTGTAAGCTAAATGCCTGTAAGCTAC");
        processGenes(test5);    
        //real dna test
        System.out.println("------REAL DNA TEST------");
        FileResource fr = new FileResource("brca1line.fa");
        String dna = fr.asString();
        StorageResource test = getAllGenes(dna);
        //System.out.println("Total genes : "+test.size());
        processGenes(test);
    }
    
    void testCgRatio(){
        System.out.println(cgRatio("ATGCCATAG"));
        System.out.println(cgRatio(""));
        System.out.println(cgRatio("CCGG"));
    }
    
    void testCountCTG(){
        System.out.println(countCTG("CTGCTGCTG"));
        System.out.println(countCTG("CCC"));
    }
    
    void testGetAllGenes (){
        StorageResource storage = getAllGenes("CTCATGGTAAGCTAAATGCCTGTAAGCTAAATGCCTGTAAGCTAC");
        for(String gene:storage.data())
            System.out.println(gene);
    }   
    
}
