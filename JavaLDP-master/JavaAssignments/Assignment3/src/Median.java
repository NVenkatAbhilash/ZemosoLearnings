import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Median {
    private List<Double> listOfValues;
    Median(List<Double> list){
        listOfValues = list;
        Collections.sort(listOfValues);
    }

    public double getMedian(){
        int size = listOfValues.size();
        double medianValue;
        if(size%2==0){
            medianValue = ((double) (listOfValues.get(size/2)+listOfValues.get(size/2-1)))/2;
        }
        else{
            medianValue = listOfValues.get(size/2);
        }
        return medianValue;
    }
}
