/**
 * Print out total number of babies born, as well as for each gender, in a given CSV file of baby name data.
 * 
 * @author Duke Software Team 
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class BabyBirths {
    public void printNames () {
        FileResource fr = new FileResource();
        for (CSVRecord rec : fr.getCSVParser(false)) {
            int numBorn = Integer.parseInt(rec.get(2));
            if (numBorn <= 100) {
                System.out.println("Name " + rec.get(0) +
                           " Gender " + rec.get(1) +
                           " Num Born " + rec.get(2));
            }
        }
    }

    public void totalBirths (FileResource fr) {
        int totalBirths = 0;
        int totalBoys = 0;
        int totalGirls = 0;
        int totalBoyNames = 0;
        int totalGirlNames = 0;
        for (CSVRecord rec : fr.getCSVParser(false)) {
            int numBorn = Integer.parseInt(rec.get(2));
            totalBirths += numBorn;
            if (rec.get(1).equals("M")) {
                totalBoys += numBorn;
                totalBoyNames++;
            }
            else {
                totalGirls += numBorn;
                totalGirlNames++;
            }
        }
        System.out.println("total births = " + totalBirths);
        System.out.println("female girls = " + totalGirls);
        System.out.println("male boys = " + totalBoys);
        System.out.println("total boy names = " + totalBoyNames);
        System.out.println("total girl names = " + totalGirlNames);
    }
    
    int getRank(int year, String name, String gender){
        //for testing
        //String fileName = "data/yob"+year+"short.csv";
        int rank = 0;
        String fileName = "data/yob"+year+".csv";
        FileResource fr = new FileResource(fileName);
        for(CSVRecord record:fr.getCSVParser(false)){
            if(record.get(1).equals(gender)){
                rank++;
                if(record.get(0).equals(name))
                    return rank;
            }            
        }
        return -1;
    }
    
    String getName(int year, int rank, String gender){
        //for testing
        //String fileName = "data/yob"+year+"short.csv";
        int currentRank = 0;
        String fileName = "data/yob"+year+".csv";
        FileResource fr = new FileResource(fileName);
        for(CSVRecord record:fr.getCSVParser(false)){
            if(record.get(1).equals(gender)){
                currentRank++;
                if(currentRank == rank)
                    return record.get(0);
            }            
        }
        return "NO NAME";
    }
    
    void whatIsNameInYear(String name, int year, int newYear, String gender){
        int rank = getRank(year,name,gender);
        if(rank == -1){
            System.out.println("Sorry name not found");
            return;
        }
        String newName = getName(newYear,rank,gender);
        if(newName.equals("NO NAME")){
            System.out.println("Sorry name for the rank "+rank +" not found");
            return;
        }
        System.out.println(name+" born in "+year+" would be "+newName+
        " if she war born in "+newYear+".");
    }
    
    int yearOfHighestRank(String name, String gender){
        int highestRank = -1,currentRank;
        int year = -1,currentYear;
        DirectoryResource dir = new DirectoryResource();
        for(File f: dir.selectedFiles()){
            FileResource fr = new FileResource(f);
            currentYear = Integer.parseInt(f.getName().substring(3,7));
            currentRank = getRank(currentYear,name,gender);
            if(currentRank == -1)
                continue;
            if(currentRank<highestRank || highestRank==-1){
               year = currentYear;
               highestRank = currentRank;
            }
        }
        if(highestRank==-1)
            return -1;
        return year;
    }
    
    double getAverageRank(String name, String gender){
        double sumRank = 0;
        int countYear = 0;
        int currentRank, currentYear;
        DirectoryResource dir = new DirectoryResource();
        for(File f: dir.selectedFiles()){
            FileResource fr = new FileResource(f);
            currentYear = Integer.parseInt(f.getName().substring(3,7));
            currentRank = getRank(currentYear,name,gender);
            if(currentRank == -1)
                continue;
            sumRank += currentRank;
            countYear++;
        }
        if(countYear==0)
            return -1.0;
        return sumRank/countYear;
    }
    
    int getTotalBirthsRankedHigher(int year, String name,String gender){
        int totalBirths = 0;
        //for testing
        //String fileName = "data/yob"+year+"short.csv";
        String fileName = "data/yob"+year+".csv";
        FileResource fr = new FileResource(fileName);
        for(CSVRecord record:fr.getCSVParser(false)){
            if(gender.equals(record.get(1))){                    
                if(name.equals(record.get(0)))
                    return totalBirths;
                totalBirths += Integer.parseInt(record.get(2));
            }
        }
        return -1;
    }

    public void testTotalBirths () {
        //FileResource fr = new FileResource();
        FileResource fr = new FileResource("data/yob1905.csv");
        totalBirths(fr);
    }
    
    void testGetRank(){
        //NOTE : these test are for short data
        System.out.println("Expected : 2  Actual : "+getRank(2012,"Mason","M"));
        System.out.println("Expected : -1  Actual : "+getRank(2012,"Mason","F"));
    }
    
    void testGetName(){
        //NOTE : these test are for short data
        System.out.println("Expected : Manson  Actual : "+getName(2012,2,"M"));
        System.out.println("Expected : NO NAME  Actual : "+getName(2012,7,"F"));
    }
    
    void testWhatIsNameInYear(){
        System.out.print("Expected : Isabella born in 2012 would be Sophia if she was born in 2014.\nActual : ");
        whatIsNameInYear("Isabella",2012,2014,"F");
    }
    
    void testYearOfHighestRank(){
        System.out.println("if selected files are yob2012short.csv yob2013short.csv yob2014short.csv"+
        "\n Expected : 2012 \nActual : ");
        System.out.println(yearOfHighestRank("Mason","M"));
    }
    
    void testGetAverageRank(){
        System.out.println("if selected files are yob2012short.csv yob2013short.csv yob2014short.csv");
        System.out.print("Expected : 3.0 \nActual : ");
        System.out.println(getAverageRank("Mason","M"));
        System.out.print("Expected : 2.66 \nActual : ");
        System.out.println(getAverageRank("Jacob","M"));        
    }
    
    void testGetTotalBirthsRankedHigher(){
        System.out.println("Expected : 15");
        System.out.println("Actual : "+getTotalBirthsRankedHigher(2012,"Ethan","M"));
    }
}
