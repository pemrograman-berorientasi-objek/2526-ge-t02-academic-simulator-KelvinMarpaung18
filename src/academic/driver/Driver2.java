package academic.driver;

/**
 * @author 12S24018 KELVIN YOHANES PUTRA
 
 */

import academic.model.Student;
import java.util.Scanner;

public class Driver2 {
    private static Student[] students = new Student[100]; 
    private static int studentCount = 0; 

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line;

        while (true) {
            line = scanner.nextLine(); 

            if (line.equals("---")) {
                break; 
            }

            if (studentCount >= students.length) {
                System.err.println("Peringatan: Kapasitas penyimpanan Student penuh. Tidak dapat menambahkan student lagi.");
                break; 
            }

            String[] parts = line.split("#");
            if (parts.length == 4) { 
                String id = parts[0];
                String name = parts[1];
                String entryYear = parts[2]; 
                String major = parts[3];

                // Baris ini yang menjadi fokus perbaikan:
                // Memastikan kelas Student memiliki konstruktor yang menerima 4 String.
                Student student = new Student (id, name, entryYear, major);
                students[studentCount] = student;
                studentCount++;
            } else {
                System.err.println("Format masukan tidak valid: " + line + ". Melewati baris ini.");
            }
        }

        for (int i = 0; i < studentCount; i++) {
            System.out.println(students[i].toString());
        }

        scanner.close(); 
    }
}
