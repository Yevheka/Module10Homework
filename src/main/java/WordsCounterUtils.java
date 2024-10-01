import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class WordsCounterUtils {
    public static void printCountOfWords(String path) {
        StringBuilder fileText = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line = reader.readLine()+"\n";
            while(line != null) {
                fileText.append(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        String[] words = fileText.toString().split("\\W++");
        HashMap<String, Integer> result = new HashMap<>();
        for(String word:words){
            result.put(word, wordCounter(word,words));
        }

        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(result.entrySet());
        sortedList.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

        // Виведення результату
        for (Map.Entry<String, Integer> entry : sortedList) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }



    }

    public static int wordCounter(String word, String[] words) {
        int count = 0;
        for(String element: words){
            if(word.equals(element)){
                count++;
            }
        }
        return count;
    }

}
