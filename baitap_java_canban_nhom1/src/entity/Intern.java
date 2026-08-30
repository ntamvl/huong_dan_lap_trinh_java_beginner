package entity;

import java.util.List;

/**
 * Lớp Intern đại diện cho nhân viên thực tập sinh.
 * 
 * Quan hệ OOP:
 * - Is-A relationship: Intern "là một" Employee (extends Employee).
 * - Inheritance: Kế thừa toàn bộ thuộc tính và phương thức của lớp cha Employee.
 * - Polymorphism: Ghi đè (Override) phương thức trừu tượng showInfo().
 * - Từ khóa super: Dùng để gọi constructor của lớp cha.
 */
public class Intern extends Employee {
    private String majors;           // Chuyên ngành đang học
    private String semester;         // Học kì đang học
    private String universityName;   // Tên trường đang theo học

    // 1. Constructor mặc định (không tham số)
    public Intern() {
        super();
        this.setEmployeeType(2); // 2: Intern
    }

    // 2. Constructor đầy đủ tham số
    public Intern(String id, String fullName, String birthDay, String phone, String email,
                  String majors, String semester, String universityName) {
        // Sử dụng từ khóa super để gọi constructor của lớp cha Employee
        super(id, fullName, birthDay, phone, email, 2);
        this.majors = majors;
        this.semester = semester;
        this.universityName = universityName;
    }

    // Constructor nạp chồng kèm danh sách bằng cấp
    public Intern(String id, String fullName, String birthDay, String phone, String email,
                  String majors, String semester, String universityName, List<Certificate> certificates) {
        super(id, fullName, birthDay, phone, email, 2, certificates);
        this.majors = majors;
        this.semester = semester;
        this.universityName = universityName;
    }

    // Getters and Setters
    public String getMajors() {
        return majors;
    }

    public void setMajors(String majors) {
        this.majors = majors;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    /**
     * Ghi đè (Override) phương thức showInfo() từ lớp cha Employee
     * Hiển thị đầy đủ thông tin chung và thuộc tính riêng của Intern.
     */
    @Override
    public void showInfo() {
        System.out.println("┌───────────────────────────── [INTERN EMPLOYEE] ─────────────────────────────");
        System.out.printf("│ ID: %-15s | Họ tên: %-25s | Ngày sinh: %-12s\n", getId(), getFullName(), getBirthDay());
        System.out.printf("│ SĐT: %-14s | Email: %-26s | Loại: %-15s\n", getPhone(), getEmail(), getEmployeeTypeName());
        System.out.printf("│ Chuyên ngành: %-10s | Học kỳ: %-14s | Trường ĐH: %-21s\n", majors, semester, universityName);
        System.out.println("└─────────────────────────────────────────────────────────────────────────────");
    }
}
