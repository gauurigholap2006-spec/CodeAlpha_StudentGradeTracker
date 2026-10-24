import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // ArrayLists to store student names and grades
        ArrayList<String> studentNames = new ArrayList<>();
        ArrayList<Double> studentGrades = new ArrayList<>();

        System.out.println("==========================================");
        System.out.println("      STUDENT GRADE TRACKER SYSTEM        ");
        System.out.println("==========================================");

        // Asking for the number of students
        System.out.print("Enter total number of students: ");
        int totalStudents = scanner.nextInt();
        scanner.nextLine(); // Clear newline character

        // Input loop for student details
        for (int i = 0; i < totalStudents; i++) {
            System.out.println("\n--- Enter Details for Student " + (i + 1) + " ---");
            
            System.out.print("Student Name: ");
            String name = scanner.nextLine();
            
            double grade = -1;
            // Input Validation: Grade should be between 0 and 100
            while (grade < 0 || grade > 100) {
                System.out.print("Enter Marks/Grade (0 - 100): ");
                if (scanner.hasNextDouble()) {
                    grade = scanner.nextDouble();
                    if (grade < 0 || grade > 100) {
                        System.out.println("Invalid input! Please enter marks between 0 and 100.");
                    }
                } else {
                    System.out.println("Invalid input! Please enter a valid number.");
                    scanner.next(); // Clear invalid input
                }
            }
            scanner.nextLine(); // Clear newline character

            studentNames.add(name);
            studentGrades.add(grade);
        }

        // If no data is available
        if (studentGrades.isEmpty()) {
            System.out.println("\nNo student data provided.");
            return;
        }

        // Calculations for Average, Highest, and Lowest
        double sum = 0;
        double highest = studentGrades.get(0);
        double lowest = studentGrades.get(0);
        
        String topStudent = studentNames.get(0);
        String lowestStudent = studentNames.get(0);

        for (int i = 0; i < studentGrades.size(); i++) {
            double currentGrade = studentGrades.get(i);
            sum += currentGrade;

            // Find Highest Score
            if (currentGrade > highest) {
                highest = currentGrade;
                topStudent = studentNames.get(i);
            }

            // Find Lowest Score
            if (currentGrade < lowest) {
                lowest = currentGrade;
                lowestStudent = studentNames.get(i);
            }
        }

        double average = sum / studentGrades.size();

        // ------------------ SUMMARY REPORT ------------------
        System.out.println("\n==========================================");
        System.out.println("             SUMMARY REPORT               ");
        System.out.println("==========================================");
        System.out.printf("%-5s %-20s %-10s\n", "No.", "Student Name", "Grade");
        System.out.println("------------------------------------------");

        for (int i = 0; i < studentNames.size(); i++) {
            System.out.printf("%-5d %-20s %-10.2f\n", (i + 1), studentNames.get(i), studentGrades.get(i));
        }

        System.out.println("------------------------------------------");
        System.out.printf("Average Score : %.2f\n", average);
        System.out.printf("Highest Score : %.2f (%s)\n", highest, topStudent);
        System.out.printf("Lowest Score  : %.2f (%s)\n", lowest, lowestStudent);
        System.out.println("==========================================");

        scanner.close();
    }
}