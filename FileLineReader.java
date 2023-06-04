import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileLineReader {
    public static ArrayList<String> readLine(String filePath) throws IOException {
        ArrayList<String> array = new ArrayList<>();

        try(FileReader fileReader = new FileReader(filePath)) {
            BufferedReader reader = new BufferedReader(fileReader);
            String line;

            while((line = reader.readLine()) != null){
                array.add(line);
            }
        }
        return array;
    }
}