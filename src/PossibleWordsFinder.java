import java.util.ArrayList;
import java.util.HashMap;

public class PossibleWordsFinder {

    public static HashMap<Integer, String> findPossibleWords(String word, ArrayList<String> englishWords) {
        HashMap<Integer,String> dictionary = new HashMap<>();
        int index = 1;
        for(String englishWord : englishWords){
            if(EditDistance.calculateDistance(word.toLowerCase(),englishWord) == 1){
                dictionary.put(index,englishWord);
                index++;
            }
        }

        return dictionary;
    }
}
