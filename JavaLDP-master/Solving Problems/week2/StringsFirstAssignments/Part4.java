import edu.duke.*;

/**
 * Write a description of Part4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part4 {
    void displayYoutubeLinks(){
        String link = "https://www.dukelearntoprogram.com//course2/data/manylinks.html";
        String lowerCaseWord,headString;
        int index,start,stop;
        URLResource urlData = new URLResource(link);
        for(String word:urlData.words()){
            lowerCaseWord = word.toLowerCase();
            index = lowerCaseWord.indexOf("youtube.com");
            if(index==-1)
                continue;
            headString = word.substring(0,index);
            start = headString.lastIndexOf("\"");
            stop = word.indexOf("\"",index+11);
            if(start!=-1 && stop!=-1){
                System.out.println(word.substring(start+1,stop));
            }
        }
    }
}
