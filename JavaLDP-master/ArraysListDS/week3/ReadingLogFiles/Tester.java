
/**
 * Write a description of class Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class Tester
{
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    
    public void testLogAnalyzer() {
        // complete method
        LogAnalyzer log = new LogAnalyzer();
        log.readFile("short-test-log");
        log.printAll();
    }
    
    void testUniqueIP(){
        LogAnalyzer log = new LogAnalyzer();
        log.readFile("short-test-log");
        System.out.println(log.countUniqueIPs());
    }
    
    void testPrintAllHigherThanNum(){
        LogAnalyzer log = new LogAnalyzer();
        log.readFile("short-test-log");
        //log.readFile("weblog1_log");
        log.printAllHigherThanNum(200);
    }
    
    void testUniqueIPVisitsOnDay(){
        LogAnalyzer log = new LogAnalyzer();
        //log.readFile("weblog1_log");
        //System.out.println(log.uniqueIPVisitsOnDay("Mar 17").size());
        log.readFile("weblog-short_log");
        //2
        System.out.println(log.uniqueIPVisitsOnDay("Sep 14").size());
        //3
        System.out.println(log.uniqueIPVisitsOnDay("Sep 30").size());        
    }
    
    void testCountUniqueIPsInRange (){
        LogAnalyzer log = new LogAnalyzer();
        //log.readFile("weblog1_log");
        log.readFile("short-test-log");
        //4
        System.out.println(log.countUniqueIPsInRange(200,299));
        //2
        System.out.println(log.countUniqueIPsInRange(300,399));
    }
    
    void testCountVisitsPerIP(){
        LogAnalyzer log = new LogAnalyzer();
        log.readFile("weblog1_log");
        HashMap<String,Integer> counts = log.countVisitsPerIP();
        System.out.println(counts);
        System.out.println("max visits count : "+log.mostNumberVisitsByIP(counts));
        System.out.println("max visits IPs : "+ log.iPsMostVisits(counts));
    }
    
    void testIPsForDays(){
        LogAnalyzer log = new LogAnalyzer();
        log.readFile("weblog1_log");
        HashMap<String, ArrayList<String>> dayIPs = log.iPsForDays();
        System.out.println(dayIPs);
        System.out.println("Day with most IPs : "+log.dayWithMostIPVisits(dayIPs));
        System.out.println("IPs with most visits on day : "+log.iPsWithMostVisitsOnDay(dayIPs,"Mar 17"));        

    }
}
