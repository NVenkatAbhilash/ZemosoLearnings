import edu.duke.*;
import org.apache.commons.csv.*;

/**
 * Write a description of CSVAssignment1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CSVAssignment1 {    
    String countryInfo(CSVParser parser, String country){
        for(CSVRecord record : parser) {
            String recordCountry = record.get("Country");
            if(recordCountry.equalsIgnoreCase(country)){
                String info = recordCountry+": ";
                info += record.get("Exports");
                info += ": "+record.get("Value (dollars)");
                return info;
            }
        }
        return "NOT FOUND";
    }
    
    void listExportersTwoProducts(CSVParser parser, String exportItem1,
    String exportItem2){
        String country;
        String exportItems;
        for(CSVRecord record: parser){
            exportItems = record.get("Exports");
            if(exportItems.contains(exportItem1) && exportItems.contains(exportItem2)){
                country = record.get("Country");
                System.out.println(country);
            }
        }
    }
    
    int numberOfExporters(CSVParser parser, String exportItem){
        int count=0;
        String exportItems;
        for(CSVRecord record: parser){
            exportItems = record.get("Exports");
            if(exportItems.contains(exportItem)){
                count+=1;
            }
        }
        return  count;
    }
    
    void bigExporters(CSVParser parser, String amount){
        String exportAmount,country;
        for(CSVRecord record: parser){
            exportAmount = record.get("Value (dollars)");
            if(exportAmount.length()>amount.length()){
                country = record.get("Country");
                System.out.println(country+" "+exportAmount);
            }
        }
    }
    
    public void tester(){
        //FileResource fr = new FileResource("exports_small.csv");
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        System.out.println(countryInfo(parser,"germany"));
        System.out.println(countryInfo(parser,"Nauru"));
        System.out.println("-------------------");
        parser = fr.getCSVParser();
        listExportersTwoProducts(parser,"gold","diamonds");
        System.out.println("-------------------");
        parser = fr.getCSVParser();
        System.out.println(numberOfExporters(parser,"sugar"));
        System.out.println("-------------------");
        parser = fr.getCSVParser();
        bigExporters(parser,"$999,999,999,999");
    }  
}
