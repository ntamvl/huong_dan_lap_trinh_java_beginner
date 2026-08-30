package entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Lớp trừu tượng (Abstract Class) Employee đại diện cho một nhân viên trong công ty.
 * 
 * Áp dụng các tính chất OOP:
 * - Abstraction (Trừu tượng): Lớp trừu tượng định nghĩa khung sườn chung và phương thức trừu tượng showInfo().
 * - Encapsulation (Đóng gói): Các thuộc tính có phạm vi private/protected, truy cập qua Getters/Setters.
 * - Static field: employee_count dùng chung cho toàn bộ lớp để đếm số lượng nhân viên.
 * - Has-A relationship: Employee sở hữu danh sách các bằng cấp (List<Certificate>).
 */
public abstract class Employee {
    // Static field: Biến tĩnh dùng chung cho toàn bộ lớp Employee để đếm số lượng nhân viên được tạo ra
    public static int employee_count = 0;

    // Các thuộc tính cơ bản của một nhân viên (Tính đóng gói)
    private String id;
    private String fullName;
    private String birthDay;
    private String phone;
    private String email;
    private int employeeType; // 0: Experience, 1: Fresher, 2: Intern
    
    // Quan hệ Has-A: Một Employee "có" một danh sách các Certificate
    private List<Certificate> certificates;

    // 1. Constructor mặc định (không tham số)
    public Employee() {
        this.certificates = new ArrayList<>();
        employee_count++; // Tăng biến tĩnh đếm số lượng nhân viên
    }

    // 2. Constructor đầy đủ tham số
    public Employee(String id, String fullName, String birthDay, String phone, String email, int employeeType) {
        this.id = id;
        this.fullName = fullName;
        this.birthDay = birthDay;
        this.phone = phone;
        this.email = email;
        this.employeeType = employeeType;
        this.certificates = new ArrayList<>();
        employee_count++; // Tăng biến tĩnh đếm số lượng nhân viên
    }

    // Constructor nạp chồng (Overloading constructor) kèm theo danh sách bằng cấp
    public Employee(String id, String fullName, String birthDay, String phone, String email, int employeeType, List<Certificate> certificates) {
        this(id, fullName, birthDay, phone, email, employeeType); // Sử dụng từ khóa this để gọi constructor khác trong cùng class
        if (certificates != null) {
            this.certificates = certificates;
        }
    }

    // --- Abstract Method (Phương thức trừu tượng) ---
    // Các lớp con (Experience, Fresher, Intern) BẮT BUỘC phải override phương thức này
    public abstract void showInfo();

    /**
     * Phương thức showMe minh họa tính Đa hình (Polymorphism)
     * Gọi showInfo() cụ thể của từng lớp con tại Runtime.
     */
    public void showMe() {
        System.out.println("=== THÔNG TIN NHÂN VIÊN (ID: " + this.id + ") ===");
        this.showInfo();
        this.showCertificates();
    }

    // --- Phương thức nạp chồng (Method Overloading) cho việc thêm bằng cấp ---
    
    // Nạp chồng 1: Nhận trực tiếp đối tượng Certificate
    public void addCertificate(Certificate certificate) {
        if (certificate != null) {
            this.certificates.add(certificate);
        }
    }

    // Nạp chồng 2: Nhận các trường dữ liệu rời và tự tạo đối tượng Certificate
    public void addCertificate(String certId, String certName, String certRank, String certDate) {
        Certificate cert = new Certificate(certId, certName, certRank, certDate);
        this.certificates.add(cert);
    }

    /**
     * Hiển thị danh sách tất cả các bằng cấp của nhân viên
     */
    public void showCertificates() {
        if (certificates == null || certificates.isEmpty()) {
            System.out.println("   -> Chưa có bằng cấp nào được ghi nhận.");
        } else {
            System.out.println("   -> Danh sách bằng cấp (" + certificates.size() + " bằng):");
            for (Certificate cert : certificates) {
                cert.showInfo();
            }
        }
    }

    // --- Getters and Setters (Tính đóng gói) ---
    public static int getEmployee_count() {
        return employee_count;
    }

    public static void setEmployee_count(int employee_count) {
        Employee.employee_count = employee_count;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(int employeeType) {
        this.employeeType = employeeType;
    }

    public List<Certificate> getCertificates() {
        return certificates;
    }

    public void setCertificates(List<Certificate> certificates) {
        this.certificates = certificates;
    }

    /**
     * Lấy tên loại nhân viên dạng chuỗi hiển thị
     */
    public String getEmployeeTypeName() {
        switch (this.employeeType) {
            case 0:
                return "Experience (Có kinh nghiệm)";
            case 1:
                return "Fresher (Mới ra trường)";
            case 2:
                return "Intern (Thực tập sinh)";
            default:
                return "Không xác định";
        }
    }

    // Ghi đè phương thức toString() từ lớp Object (Method Overriding)
    @Override
    public String toString() {
        return String.format("ID: %-6s | Họ tên: %-20s | Ngày sinh: %-10s | SĐT: %-10s | Email: %-25s | Loại: %s",
                id, fullName, birthDay, phone, email, getEmployeeTypeName());
    }
}
