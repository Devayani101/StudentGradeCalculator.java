import java.util.InputMismatchException;
import java.util.Scanner;
public class StudentGradeCalculator {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BOLD= "\u001B[1m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        int totalMarks = 0;
        int totalSubjects = 0;
        try {
            System.out.print(ANSI_BOLD + ANSI_CYAN + "enter the number of sujects:" + ANSI_RESET);
            totalSubjects = scanner.nextInt();

            System.out.print(ANSI_CYAN + "enter marks obtained in each subject(out of 100)" + ANSI_RESET);
            int[] SubjectMarks = new int[totalSubjects];

            for (int i = 0; i < totalSubjects; i++) {
                System.out.print(ANSI_BOLD + "enter marks for subject" + (i + 1) + ":" + ANSI_RESET);
                SubjectMarks[i] = scanner.nextInt();

                if (SubjectMarks[i]<0||SubjectMarks[i]>100){
                    System.out.println(ANSI_GREEN+"Invalid input Marks should be between 0 and 100"+ANSI_RESET);
                    return;
                }

                totalMarks += SubjectMarks[i];

            }
            double averagePercentage = (double) totalMarks/(totalSubjects + 100) *100;

            char grade;
            if (averagePercentage>=90){
                grade ='A';
            }else if (averagePercentage>=80){
                grade = 'B';
            }else if (averagePercentage>=70){
                grade = 'c';
            }else if (averagePercentage>=60){
                grade = 'D';
            }else {
                grade = 'F';
            }

            System.out.println("/n"+ ANSI_BOLD + "_____RESULT_____" + ANSI_RESET);
            System.out.println(ANSI_CYAN + "Total Marks:" + ANSI_RESET  + totalMarks);
            System.out.println( ANSI_CYAN + "averagePercentage:%.2f%%\n" +ANSI_RESET);
            System.out.println(ANSI_CYAN + "Grade" + ANSI_RESET + grade);
        } catch (InputMismatchException e) {
            System.out.println(ANSI_GREEN + "Invalid input please enter valid marks." + ANSI_RESET);
        }finally {
            scanner.close();
        }
    }
}
