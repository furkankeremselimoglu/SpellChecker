import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class SpellCorrector {
    public static ArrayList<String> correctSpelling(String sentence) throws IOException {
        ArrayList<String> words = MisspelledWordFinder.findMisspelledWords(sentence);
        ArrayList<String> englishWords = FileLineReader.readLine("web2.txt");
        ArrayList<String> correctedWords = WordExtractor.extractWords(sentence);

        Scanner input = new Scanner(System.in);

        for(String word : words){
            if(word.startsWith("|")){
                int indexOfMisspelledWord = words.indexOf(word);
                String misspelledWord = word.replace("|","");
                HashMap<Integer,String> possibleWordDictionary = PossibleWordsFinder.findPossibleWords(misspelledWord,englishWords);
                String upperCase = String.valueOf(misspelledWord.charAt(0)).toUpperCase();
                if(possibleWordDictionary.size() == 1){
                    if(misspelledWord.startsWith(upperCase)){
                        correctedWords.set(indexOfMisspelledWord, String.valueOf(possibleWordDictionary.get(1).charAt(0)).toUpperCase() +
                                possibleWordDictionary.get(1).substring(1));
                    }
                    else {
                        correctedWords.set(indexOfMisspelledWord, possibleWordDictionary.get(1));
                    }
                } else if (possibleWordDictionary.size() == 0){
                    System.out.println("Could not fine any possible corrections for word " + word);
                    System.out.println();
                } else {
                    System.out.println("Possible correct words for misspelled word " + word + " :");
                    System.out.println(possibleWordDictionary);
                    System.out.print("Choose a correct word for misspelled word " + word + " from dictionary --> ");
                    int index = input.nextInt();
                    System.out.println();
                    if(misspelledWord.startsWith(upperCase)){
                        correctedWords.set(indexOfMisspelledWord, String.valueOf(possibleWordDictionary.get(index).charAt(0)).toUpperCase() +
                                possibleWordDictionary.get(index).substring(1));
                    }
                    else {
                        correctedWords.set(indexOfMisspelledWord, possibleWordDictionary.get(index));
                    }
                }
            }
        }
        return correctedWords;
    }
}