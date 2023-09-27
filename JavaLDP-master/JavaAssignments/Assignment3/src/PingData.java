import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class PingData {
    String hostAddresss;
    List<Double> listOfTimes;
    PingData(String hostAddresss){
        this.hostAddresss = hostAddresss;
        listOfTimes = new LinkedList<>();
    }

    private void addTime(String line){
        int startIndexOfTime = line.indexOf("time=")+5;
        int endIndexOfTime = line.indexOf("ms");
        if(startIndexOfTime>4 && endIndexOfTime!=-1){
            String timeInString = line.substring(startIndexOfTime,endIndexOfTime);
            double time = Double.parseDouble(timeInString);
            listOfTimes.add(time);
        }
    }

    private void fetchPingTimes() {
        try {
            Process process = Runtime.getRuntime().exec("ping "+ hostAddresss);
            BufferedReader buffer = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = buffer.readLine();
            while (line != null) {
                addTime(line);
                line = buffer.readLine();
            }
        } catch (IOException e) {
            System.out.println("IOException occurred");
        }
    }

    public void displayTimeMedian(){
        fetchPingTimes();
        Median medianObject = new Median(listOfTimes);
        double medianTime =  medianObject.getMedian();
        System.out.println("Median Time is "+medianTime+"ms");
    }
}

