package entity;

import java.util.List;

/**
 * Lớp Experience đại diện cho nhân viên có kinh nghiệm lâu năm.
 *
 * Quan hệ OOP:
 * - Is-A relationship: Experience "là một" Employee (extends Employee).
 * - Inheritance: Kế thừa toàn bộ thuộc tính và phương thức của lớp cha
 * Employee.
 * - Polymorphism: Ghi đè (Override) phương thức trừu tượng showInfo().
 * - Từ khóa super: Dùng để gọi constructor của lớp cha và gọi super.showInfo().
 */
public class Experience extends Employee {
    private int expInYear; // Số năm kinh nghiệm
    private String proSkill; // Kỹ năng chuyên môn

    // 1. Constructor mặc định (không tham số)
    public Experience() {
        super();
        this.setEmployeeType(0); // 0: Experience
    }

    // 2. Constructor đầy đủ tham số
    public Experience(String id, String fullName, String birthDay, String phone, String email, int expInYear,
            String proSkill) {
        // Sử dụng từ khóa super để gọi constructor của lớp cha Employee
        super(id, fullName, birthDay, phone, email, 0);
        this.expInYear = expInYear;
        this.proSkill = proSkill;
    }

    // Constructor nạp chồng kèm danh sách bằng cấp
    public Experience(String id, String fullName, String birthDay, String phone, String email,
            int expInYear, String proSkill, List<Certificate> certificates) {
        super(id, fullName, birthDay, phone, email, 0, certificates);
        this.expInYear = expInYear;
        this.proSkill = proSkill;
    }

    // Getters and Setters
    public int getExpInYear() {
        return expInYear;
    }

    public void setExpInYear(int expInYear) {
        this.expInYear = expInYear;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }

    /**
     * Ghi đè (Override) phương thức showInfo() từ lớp cha Employee
     * Hiển thị đầy đủ thông tin chung và thuộc tính riêng của Experience.
     */
    @Override
    public void showInfo() {
        System.out.println("┌─────────────────────────── [EXPERIENCE EMPLOYEE] ───────────────────────────");
        System.out.printf("│ ID: %-15s | Họ tên: %-25s | Ngày sinh: %-12s\n", getId(), getFullName(), getBirthDay());
        System.out.printf("│ SĐT: %-14s | Email: %-26s | Loại: %-15s\n", getPhone(), getEmail(), getEmployeeTypeName());
        System.out.printf("│ Kinh nghiệm: %d năm    | Kỹ năng chuyên môn: %-35s\n", expInYear, proSkill);
        System.out.println("└─────────────────────────────────────────────────────────────────────────────");
    }
}
