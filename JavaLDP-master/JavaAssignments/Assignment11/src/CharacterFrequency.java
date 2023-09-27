import java.util.HashMap;
import java.util.Map;

public class CharacterFrequency {
    private String fileName;

    CharacterFrequency(String fileName){
        this.fileName = fileName;
    }

    private Map<Character,Integer> getCharacterFrequency(){
        Map<Character,Integer> charFrequency = new HashMap<>();
        for(char ch:fileName.toCharArray()){
            if(charFrequency.containsKey(ch)){
                int count = charFrequency.get(ch);
                charFrequency.put(ch,count+1);
            }
            else {
                charFrequency.put(ch,1);
            }
        }
        return charFrequency;
    }

    public void evaluateAndwriteToFile(){
        Map<Character,Integer> charFreq = getCharacterFrequency();
        FileOperations fileOperationsObject = new FileOperations(fileName);
        fileOperationsObject.writeDataToFile(charFreq);
    }
}
