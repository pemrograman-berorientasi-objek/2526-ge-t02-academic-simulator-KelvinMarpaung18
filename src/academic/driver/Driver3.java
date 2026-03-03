package academic.driver;

/**
 * @author 12S24018 KELVIN YOHANES PUTRA
 
 */
import academic.model.Enrollment;
import java.util.Scanner;

public class Driver3 {
    private static Enrollment[] enrollments = new Enrollment[100]; 
    private static int enrollmentCount = 0; 

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line;

        while (true) {
            line = scanner.nextLine(); 

            if (line.equals("---")) {
                break; 
            }

            if (enrollmentCount >= enrollments.length) {
                System.err.println("Peringatan: Kapasitas penyimpanan Enrollment penuh. Tidak dapat menambahkan enrollment lagi.");
                break; 
            }

            String[] parts = line.split("#");
            if (parts.length == 4) { 
                String courseCode = parts[0];
                String studentId = parts[1];
                String academicYear = parts[2]; 
                String semester = parts[3];

                Enrollment enrollment = new Enrollment(courseCode, studentId, academicYear, semester);
                enrollments[enrollmentCount] = enrollment;
                enrollmentCount++;
            } else {
                System.err.println("Format masukan tidak valid: " + line + ". Melewati baris ini.");
            }
        }

        for (int i = 0; i < enrollmentCount; i++) {
            System.out.println(enrollments[i].toString());
        }

        scanner.close(); 
    }
}
