import java.io.*;

public class PhoneNumbersPrinterUtils {
    public static void printPhoneNumbers(String path) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))){

            StringBuilder number = new StringBuilder();
            String line = reader.readLine();

            while(line != null){
                if(checkCorrectNumber(line)) {
                    System.out.println(line);
                }
                line = reader.readLine();
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }





    public static boolean checkCorrectNumber(String number) {
        boolean isCorrectNumber = true;
        if (number.length() == 14) {
            if (number.charAt(0) != '(' || number.charAt(4) != ')' || number.charAt(5) != ' ' || number.charAt(9) != '-') {
                isCorrectNumber = false;
            } else {
                for (int i = 0; i < number.length(); i++) {
                    if (i == 0 || i == 4 || i == 5 || i == 9) {
                        continue;
                    }
                    if (!Character.isDigit(number.charAt(i))) {
                        isCorrectNumber = false;
                    }
                }
            }
        } else if (number.length() == 12) {
            if (number.charAt(3) != '-' || number.charAt(7) != '-') {
                isCorrectNumber = false;
            } else {
                for (int i = 0; i < number.length(); i++) {
                    if (i == 3 || i == 7) {
                        continue;
                    }
                    if (!Character.isDigit(number.charAt(i))) {
                        isCorrectNumber = false;
                    }
                }
            }
        } else {
            isCorrectNumber = false;
        }
        return isCorrectNumber;
    }
}
