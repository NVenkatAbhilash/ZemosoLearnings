import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class FileOperations {
    File file;
    FileOperations(String fileName){
        file = new File(fileName);
    }

    public void writeDataToFile(Object charFreq){
        FileWriter writeFile;
        try {
            file.createNewFile();
            writeFile = new FileWriter(file);
            writeFile.write(charFreq.toString());
            writeFile.close();
        }
        catch (IOException e){
            System.out.println("IO Exception occurred");
        }
    }
}
