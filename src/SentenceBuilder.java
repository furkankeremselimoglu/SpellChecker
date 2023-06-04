import java.util.ArrayList;

public class SentenceBuilder {
    public static String buildSentence(ArrayList<String> words){
        StringBuilder sentence = new StringBuilder(String.join(" ",words));

        for(int i = 0; i < sentence.length(); i++){
            if(!String.valueOf(sentence.charAt(i)).isBlank() && !Character.isLetter(sentence.charAt(i)) && sentence.charAt(i) != '|'){
                sentence.deleteCharAt(i - 1);
            }
        }

        return sentence.toString();
    }
}
