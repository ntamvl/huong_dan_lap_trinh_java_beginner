package entity;

import java.util.List;

/**
 * Lớp Fresher đại diện cho nhân viên mới tốt nghiệp ra trường.
 * 
 * Quan hệ OOP:
 * - Is-A relationship: Fresher "là một" Employee (extends Employee).
 * - Inheritance: Kế thừa toàn bộ thuộc tính và phương thức của lớp cha Employee.
 * - Polymorphism: Ghi đè (Override) phương thức trừu tượng showInfo().
 * - Từ khóa super: Dùng để gọi constructor của lớp cha.
 */
public class Fresher extends Employee {
    private String graduationDate;   // Thời gian tốt nghiệp
    private String graduationRank;   // Xếp loại tốt nghiệp (Xuất sắc, Giỏi, Khá, Trung bình)
    private String education;        // Trường tốt nghiệp

    // 1. Constructor mặc định (không tham số)
    public Fresher() {
        super();
        this.setEmployeeType(1); // 1: Fresher
    }

    // 2. Constructor đầy đủ tham số
    public Fresher(String id, String fullName, String birthDay, String phone, String email,
                   String graduationDate, String graduationRank, String education) {
        // Sử dụng từ khóa super để gọi constructor của lớp cha Employee
        super(id, fullName, birthDay, phone, email, 1);
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.education = education;
    }

    // Constructor nạp chồng kèm danh sách bằng cấp
    public Fresher(String id, String fullName, String birthDay, String phone, String email,
                   String graduationDate, String graduationRank, String education, List<Certificate> certificates) {
        super(id, fullName, birthDay, phone, email, 1, certificates);
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.education = education;
    }

    // Getters and Setters
    public String getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(String graduationDate) {
        this.graduationDate = graduationDate;
    }

    public String getGraduationRank() {
        return graduationRank;
    }

    public void setGraduationRank(String graduationRank) {
        this.graduationRank = graduationRank;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    /**
     * Ghi đè (Override) phương thức showInfo() từ lớp cha Employee
     * Hiển thị đầy đủ thông tin chung và thuộc tính riêng của Fresher.
     */
    @Override
    public void showInfo() {
        System.out.println("┌───────────────────────────── [FRESHER EMPLOYEE] ────────────────────────────");
        System.out.printf("│ ID: %-15s | Họ tên: %-25s | Ngày sinh: %-12s\n", getId(), getFullName(), getBirthDay());
        System.out.printf("│ SĐT: %-14s | Email: %-26s | Loại: %-15s\n", getPhone(), getEmail(), getEmployeeTypeName());
        System.out.printf("│ Tốt nghiệp: %-10s | Xếp loại: %-12s | Trường: %-23s\n", graduationDate, graduationRank, education);
        System.out.println("└─────────────────────────────────────────────────────────────────────────────");
    }
}
