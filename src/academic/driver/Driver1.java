package academic.driver;

/**
 * @author 12S24018 KELVIN YOHANES PUTRA
 
 */

 import academic.model.Course;
import java.util.Scanner;

public class Driver1 {
    // Menggunakan array untuk menyimpan objek Course.
    // Kapasitas awal diatur ke 100, Anda bisa menyesuaikannya.
    private static Course[] courses = new Course[100]; 
    private static int courseCount = 0; // Untuk melacak jumlah Course yang tersimpan

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line;

        // Loop untuk membaca masukan interaktif hingga perintah berhenti diterima
        while (true) {
            line = scanner.nextLine(); // Membaca satu baris masukan dari pengguna

            if (line.equals("---")) {
                break; // Hentikan loop jika masukan adalah "---"
            }

            // Memeriksa apakah array sudah penuh sebelum menambahkan course baru
            if (courseCount >= courses.length) {
                System.err.println("Peringatan: Kapasitas penyimpanan Course penuh. Tidak dapat menambahkan course lagi.");
                break; // Keluar dari loop jika array penuh
            }

            // Memisahkan masukan berdasarkan delimiter '#'
            String[] parts = line.split("#");
            if (parts.length == 4) { // Memastikan format masukan benar (4 segmen)
                try {
                    String code = parts[0];
                    String name = parts[1];
                    int credits = Integer.parseInt(parts[2]); // Mengkonversi string ke integer
                    String grade = parts[3];

                    // Membuat objek Course baru dan menyimpannya ke dalam array
                    Course course = new Course(code, name, credits, grade);
                    courses[courseCount] = course;
                    courseCount++;
                } catch (NumberFormatException e) {
                    System.err.println("Error: Format kredit tidak valid pada baris: " + line + ". Melewati baris ini.");
                }
            } else {
                System.err.println("Format masukan tidak valid: " + line + ". Melewati baris ini.");
            }
        }

        // Setelah loop berhenti, tampilkan semua Course yang tersimpan
        for (int i = 0; i < courseCount; i++) {
            System.out.println(courses[i].toString());
        }

        scanner.close(); // Menutup objek scanner
    }
}

