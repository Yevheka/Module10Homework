import java.io.FileReader;

public class Main {
    public static void main(String[] args) {
        //TASK 1
        System.out.println("Task 1; Numbers:");
        PhoneNumbersPrinterUtils.printPhoneNumbers("file1.txt");

        //TASK 2
        JsonFileCreatorUtils.fileToJson("file2.txt", "file3.json");

        //TASK 3
        System.out.println("\nTask 3; Count of words:");
        WordsCounterUtils.printCountOfWords("file4.txt");
    }
}
