import java.util.*;

public class gradeCalculator {
  public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //take number of subjects
        System.out.print("Enter the number of subjects: ");
        int numSubjects = sc.nextInt();
        sc.nextLine();//clear buffer

        String subjects[] = new String[numSubjects];
        int marks[] = new int[numSubjects];
        int total = 0;

       //input subjects and marks
         for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter name of Subject " + (i + 1) + ": ");
            subjects[i] = sc.nextLine();
           
    
            System.out.println("Enter marks for Subject  " + subjects[i] + " (out of 100): ");
            marks[i] = sc.nextInt();
            sc.nextLine();
            total += marks[i];
        }
    
//calculate average
        float average = (float) total / numSubjects;

    //determine grade
        char grade;
        if (average >= 90) {
            grade = 'A';
        } else if (average >= 80) {
            grade = 'B';
        } else if (average >= 70) {
            grade = 'C';
        } else if (average >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        // Display result
        System.out.println("\n=== Result ===");
        System.out.println("Total Marks: " + total + " out of " + (numSubjects * 100));
        System.out.printf("Average Percentage: %.2f%%\n", average);
        System.out.println("Grade: " + grade);

        sc.close();
    }
}

