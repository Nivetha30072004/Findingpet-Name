import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class UserInterface {
    public String findPetName(String fileName) {
        try (FileReader inputFileReader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(inputFileReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (countVowels(line) == 2) {
                    return line;
                }
            }
            return "No pet name found with exactly two vowels";
        } catch (FileNotFoundException e) {
            return "Please give the correct file name";
        } catch (IOException e) {
            return "Error occurred while reading the names from file";
        }
    }

    private int countVowels(String name) {
        int count = 0;
        for (char c : name.toLowerCase().toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        String fileName = "pet_names.txt"; // Specify the correct file name here
        System.out.println(ui.findPetName(fileName));
    }
}