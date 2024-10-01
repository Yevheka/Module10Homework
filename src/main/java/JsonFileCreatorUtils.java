import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.*;
import java.util.ArrayList;

public class JsonFileCreatorUtils {
    public static void fileToJson(String from, String to) {
        ArrayList<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(from))){
            lines.add(reader.readLine());

            while(lines.getLast() != null){
                lines.add(reader.readLine());
            }
            lines.removeLast();
            lines.removeFirst();

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        Person[] person = new Person[lines.size()];
        for(int i = 0; i < lines.size(); i++){
            String line = lines.get(i);
            String[] temp = line.split(" ");

            person[i] = new Person(temp[0],Integer.parseInt(temp[1]));
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(person);
        try (FileWriter writer = new FileWriter(to)){
            writer.write(json);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

}
