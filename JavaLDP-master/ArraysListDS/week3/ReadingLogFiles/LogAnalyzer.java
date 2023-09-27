
/**
 * Write a description of class LogAnalyzer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import edu.duke.*;

public class LogAnalyzer
{
     private ArrayList<LogEntry> records;
     
     public LogAnalyzer() {
         // complete constructor
         records = new ArrayList<>();
     }
        
     public void readFile(String filename) {
         // complete method
         FileResource fr = new FileResource(filename);
         for(String line: fr.lines()){
             records.add(WebLogParser.parseEntry(line));
         }
     }
        
     public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }
     }
     
     int countUniqueIPs(){
         ArrayList<String> uniqueIPs = new ArrayList<>();
         for (LogEntry le : records) {
             String ip = le.getIpAddress();
             if(!uniqueIPs.contains(ip))
                uniqueIPs.add(ip);
         }
         return uniqueIPs.size();
     }
     
     void printAllHigherThanNum(int num){
         for (LogEntry le : records) {
             int status = le.getStatusCode();
             if(status > num)
                System.out.println(le);
         }
     }
     
     ArrayList<String> uniqueIPVisitsOnDay(String someday){
         ArrayList<String> uniqueIPVisits = new ArrayList<>();
         for (LogEntry le : records) {
             String ip = le.getIpAddress();
             if(!uniqueIPVisits.contains(ip) && le.toString().indexOf(someday)!=-1){
                 uniqueIPVisits.add(ip);       
             }                
         }
         return uniqueIPVisits;
     }
     
     int countUniqueIPsInRange(int low,int high){
         ArrayList<String> uniqueIPs = new ArrayList<>();
         for (LogEntry le : records) {
            String ip = le.getIpAddress();
            int status = le.getStatusCode();
            if(!uniqueIPs.contains(ip) &&status >= low && status <= high){
                 uniqueIPs.add(ip);
            }
         }
         return uniqueIPs.size();
     }
     
     
     HashMap<String,Integer> countVisitsPerIP(){
         HashMap<String,Integer> counts = new HashMap<>();
         for(LogEntry le:records){
             String ip = le.getIpAddress();
             if(counts.containsKey(ip)){
                 int val = counts.get(ip);
                 counts.put(ip,val+1);
             }
             else{
                 counts.put(ip,1);
             }
         }
         return counts;
     }
     
     int mostNumberVisitsByIP(HashMap<String,Integer> counts){
        int maxi = 0;
        for(String ip:counts.keySet()){
            int val = counts.get(ip);
            if(maxi<val)
                maxi = val;        
        }
        return maxi;
     }
     
     ArrayList<String> iPsMostVisits(HashMap<String,Integer> counts){
         ArrayList<String> iPs = new ArrayList<>();
         int maxi = mostNumberVisitsByIP(counts);
         for(String ip:counts.keySet()){
             if(maxi==counts.get(ip))
                iPs.add(ip);
         }
         return iPs;
     }
     
     HashMap<String, ArrayList<String>> iPsForDays(){
        HashMap<String, ArrayList<String>> dayIPs = new HashMap<>();
        for(LogEntry le:records){
            String ip = le.getIpAddress();
            String date = le.getAccessTime().toString().substring(4,10);
            if(dayIPs.containsKey(date)){
                dayIPs.get(date).add(ip);
            }
            else{
                ArrayList<String> IPs = new ArrayList<String>();
                IPs.add(ip);
                dayIPs.put(date,IPs);
            }
        }
        return dayIPs;
     }
    
     String dayWithMostIPVisits(HashMap<String, ArrayList<String>> dayIPs){
         String maxDay="";
         int maxIPs=0;
         for(String day:dayIPs.keySet()){
            int count = dayIPs.get(day).size();
            if(maxIPs < count){
                maxIPs = count;
                maxDay = day;
            }                
         }
         return maxDay;
     }
     
     ArrayList<String> iPsWithMostVisitsOnDay(HashMap<String, ArrayList<String>> daysIPs,String day){
         ArrayList<String> iPs = daysIPs.get(day);
         int maxi = 0;        
         HashMap<String,Integer> counts = new HashMap<>();
         for(String ip:iPs){
             if(counts.containsKey(ip)){
                 int val = counts.get(ip)+1;
                 counts.put(ip,val);                     
                 if(maxi<val)
                     maxi = val;
             }
             else{
                 counts.put(ip,1);
             }
         }
         ArrayList<String> mostVisitsIP = new ArrayList<>();
         for(String ip:counts.keySet()){
             if(maxi==counts.get(ip))
                mostVisitsIP.add(ip);
         }
         return mostVisitsIP;
     }
}