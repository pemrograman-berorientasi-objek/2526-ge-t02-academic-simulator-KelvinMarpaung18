package academic.driver;

/**
 * @author 12S24018 KELVIN YOHANES PUTRA
 
 */
import academic.model.Course;
import academic.model.Student;
import academic.model.Enrollment;
import java.util.Scanner;
import java.util.ArrayList; // Menggunakan ArrayList agar lebih dinamis

public class Driver4 {
    // Menggunakan ArrayList untuk penyimpanan yang lebih fleksibel
    private static ArrayList<Course> courses = new ArrayList<>();
    private static ArrayList<Student> students = new ArrayList<>();
    private static ArrayList<Enrollment> enrollments = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line;

        while (true) {
            line = scanner.nextLine(); 

            if (line.equals("---")) {
                break; 
            }

            String[] parts = line.split("#");
            if (parts.length > 0) {
                String command = parts[0];

                switch (command) {
                    case "course-add":
                        if (parts.length == 5) {
                            try {
                                String code = parts[1];
                                String name = parts[2];
                                int credits = Integer.parseInt(parts[3]);
                                String grade = parts[4]; // Grade di sini adalah default untuk Course
                                courses.add(new Course(code, name, credits, grade));
                            } catch (NumberFormatException e) {
                                System.err.println("Error: Format kredit tidak valid pada baris course-add: " + line);
                            }
                        } else {
                            System.err.println("Format masukan course-add tidak valid: " + line);
                        }
                        break;
                    case "student-add":
                        if (parts.length == 5) {
                            String id = parts[1];
                            String name = parts[2];
                            String entryYear = parts[3];
                            String major = parts[4];
                            students.add(new Student(id, name, entryYear, major));
                        } else {
                            System.err.println("Format masukan student-add tidak valid: " + line);
                        }
                        break;
                    case "enrollment-add":
                        if (parts.length == 5) {
                            String courseCode = parts[1];
                            String studentId = parts[2];
                            String academicYear = parts[3];
                            String semester = parts[4];
                            enrollments.add(new Enrollment(courseCode, studentId, academicYear, semester));
                        } else {
                            System.err.println("Format masukan enrollment-add tidak valid: " + line);
                        }
                        break;
                    default:
                        System.err.println("Perintah tidak dikenal: " + command + " pada baris: " + line);
                        break;
                }
            }
        }

        // Cetak semua Course
        for (Course course : courses) {
            System.out.println(course.toString());
        }

        // Cetak semua Student
        for (Student student : students) {
            System.out.println(student.toString());
        }

        // Cetak semua Enrollment
        for (Enrollment enrollment : enrollments) {
            System.out.println(enrollment.toString());
        }

        scanner.close(); 
    }
}
