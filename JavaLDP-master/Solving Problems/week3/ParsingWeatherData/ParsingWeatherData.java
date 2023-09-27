
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

/**
 * Write a description of ParsingWeatherData here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ParsingWeatherData {
    CSVRecord coldestHourInFile(CSVParser parser){
        CSVRecord coldestRecord=null;
        for(CSVRecord record:parser){
            if(record.get("TemperatureF").equals("-9999"))
                continue;
            if(coldestRecord==null)
                 coldestRecord = record;
            else{
                double currentTemp = Double.parseDouble(record.get("TemperatureF"));
                double coldestTemp = Double.parseDouble(coldestRecord.get("TemperatureF"));
                if(currentTemp<coldestTemp){
                    coldestRecord = record;
                }
            }
        }       
        return coldestRecord;
    }
    
    String fileWithColdestTemperature(){
        DirectoryResource dir = new DirectoryResource();
        File coldestFile = null;
        Double coldestTemp=99.0,currentColdest;
        CSVRecord coldestRecord,currentRecord;
        for(File f : dir.selectedFiles()){
            FileResource fr = new FileResource(f);
            if(coldestFile ==null){
                coldestFile = f;
                coldestRecord = coldestHourInFile(fr.getCSVParser());
                coldestTemp = Double.parseDouble(coldestRecord.get("TemperatureF"));
            }
            else{
                currentRecord = coldestHourInFile(fr.getCSVParser());
                currentColdest = Double.parseDouble(currentRecord.get("TemperatureF"));
                if(coldestTemp > currentColdest){
                    coldestTemp = currentColdest;
                    coldestFile = f;
                }                    
            }
        }
        System.out.println("Coldest day was in file "+coldestFile.getName());
        System.out.println("Coldest temperature on that day was "+coldestTemp);
        System.out.println("All the Temperatures on the coldest day were:");
        FileResource fr = new FileResource(coldestFile);
        for(CSVRecord record: fr.getCSVParser()){
            String out = record.get("DateUTC")+": "+record.get("TemperatureF");
            System.out.println(out);
        }        
        return coldestFile.getName();
    }
    
    CSVRecord lowestHumidityInFile(CSVParser parser){
        CSVRecord lowestHumidityRecord=null;
        for(CSVRecord record:parser){
            lowestHumidityRecord = getLowestHumidityOfTwo(record,lowestHumidityRecord);
        }       
        return lowestHumidityRecord;
    }
    
    CSVRecord lowestHumidityInManyFiles () {
	CSVRecord lowestSoFar = null;
	DirectoryResource dr = new DirectoryResource();
	for (File f : dr.selectedFiles()) {
		FileResource fr = new FileResource(f);
		CSVRecord currentRow = lowestHumidityInFile(fr.getCSVParser());
		lowestSoFar = getLowestHumidityOfTwo(currentRow, lowestSoFar);
	}
	return lowestSoFar;
    }
   
    CSVRecord getLowestHumidityOfTwo(CSVRecord record,CSVRecord lowestHumidityRecord){
        if(record.get("Humidity").equals("N/A"))
                return lowestHumidityRecord;
        if(lowestHumidityRecord==null)
             lowestHumidityRecord = record;
        else{
            int currentHumid = Integer.parseInt(record.get("Humidity"));
            int lowestHumid = Integer.parseInt(lowestHumidityRecord.get("Humidity"));
            if(currentHumid<lowestHumid){
                lowestHumidityRecord = record;
            }
        }
        return lowestHumidityRecord;
    }
    
    double averageTemperatureInFile(CSVParser parser){
        double sumTemp = 0,currentTemp;
        int count = 0;
        for(CSVRecord record:parser){            
            currentTemp = Double.parseDouble(record.get("TemperatureF"));
            sumTemp += currentTemp;
            count++;
        }
        return sumTemp/count;
    }
    
    double averageTemperatureWithHighHumidityInFile(CSVParser parser, int value){
        double sumTemp = 0,currentTemp;
        int count = 0,currentHumidity;;
        for(CSVRecord record:parser){            
            currentHumidity = Integer.parseInt(record.get("Humidity"));
            if(currentHumidity>=value){            
                currentTemp = Double.parseDouble(record.get("TemperatureF"));
                sumTemp += currentTemp;
                count++;
            }
        }
        if(count == 0)
            return -1;            
        return sumTemp/count;
    }
    
    void testColdestHourInFile(){
        FileResource fr = new FileResource();
        CSVRecord coldest = coldestHourInFile(fr.getCSVParser());
        System.out.println("coldest temperature was " + coldest.get("TemperatureF") +
				   " at " + coldest.get("DateUTC"));
    }
        
    void testFileWithColdestTemperature(){
        System.out.println(fileWithColdestTemperature());
    }
    
    void testLowestHumidityInFile(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord csv = lowestHumidityInFile(parser);
        System.out.println("Lowest Humidity was "+csv.get("Humidity")+
        " at "+csv.get("DateUTC"));
    }
    
    void testLowestHumidityInManyFiles(){
        CSVRecord csv = lowestHumidityInManyFiles();
        System.out.println("Lowest Humidity was "+csv.get("Humidity")+
        " at "+csv.get("DateUTC"));
    }
    
    void testAverageTemperatureInFile(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        System.out.println("Average temperature in file is "+
        averageTemperatureInFile(parser));
    }
    
    void testAverageTemperatureWithHighHumidityInFile(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        double value = averageTemperatureWithHighHumidityInFile(parser,80);
        if(value==-1)
            System.out.println("No temperatures with that humidity");
        else
            System.out.println("Average temperature when high Humidity is "+
            value);
    }
}
