package academic.model;

/**
 * @author 12S24018 KELVIN YOHANES PUTRA
 
 */
public class Course {
    private String code;
    private String name;
    private int credits;
    private String grade;

    public Course(String code, String name, int credits, String grade) {
        this.code = code;
        this.name = name;
        this.credits = credits;
        this.grade = grade;
    }

    // Anda bisa menambahkan getters jika diperlukan untuk keperluan lain,
    // namun untuk tugas ini, method toString() sudah cukup.
    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getCredits() {
        return credits;
    }

    public String getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return code + "|" + name + "|" + credits + "|" + grade;
    }
}
