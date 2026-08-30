package service;

import entity.Certificate;
import entity.Employee;
import entity.Experience;
import entity.Fresher;
import entity.Intern;
import exception.BirthDayException;
import exception.EmailException;
import exception.FullNameException;
import exception.PhoneException;
import util.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Lớp EmployeeManager thực hiện các chức năng quản lý nhân viên:
 * - Thêm nhân viên mới (Yêu cầu 7)
 * - Sửa thông tin nhân viên theo ID (Yêu cầu 7)
 * - Xóa nhân viên theo ID (Yêu cầu 7)
 * - Tìm tất cả Intern (Yêu cầu 9 - Áp dụng instanceof & Downcasting)
 * - Tìm tất cả Experience (Yêu cầu 10 - Áp dụng instanceof & Downcasting)
 * - Tìm tất cả Fresher (Yêu cầu 11 - Áp dụng instanceof & Downcasting)
 */
public class EmployeeManager {
    private List<Employee> employeeList;

    public EmployeeManager() {
        this.employeeList = new ArrayList<>();
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    /**
     * Thêm mới một nhân viên vào hệ thống.
     * Kiểm tra ID trùng lặp trước khi thêm.
     *
     * @param employee Nhân viên cần thêm
     * @return true nếu thêm thành công, false nếu ID đã tồn tại
     */
    public boolean addEmployee(Employee employee) {
        if (employee == null) {
            return false;
        }
        if (findById(employee.getId()) != null) {
            System.out.println("❌ Lỗi: Mã nhân viên '" + employee.getId() + "' đã tồn tại trong hệ thống!");
            return false;
        }
        employeeList.add(employee);
        return true;
    }

    /**
     * Tìm kiếm một nhân viên theo ID.
     *
     * @param id Mã nhân viên cần tìm
     * @return Đối tượng Employee nếu tìm thấy, null nếu không tồn tại
     */
    public Employee findById(String id) {
        if (id == null || id.trim().isEmpty()) {
            return null;
        }
        for (Employee emp : employeeList) {
            if (emp.getId().trim().equalsIgnoreCase(id.trim())) {
                return emp;
            }
        }
        return null;
    }

    /**
     * Xóa nhân viên theo ID (Yêu cầu 7).
     *
     * @param id Mã nhân viên cần xóa
     * @return true nếu xóa thành công, false nếu không tìm thấy
     */
    public boolean deleteEmployee(String id) {
        Employee emp = findById(id);
        if (emp != null) {
            employeeList.remove(emp);
            return true;
        }
        return false;
    }

    /**
     * Chỉnh sửa thông tin nhân viên theo ID (Yêu cầu 7).
     * Áp dụng toán tử instanceof và kỹ thuật Downcasting (Yêu cầu 6) để sửa thuộc tính riêng của từng loại nhân viên.
     *
     * @param id      Mã nhân viên cần sửa
     * @param scanner Đối tượng Scanner để nhận dữ liệu nhập từ bàn phím
     * @return true nếu cập nhật thành công, false nếu không tìm thấy nhân viên
     */
    public boolean editEmployee(String id, Scanner scanner) {
        Employee emp = findById(id);
        if (emp == null) {
            System.out.println("❌ Không tìm thấy nhân viên có ID: " + id);
            return false;
        }

        System.out.println("\n===== CHỈNH SỬA THÔNG TIN NHÂN VIÊN: " + emp.getFullName() + " (ID: " + emp.getId() + ") =====");
        System.out.println("Gợi ý: Nhấn Enter nếu muốn giữ nguyên thông tin cũ.");

        // 1. Chỉnh sửa Họ tên
        System.out.print("Họ tên hiện tại [" + emp.getFullName() + "]: ");
        String nameInput = scanner.nextLine().trim();
        if (!nameInput.isEmpty()) {
            try {
                Validator.validateFullName(nameInput);
                emp.setFullName(nameInput);
            } catch (FullNameException e) {
                System.out.println("⚠️ " + e.getMessage() + " -> Giữ nguyên họ tên cũ.");
            }
        }

        // 2. Chỉnh sửa Ngày sinh
        System.out.print("Ngày sinh hiện tại [" + emp.getBirthDay() + "]: ");
        String birthdayInput = scanner.nextLine().trim();
        if (!birthdayInput.isEmpty()) {
            try {
                Validator.validateBirthday(birthdayInput);
                emp.setBirthDay(birthdayInput);
            } catch (BirthDayException e) {
                System.out.println("⚠️ " + e.getMessage() + " -> Giữ nguyên ngày sinh cũ.");
            }
        }

        // 3. Chỉnh sửa Số điện thoại
        System.out.print("Số điện thoại hiện tại [" + emp.getPhone() + "]: ");
        String phoneInput = scanner.nextLine().trim();
        if (!phoneInput.isEmpty()) {
            try {
                Validator.validatePhone(phoneInput);
                emp.setPhone(phoneInput);
            } catch (PhoneException e) {
                System.out.println("⚠️ " + e.getMessage() + " -> Giữ nguyên số điện thoại cũ.");
            }
        }

        // 4. Chỉnh sửa Email
        System.out.print("Email hiện tại [" + emp.getEmail() + "]: ");
        String emailInput = scanner.nextLine().trim();
        if (!emailInput.isEmpty()) {
            try {
                Validator.validateEmail(emailInput);
                emp.setEmail(emailInput);
            } catch (EmailException e) {
                System.out.println("⚠️ " + e.getMessage() + " -> Giữ nguyên email cũ.");
            }
        }

        // 5. Chỉnh sửa thuộc tính riêng biệt (Ứng dụng instanceof & Downcasting)
        if (emp instanceof Experience) {
            // Downcasting: Ép kiểu đối tượng cha (Employee) về đối tượng con cụ thể (Experience)
            Experience expEmp = (Experience) emp;
            System.out.println("\n--- Cập nhật thông tin riêng của Experience ---");
            
            System.out.print("Số năm kinh nghiệm hiện tại [" + expEmp.getExpInYear() + "]: ");
            String expYearStr = scanner.nextLine().trim();
            if (!expYearStr.isEmpty()) {
                try {
                    int expYears = Integer.parseInt(expYearStr);
                    if (expYears >= 0) {
                        expEmp.setExpInYear(expYears);
                    } else {
                        System.out.println("⚠️ Số năm kinh nghiệm không được âm!");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("⚠️ Số năm kinh nghiệm phải là số nguyên!");
                }
            }

            System.out.print("Kỹ năng chuyên môn hiện tại [" + expEmp.getProSkill() + "]: ");
            String proSkillInput = scanner.nextLine().trim();
            if (!proSkillInput.isEmpty()) {
                expEmp.setProSkill(proSkillInput);
            }

        } else if (emp instanceof Fresher) {
            // Downcasting: Ép kiểu đối tượng cha (Employee) về đối tượng con cụ thể (Fresher)
            Fresher fresherEmp = (Fresher) emp;
            System.out.println("\n--- Cập nhật thông tin riêng của Fresher ---");

            System.out.print("Thời gian tốt nghiệp hiện tại [" + fresherEmp.getGraduationDate() + "]: ");
            String gradDateInput = scanner.nextLine().trim();
            if (!gradDateInput.isEmpty()) {
                fresherEmp.setGraduationDate(gradDateInput);
            }

            System.out.print("Xếp loại tốt nghiệp hiện tại [" + fresherEmp.getGraduationRank() + "]: ");
            String rankInput = scanner.nextLine().trim();
            if (!rankInput.isEmpty()) {
                fresherEmp.setGraduationRank(rankInput);
            }

            System.out.print("Trường tốt nghiệp hiện tại [" + fresherEmp.getEducation() + "]: ");
            String eduInput = scanner.nextLine().trim();
            if (!eduInput.isEmpty()) {
                fresherEmp.setEducation(eduInput);
            }

        } else if (emp instanceof Intern) {
            // Downcasting: Ép kiểu đối tượng cha (Employee) về đối tượng con cụ thể (Intern)
            Intern internEmp = (Intern) emp;
            System.out.println("\n--- Cập nhật thông tin riêng của Intern ---");

            System.out.print("Chuyên ngành đang học hiện tại [" + internEmp.getMajors() + "]: ");
            String majorsInput = scanner.nextLine().trim();
            if (!majorsInput.isEmpty()) {
                internEmp.setMajors(majorsInput);
            }

            System.out.print("Học kỳ đang học hiện tại [" + internEmp.getSemester() + "]: ");
            String semInput = scanner.nextLine().trim();
            if (!semInput.isEmpty()) {
                internEmp.setSemester(semInput);
            }

            System.out.print("Tên trường ĐH đang học hiện tại [" + internEmp.getUniversityName() + "]: ");
            String uniInput = scanner.nextLine().trim();
            if (!uniInput.isEmpty()) {
                internEmp.setUniversityName(uniInput);
            }
        }

        // 6. Cho phép thêm bằng cấp mới nếu muốn
        System.out.print("\nBạn có muốn thêm Bằng cấp (Certificate) mới cho nhân viên này không? (y/n): ");
        String addCertChoice = scanner.nextLine().trim();
        if (addCertChoice.equalsIgnoreCase("y")) {
            System.out.print("Nhập Mã bằng cấp: ");
            String cId = scanner.nextLine().trim();
            System.out.print("Nhập Tên bằng cấp: ");
            String cName = scanner.nextLine().trim();
            System.out.print("Nhập Xếp loại bằng: ");
            String cRank = scanner.nextLine().trim();
            System.out.print("Nhập Ngày cấp (dd/MM/yyyy): ");
            String cDate = scanner.nextLine().trim();

            emp.addCertificate(new Certificate(cId, cName, cRank, cDate));
            System.out.println("✅ Đã thêm bằng cấp mới thành công!");
        }

        System.out.println("✅ Cập nhật thông tin nhân viên hoàn tất!");
        return true;
    }

    /**
     * Hiển thị tất cả nhân viên trong hệ thống (Đa hình Polymorphism).
     */
    public void showAllEmployees() {
        if (employeeList.isEmpty()) {
            System.out.println("⚠️ Danh sách nhân viên đang trống!");
            return;
        }
        System.out.println("\n=========================== TỔNG DANH SÁCH NHÂN VIÊN (" + employeeList.size() + ") ===========================");
        for (Employee emp : employeeList) {
            emp.showMe();
            System.out.println();
        }
    }

    /**
     * Yêu cầu 9: Tìm tất cả các nhân viên Intern.
     * Sử dụng toán tử instanceof để kiểm tra và Downcasting để xử lý.
     *
     * @return Danh sách các nhân viên Intern
     */
    public List<Intern> findInterns() {
        List<Intern> interns = new ArrayList<>();
        for (Employee emp : employeeList) {
            // Toán tử instanceof kiểm tra xem emp có thực sự là một đối tượng Intern hay không
            if (emp instanceof Intern) {
                // Downcasting: ép kiểu từ Employee sang Intern
                Intern intern = (Intern) emp;
                interns.add(intern);
            }
        }
        return interns;
    }

    /**
     * Yêu cầu 10: Tìm tất cả các nhân viên Experience.
     * Sử dụng toán tử instanceof để kiểm tra và Downcasting để xử lý.
     *
     * @return Danh sách các nhân viên Experience
     */
    public List<Experience> findExperiences() {
        List<Experience> experiences = new ArrayList<>();
        for (Employee emp : employeeList) {
            // Toán tử instanceof kiểm tra xem emp có là Experience hay không
            if (emp instanceof Experience) {
                // Downcasting: ép kiểu từ Employee sang Experience
                Experience exp = (Experience) emp;
                experiences.add(exp);
            }
        }
        return experiences;
    }

    /**
     * Yêu cầu 11: Tìm tất cả các nhân viên Fresher.
     * Sử dụng toán tử instanceof để kiểm tra và Downcasting để xử lý.
     *
     * @return Danh sách các nhân viên Fresher
     */
    public List<Fresher> findFreshers() {
        List<Fresher> freshers = new ArrayList<>();
        for (Employee emp : employeeList) {
            // Toán tử instanceof kiểm tra xem emp có là Fresher hay không
            if (emp instanceof Fresher) {
                // Downcasting: ép kiểu từ Employee sang Fresher
                Fresher fresher = (Fresher) emp;
                freshers.add(fresher);
            }
        }
        return freshers;
    }
}
