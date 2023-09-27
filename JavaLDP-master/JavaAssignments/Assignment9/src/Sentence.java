import java.util.regex.Pattern;

public class Sentence {
    private String input;
    Sentence(String input){
        this.input = input;
    }
    public boolean checkSentence(){
        return Pattern.matches("^[A-Z].*[.]$",input);
    }
}
