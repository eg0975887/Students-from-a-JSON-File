import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

class Main {
    // Method to print a students details
    public static void printDetails(int id,String name, int age, String grade) {
        System.out.println("Student ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Grade: " + grade);
        System.out.println();
    }

    public static void main(String[] args) {
        Gson gson = new Gson();

        // Define the Type for the list of Student objects
        Type studentListType = new TypeToken<List<Student>>(){}.getType();

        // Try reading the students.json file, send error message if failed
        try (FileReader reader = new FileReader("src/students.json")) {
            // Parse the JSON file into a list of Student objects
            // System.out.println("Reading students.json");
            List<Student> students = gson.fromJson(reader, studentListType);

            // Print out the details of each student in the list
            for (Student student : students) {
                printDetails(student.id, student.name, student.age, student.grade);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
