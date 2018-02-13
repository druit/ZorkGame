package zork;

import java.io.BufferedReader;
import java.util.StringTokenizer;

public class InputParser {
    
 static public  String FirstWord="";
 static public  String SecondWord="";

    public InputParser() {
    }

    public String getFirstWord() {
        return FirstWord;
    }

    public void setFirstWord(String FirstWord) {
        InputParser.FirstWord = FirstWord;
    }

    public String getSecondWord() {
        return SecondWord;
    }

    public void setSecondWord(String SecondWord) {
        InputParser.SecondWord = SecondWord;
    }
    
    public void SplitInput(String input){
       StringTokenizer tokenizerWords = new StringTokenizer(input);
       if(!input.isEmpty() && !input.endsWith(" "))
       this.setFirstWord(tokenizerWords.nextToken());
       if(!input.endsWith(FirstWord) && !input.endsWith(" ") && !input.isEmpty())
       this.setSecondWord(tokenizerWords.nextToken());
    }
  }
