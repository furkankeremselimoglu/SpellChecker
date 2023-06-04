import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the sentence that you want to be corrected : ");
        String s = input.nextLine();
        System.out.println();

        ArrayList<String> correctedWords = SpellCorrector.correctSpelling(s);
        String userInput = SentenceBuilder.buildSentence(MisspelledWordFinder.findMisspelledWords(s));
        if(correctedWords.equals(MisspelledWordFinder.findMisspelledWords(s))){
            System.out.println("All the words in the sentence are correctly spelled.");
        } else {
            System.out.println("Your input --> " + userInput);
            System.out.println("Corrected version --> " + SentenceBuilder.buildSentence(correctedWords));
        }



    }
}
