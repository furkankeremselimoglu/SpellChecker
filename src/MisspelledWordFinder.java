import java.io.IOException;
import java.util.ArrayList;


public class MisspelledWordFinder {
    public static ArrayList<String> findMisspelledWords(String s) throws IOException {
        ArrayList<String> englishWords = FileLineReader.readLine("web2.txt");
        ArrayList<String> words = WordExtractor.extractWords(s);
        for(String word : words){
            if(Character.isLetter(word.charAt(word.length() - 1)) && !englishWords.contains(word.toLowerCase())){
                int indexOfMisspelledWord = words.indexOf(word);
                String misspelledWord = "|" + word + "|";
                words.set(indexOfMisspelledWord,misspelledWord);

            }
        }
        return words;
    }
}
