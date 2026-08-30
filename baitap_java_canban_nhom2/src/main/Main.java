package main;

import entity.Certificate;
import entity.Employee;
import entity.Experience;
import entity.Fresher;
import entity.Intern;
import exception.BirthDayException;
import exception.EmailException;
import exception.FullNameException;
import exception.PhoneException;
import service.EmployeeManager;
import util.Validator;

import java.util.List;
import java.util.Scanner;

/**
 * Lớp Main chứa hàm main chạy chương trình CLI tương tác với người dùng.
 */
public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final EmployeeManager manager = new EmployeeManager();

    public static void main(String[] args) {
        // Tải trước một vài dữ liệu mẫu để thuận tiện chạy thử
        initSampleData();

        while (true) {
            printMenu();
            System.out.print("👉 Lựa chọn của bạn: ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    addNewEmployee();
                    break;
                case "2":
                    editEmployee();
                    break;
                case "3":
                    deleteEmployee();
                    break;
                case "4":
                    manager.showAllEmployees();
                    break;
                case "5":
                    findEmployeeById();
                    break;
                case "6":
                    showInterns();
                    break;
                case "7":
                    showExperiences();
                    break;
                case "8":
                    showFreshers();
                    break;
                case "9":
                    showEmployeeCount();
                    break;
                case "10":
                    initSampleData();
                    System.out.println("✅ Đã nạp thêm dữ liệu mẫu vào danh sách!");
                    break;
                case "0":
                    System.out.println("\nCảm ơn bạn đã sử dụng Phần mềm Quản lý Nhân viên. Tạm biệt!");
                    return;
                default:
                    System.out.println("❌ Lựa chọn không hợp lệ. Vui lòng nhập từ 0 đến 10!");
            }

            System.out.println("\nNhấn phím [Enter] để tiếp tục...");
            scanner.nextLine();
        }
    }

    /**
     * In menu giao diện dòng lệnh
     */
    private static void printMenu() {
        System.out.println("\n╔══════════════════════════════════════════════════════════════╗");
        System.out.println("║         PHẦN MỀM QUẢN LÝ NHÂN VIÊN CÔNG TY (OOP CLI)         ║");
        System.out.println("╠══════════════════════════════════════════════════════════════╣");
        System.out.println("║ 1. Thêm nhân viên mới (Experience / Fresher / Intern)        ║");
        System.out.println("║ 2. Chỉnh sửa thông tin nhân viên theo ID                     ║");
        System.out.println("║ 3. Xóa nhân viên theo ID                                     ║");
        System.out.println("║ 4. Hiển thị danh sách tất cả nhân viên                       ║");
        System.out.println("║ 5. Tìm kiếm nhân viên theo ID                                ║");
        System.out.println("║ 6. Tìm và hiển thị tất cả nhân viên Intern (Yêu cầu 9)       ║");
        System.out.println("║ 7. Tìm và hiển thị tất cả nhân viên Experience (Yêu cầu 10)  ║");
        System.out.println("║ 8. Tìm và hiển thị tất cả nhân viên Fresher (Yêu cầu 11)     ║");
        System.out.println("║ 9. Xem tổng số nhân viên đã khởi tạo (Static Employee Count) ║");
        System.out.println("║ 10. Nạp thêm dữ liệu mẫu (Sample Data)                       ║");
        System.out.println("║ 0. Thoát chương trình                                        ║");
        System.out.println("╚══════════════════════════════════════════════════════════════╝");
    }

    /**
     * Thêm mới nhân viên: Áp dụng kiểm tra ngoại lệ BirthDayException, EmailException,
     * PhoneException, FullNameException (Yêu cầu 8, 12).
     */
    private static void addNewEmployee() {
        System.out.println("\n--- THÊM MỚI NHÂN VIÊN ---");
        System.out.println("Chọn loại nhân viên:");
        System.out.println("  0: Experience (Nhân viên có kinh nghiệm)");
        System.out.println("  1: Fresher (Nhân viên mới ra trường)");
        System.out.println("  2: Intern (Nhân viên thực tập)");
        System.out.print("👉 Chọn (0/1/2): ");
        String typeStr = scanner.nextLine().trim();

        if (!typeStr.equals("0") && !typeStr.equals("1") && !typeStr.equals("2")) {
            System.out.println("❌ Loại nhân viên không hợp lệ!");
            return;
        }
        int employeeType = Integer.parseInt(typeStr);

        // 1. Nhập ID và kiểm tra trùng lặp
        String id;
        while (true) {
            System.out.print("Nhập Mã nhân viên (ID): ");
            id = scanner.nextLine().trim();
            if (id.isEmpty()) {
                System.out.println("⚠️ ID không được để trống! Vui lòng nhập lại.");
                continue;
            }
            if (manager.findById(id) != null) {
                System.out.println("⚠️ ID '" + id + "' đã tồn tại! Vui lòng chọn ID khác.");
                continue;
            }
            break;
        }

        // 2. Nhập Họ và tên (Validate FullNameException)
        String fullName;
        while (true) {
            try {
                System.out.print("Nhập Họ và tên: ");
                fullName = scanner.nextLine().trim();
                fullName = Validator.validateFullName(fullName);
                break;
            } catch (FullNameException e) {
                System.out.println("❌ " + e.getMessage() + " Vui lòng nhập lại.");
            }
        }

        // 3. Nhập Ngày sinh (Validate BirthDayException)
        String birthday;
        while (true) {
            try {
                System.out.print("Nhập Ngày sinh (định dạng dd/MM/yyyy, ví dụ: 25/08/1998): ");
                birthday = scanner.nextLine().trim();
                birthday = Validator.validateBirthday(birthday);
                break;
            } catch (BirthDayException e) {
                System.out.println("❌ " + e.getMessage() + " Vui lòng nhập lại.");
            }
        }

        // 4. Nhập Số điện thoại (Validate PhoneException)
        String phone;
        while (true) {
            try {
                System.out.print("Nhập Số điện thoại (10 chữ số, bắt đầu bằng 0, vd: 0912345678): ");
                phone = scanner.nextLine().trim();
                phone = Validator.validatePhone(phone);
                break;
            } catch (PhoneException e) {
                System.out.println("❌ " + e.getMessage() + " Vui lòng nhập lại.");
            }
        }

        // 5. Nhập Email (Validate EmailException)
        String email;
        while (true) {
            try {
                System.out.print("Nhập Email (ví dụ: nguyen.van.a@company.com): ");
                email = scanner.nextLine().trim();
                email = Validator.validateEmail(email);
                break;
            } catch (EmailException e) {
                System.out.println("❌ " + e.getMessage() + " Vui lòng nhập lại.");
            }
        }

        Employee employee = null;

        // 6. Nhập thông tin đặc thù theo từng loại nhân viên
        if (employeeType == 0) { // Experience
            int expInYear = 0;
            while (true) {
                System.out.print("Nhập số năm kinh nghiệm (ExpInYear): ");
                String expStr = scanner.nextLine().trim();
                try {
                    expInYear = Integer.parseInt(expStr);
                    if (expInYear < 0) {
                        System.out.println("⚠️ Số năm kinh nghiệm phải >= 0!");
                        continue;
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("⚠️ Vui lòng nhập số nguyên hợp lệ!");
                }
            }
            System.out.print("Nhập kỹ năng chuyên môn (ProSkill): ");
            String proSkill = scanner.nextLine().trim();

            employee = new Experience(id, fullName, birthday, phone, email, expInYear, proSkill);

        } else if (employeeType == 1) { // Fresher
            System.out.print("Nhập thời gian tốt nghiệp (Graduation_date - ví dụ: 06/2023): ");
            String graduationDate = scanner.nextLine().trim();
            System.out.print("Nhập xếp loại tốt nghiệp (Graduation_rank - ví dụ: Giỏi): ");
            String graduationRank = scanner.nextLine().trim();
            System.out.print("Nhập trường tốt nghiệp (Education - ví dụ: ĐH Bách Khoa): ");
            String education = scanner.nextLine().trim();

            employee = new Fresher(id, fullName, birthday, phone, email, graduationDate, graduationRank, education);

        } else if (employeeType == 2) { // Intern
            System.out.print("Nhập chuyên ngành đang học (Majors - ví dụ: Công nghệ thông tin): ");
            String majors = scanner.nextLine().trim();
            System.out.print("Nhập học kỳ đang học (Semester - ví dụ: Học kỳ 6): ");
            String semester = scanner.nextLine().trim();
            System.out.print("Nhập tên trường đang học (University_name - ví dụ: ĐH Công nghệ TP.HCM): ");
            String universityName = scanner.nextLine().trim();

            employee = new Intern(id, fullName, birthday, phone, email, majors, semester, universityName);
        }

        // 7. Nhập danh sách bằng cấp (Certificates)
        System.out.print("\nBạn có muốn nhập Bằng cấp (Certificate) cho nhân viên này không? (y/n): ");
        String addCert = scanner.nextLine().trim();
        while (addCert.equalsIgnoreCase("y")) {
            System.out.print("  - Nhập Mã bằng cấp: ");
            String cId = scanner.nextLine().trim();
            System.out.print("  - Nhập Tên bằng cấp: ");
            String cName = scanner.nextLine().trim();
            System.out.print("  - Nhập Xếp loại: ");
            String cRank = scanner.nextLine().trim();
            System.out.print("  - Nhập Ngày cấp: ");
            String cDate = scanner.nextLine().trim();

            if (employee != null) {
                employee.addCertificate(new Certificate(cId, cName, cRank, cDate));
                System.out.println("  ✅ Đã thêm bằng cấp!");
            }

            System.out.print("Bạn có muốn nhập thêm bằng cấp khác không? (y/n): ");
            addCert = scanner.nextLine().trim();
        }

        // Thêm vào danh sách quản lý
        if (manager.addEmployee(employee)) {
            System.out.println("\n🎉 THÊM NHÂN VIÊN MỚI THÀNH CÔNG!");
            employee.showMe();
        }
    }

    /**
     * Sửa nhân viên theo ID (Yêu cầu 7)
     */
    private static void editEmployee() {
        System.out.println("\n--- CHỈNH SỬA THÔNG TIN NHÂN VIÊN ---");
        System.out.print("Nhập ID nhân viên cần chỉnh sửa: ");
        String id = scanner.nextLine().trim();
        manager.editEmployee(id, scanner);
    }

    /**
     * Xóa nhân viên theo ID (Yêu cầu 7)
     */
    private static void deleteEmployee() {
        System.out.println("\n--- XÓA NHÂN VIÊN THEO ID ---");
        System.out.print("Nhập ID nhân viên cần xóa: ");
        String id = scanner.nextLine().trim();

        Employee emp = manager.findById(id);
        if (emp == null) {
            System.out.println("❌ Không tìm thấy nhân viên có ID: " + id);
            return;
        }

        System.out.println("Bạn đang chuẩn bị xóa nhân viên:");
        emp.showInfo();
        System.out.print("Bạn có chắc chắn muốn xóa nhân viên này không? (y/n): ");
        String confirm = scanner.nextLine().trim();
        if (confirm.equalsIgnoreCase("y")) {
            if (manager.deleteEmployee(id)) {
                System.out.println("✅ Đã xóa nhân viên có ID: " + id + " thành công!");
            }
        } else {
            System.out.println("ℹ️ Đã hủy thao tác xóa.");
        }
    }

    /**
     * Tìm nhân viên theo ID
     */
    private static void findEmployeeById() {
        System.out.println("\n--- TÌM KIẾM NHÂN VIÊN THEO ID ---");
        System.out.print("Nhập ID cần tìm: ");
        String id = scanner.nextLine().trim();
        Employee emp = manager.findById(id);
        if (emp != null) {
            System.out.println("✅ Tìm thấy nhân viên:");
            emp.showMe();
        } else {
            System.out.println("❌ Không tìm thấy nhân viên có ID: " + id);
        }
    }

    /**
     * Hiển thị danh sách Intern (Yêu cầu 9)
     */
    private static void showInterns() {
        System.out.println("\n====================== DANH SÁCH NHÂN VIÊN INTERN (YÊU CẦU 9) ======================");
        List<Intern> interns = manager.findInterns();
        if (interns.isEmpty()) {
            System.out.println("⚠️ Không có nhân viên Intern nào trong hệ thống.");
            return;
        }
        for (Intern intern : interns) {
            intern.showMe();
            System.out.println();
        }
    }

    /**
     * Hiển thị danh sách Experience (Yêu cầu 10)
     */
    private static void showExperiences() {
        System.out.println("\n=================== DANH SÁCH NHÂN VIÊN EXPERIENCE (YÊU CẦU 10) ===================");
        List<Experience> experiences = manager.findExperiences();
        if (experiences.isEmpty()) {
            System.out.println("⚠️ Không có nhân viên Experience nào trong hệ thống.");
            return;
        }
        for (Experience exp : experiences) {
            exp.showMe();
            System.out.println();
        }
    }

    /**
     * Hiển thị danh sách Fresher (Yêu cầu 11)
     */
    private static void showFreshers() {
        System.out.println("\n===================== DANH SÁCH NHÂN VIÊN FRESHER (YÊU CẦU 11) =====================");
        List<Fresher> freshers = manager.findFreshers();
        if (freshers.isEmpty()) {
            System.out.println("⚠️ Không có nhân viên Fresher nào trong hệ thống.");
            return;
        }
        for (Fresher fresher : freshers) {
            fresher.showMe();
            System.out.println();
        }
    }

    /**
     * Hiển thị biến tĩnh đếm số nhân viên
     */
    private static void showEmployeeCount() {
        System.out.println("\n--- SỐ LƯỢNG NHÂN VIÊN KHỞI TẠO (STATIC EMPLOYEE COUNT) ---");
        System.out.println("📊 Thuộc tính tĩnh Employee.employee_count = " + Employee.employee_count);
        System.out.println("📊 Số lượng nhân viên hiện có trong danh sách = " + manager.getEmployeeList().size());
    }

    /**
     * Khởi tạo dữ liệu mẫu kiểm thử
     */
    private static void initSampleData() {
        // Experience 1
        Experience exp1 = new Experience("EXP01", "Nguyễn Văn Hùng", "15/04/1988", "0901234567",
                "hung.nguyen@company.com", 8, "Java Core, Spring Boot, Microservices");
        exp1.addCertificate("C01", "Oracle Certified Java Pro", "Xuất sắc", "10/05/2018");
        exp1.addCertificate("C02", "AWS Solutions Architect", "Giỏi", "12/08/2021");
        manager.addEmployee(exp1);

        // Fresher 1
        Fresher fre1 = new Fresher("FRE01", "Trần Thị Mai", "22/10/2001", "0912345678",
                "mai.tran@company.com", "07/2023", "Giỏi", "Đại học Bách Khoa");
        fre1.addCertificate("C03", "TOEIC 850", "Giỏi", "03/2023");
        manager.addEmployee(fre1);

        // Intern 1
        Intern itn1 = new Intern("ITN01", "Lê Hoàng Nam", "05/12/2003", "0987654321",
                "nam.le@company.com", "Khoa học Máy tính", "Học kỳ 7", "Đại học Công nghệ Thông tin");
        itn1.addCertificate("C04", "Chứng chỉ Lập trình Java căn bản", "Khá", "01/2024");
        manager.addEmployee(itn1);
    }
}
