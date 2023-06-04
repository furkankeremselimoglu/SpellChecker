import java.util.ArrayList;
import java.util.Arrays;

public class WordExtractor {
    public static ArrayList<String> extractWords(String s){
        ArrayList<String> wordsWithPunctuation = new ArrayList<>(Arrays.asList(s.split(" ")));
        ArrayList<String> wordsWithoutPunctuation = new ArrayList<>();

        for(String word : wordsWithPunctuation){
            if(!Character.isLetter(word.charAt(word.length() - 1))){
                wordsWithoutPunctuation.add(word.substring(0,word.length() - 1));
                wordsWithoutPunctuation.add(String.valueOf(word.charAt(word.length() - 1)));
            } else {
                wordsWithoutPunctuation.add(word);
            }
        }


        return wordsWithoutPunctuation;
    }
}
