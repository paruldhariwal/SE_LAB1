import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Program {
    String branch;
    String programName;

    public Program(String branch, String programName) {
        this.branch = branch;
        this.programName = programName;
    }
}

class Student {
    String name;
    Program program;
    int admissionYear;
    int branchId;

    public Student(String name, Program program, int admissionYear, int branchId) {
        this.name = name;
        this.program = program;
        this.admissionYear = admissionYear;
        this.branchId = branchId;
    }

    public String generateEnrollmentNumber() {
        return admissionYear + "-" + program.branch + "-" + String.format("%04d", branchId);
    }
}

public class StudentEnrollmentSystem {
    private Map<String, Program> programs = new HashMap<>();
    private Map<String, Integer> enrollmentCount = new HashMap<>();

    public void addProgram(String branch, String programName) {
        programs.put(branch, new Program(branch, programName));
        enrollmentCount.put(branch, 1);
    }

    public void enrollStudent(String name, String branch, int admissionYear) {
        Program program = programs.get(branch);
        if (program != null) {
            int branchCount = enrollmentCount.get(branch);
            Student student = new Student(name, program, admissionYear, branchCount);
            enrollmentCount.put(branch, branchCount + 1);

            System.out.println("Student enrolled with Enrollment Number: " + student.generateEnrollmentNumber());
        } else {
            System.out.println("Invalid branch. Student enrollment failed.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StudentEnrollmentSystem enrollmentSystem = new StudentEnrollmentSystem();
        enrollmentSystem.addProgram("CS", "Btech");
        enrollmentSystem.addProgram("IT", "Btech");
        enrollmentSystem.addProgram("AIML", "Btech");

        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter student " + (i + 1) + "'s name: ");
            String name = scanner.nextLine();

            String branch;
            String programName;
            while (true) {
                System.out.print("Enter student " + (i + 1) + "'s branch : ");
                branch = scanner.nextLine().toUpperCase();
                if (enrollmentSystem.programs.containsKey(branch)) {
                    break;
                } else {
                    System.out.println("Enter Branch(Since it is a new Branch)");
                    branch=scanner.nextLine();
                    System.out.println("Enter programName");
                    programName=scanner.nextLine();
                    enrollmentSystem.addProgram(branch, programName);
                    
                }
            }

            System.out.print("Enter admission year for student " + (i + 1) + ": ");
            int year = scanner.nextInt();
            scanner.nextLine();

            enrollmentSystem.enrollStudent(name, branch, year);
        }
    }
}
