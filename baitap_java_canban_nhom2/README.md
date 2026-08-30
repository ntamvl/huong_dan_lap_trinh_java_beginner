# DỰ ÁN QUẢN LÝ NHÂN VIÊN CÔNG TY (JAVA OOP CLI)

> **Bài tập nhóm Lập trình Java căn bản & Lập trình hướng đối tượng (OOP)**
> **Giao diện dòng lệnh (CLI - Command Line Interface)**

---

## 📌 1. Giới Thiệu Dự Án
Phần mềm Quản lý Nhân viên là ứng dụng Java dòng lệnh được thiết kế theo đúng chuẩn mô hình Lập trình Hướng Đối Tượng (OOP). Hệ thống cho phép quản lý thông tin các loại nhân viên trong công ty:
- **Experience**: Nhân viên có kinh nghiệm lâu năm (Số năm kinh nghiệm, Kỹ năng chuyên môn).
- **Fresher**: Nhân viên mới tốt nghiệp ra trường (Thời gian tốt nghiệp, Xếp loại tốt nghiệp, Trường tốt nghiệp).
- **Intern**: Nhân viên thực tập sinh (Chuyên ngành đang học, Học kỳ đang học, Tên trường đại học).
- **Certificate**: Quản lý danh sách các bằng cấp nghề nghiệp kèm theo của từng nhân viên.

---

## 📁 2. Cấu Trúc Thư Mục Dự Án Đơn Giản

```
baitap_java_canban_nhom2/
├── src/
│   ├── entity/
│   │   ├── Certificate.java        # Thực thể Bằng cấp
│   │   ├── Employee.java           # Lớp trừu tượng Nhân viên
│   │   ├── Experience.java         # Lớp nhân viên có kinh nghiệm
│   │   ├── Fresher.java            # Lớp nhân viên mới ra trường
│   │   └── Intern.java             # Lớp nhân viên thực tập
│   ├── exception/
│   │   ├── BirthDayException.java  # Ngoại lệ ngày sinh không hợp lệ
│   │   ├── EmailException.java     # Ngoại lệ email không hợp lệ
│   │   ├── FullNameException.java  # Ngoại lệ họ tên không hợp lệ
│   │   └── PhoneException.java     # Ngoại lệ số điện thoại không hợp lệ
│   ├── util/
│   │   └── Validator.java          # Tiện ích kiểm tra tính hợp lệ dữ liệu
│   ├── service/
│   │   └── EmployeeManager.java    # Xử lý nghiệp vụ Thêm, Sửa, Xóa, Tìm kiếm
│   └── main/
│       └── Main.java               # Chương trình chính & Menu CLI
├── HUONG_DAN_CHI_TIET_12_YEU_CAU.md        # Hướng dẫn chi tiết giải thích cặn kẽ 12 yêu cầu OOP
└── README.md                               # Hướng dẫn cài đặt và sử dụng
```

---

## 📋 3. Bảng Đối Chiếu 12 Yêu Cầu Đã Thực Hiện

| STT | Yêu Cầu Nghiệp Vụ & Kỹ Thuật | Vị Trí Cài Đặt Trong Source Code |
|:---:|:---|:---|
| **1** | 4 Tính chất OOP: Đóng gói, Kế thừa, Đa hình, Trừu tượng | Toàn bộ package `entity`, `service` |
| **2** | Constructor cho tất cả các class (default + full param) | `Employee.java`, `Experience.java`, `Fresher.java`, `Intern.java`, `Certificate.java` |
| **3** | Abstract class, Abstract method, Override, Overload, Static field | `Employee.java` (`showInfo()`, `employee_count`, `addCertificate()`) |
| **4** | Mối quan hệ `Is-A` (Kế thừa) và `Has-A` (Chứa đựng) | `Experience/Fresher/Intern extends Employee` và `Employee has List<Certificate>` |
| **5** | Sử dụng và giải thích từ khóa `super`, `this` | `Experience.java`, `Fresher.java`, `Intern.java`, `Employee.java` |
| **6** | Toán tử `instanceof` và kỹ thuật `Downcasting` | `EmployeeManager.java` (trong các hàm `editEmployee`, `findInterns`, `findExperiences`, `findFreshers`) |
| **7** | Lớp `EmployeeManager` (Thêm, Sửa theo ID, Xóa theo ID) | `EmployeeManager.java` |
| **8** | Các hàm kiểm tra ngày sinh, email, họ tên, số điện thoại | `Validator.java` |
| **9** | Tìm tất cả các nhân viên Intern | `EmployeeManager.findInterns()` (Lựa chọn `6` trên CLI) |
| **10** | Tìm tất cả các nhân viên Experience | `EmployeeManager.findExperiences()` (Lựa chọn `7` trên CLI) |
| **11** | Tìm tất cả các nhân viên Fresher | `EmployeeManager.findFreshers()` (Lựa chọn `8` trên CLI) |
| **12** | Tạo `BirthDayException`, `PhoneException`, `EmailException` | Package `exception` |

---

## 🚀 4. Hướng Dẫn Biên Dịch & Chạy Chương Trình

### Yêu cầu môi trường
- Đã cài đặt **JDK (Java Development Kit)** phiên bản 8 trở lên (khuyên dùng JDK 11, 17, 21 hoặc mới hơn).

### Cách 1: Chạy bằng dòng lệnh (Terminal / Command Prompt)

#### Trên macOS / Linux:
```bash
# 1. Di chuyển vào thư mục dự án
cd /path/to/baitap_java_canban_nhom2

# 2. Biên dịch toàn bộ file java sang thư mục bin
javac -d bin -encoding UTF-8 $(find src -name "*.java")

# 3. Chạy chương trình
java -cp bin main.Main
```

#### Trên Windows (CMD / PowerShell):
```cmd
# 1. Di chuyển vào thư mục dự án
cd \path\to\baitap_java_canban_nhom2

# 2. Biên dịch
javac -d bin -encoding UTF-8 -sourcepath src src/main/Main.java

# 3. Chạy chương trình
java -cp bin main.Main
```

### Cách 2: Mở bằng IDE (IntelliJ IDEA / Eclipse / VS Code)
1. Mở IDE và chọn **Open Project** -> Chọn thư mục `baitap_java_canban_nhom2`.
2. Đánh dấu thư mục `src` là **Sources Root**.
3. Mở file [Main.java](file:///Users/tamnguyen/Projects/learning/java/baitap_java_canban_nhom2/src/main/Main.java) và nhấn nút **Run** (hoặc `Shift + F10`).

---

## 💻 5. Hướng Dẫn Sử Dụng Menu Giao Diện Dòng Lệnh (CLI)

Khi chương trình khởi chạy, menu tương tác sau sẽ xuất hiện:

```
╔══════════════════════════════════════════════════════════════╗
║         PHẦN MỀM QUẢN LÝ NHÂN VIÊN CÔNG TY (OOP CLI)         ║
╠══════════════════════════════════════════════════════════════╣
║ 1. Thêm nhân viên mới (Experience / Fresher / Intern)        ║
║ 2. Chỉnh sửa thông tin nhân viên theo ID                     ║
║ 3. Xóa nhân viên theo ID                                     ║
║ 4. Hiển thị danh sách tất cả nhân viên                       ║
║ 5. Tìm kiếm nhân viên theo ID                                ║
║ 6. Tìm và hiển thị tất cả nhân viên Intern (Yêu cầu 9)       ║
║ 7. Tìm và hiển thị tất cả nhân viên Experience (Yêu cầu 10)  ║
║ 8. Tìm và hiển thị tất cả nhân viên Fresher (Yêu cầu 11)     ║
║ 9. Xem tổng số nhân viên đã khởi tạo (Static Employee Count) ║
║ 10. Nạp thêm dữ liệu mẫu (Sample Data)                       ║
║ 0. Thoát chương trình                                        ║
╚══════════════════════════════════════════════════════════════╝
```

- **Phím 1**: Thêm nhân viên mới. Hệ thống sẽ yêu cầu chọn loại (0: Experience, 1: Fresher, 2: Intern) và lần lượt nhập các trường thông tin. Nếu nhập sai định dạng email, ngày sinh hoặc số điện thoại, hệ thống sẽ báo lỗi Exception và cho phép nhập lại ngay lập tức. Sau đó có thể nhập thêm bằng cấp (`Certificate`).
- **Phím 2**: Nhập ID nhân viên cần cập nhật. Có thể nhấn `Enter` để giữ nguyên thông tin cũ nếu không muốn đổi.
- **Phím 3**: Nhập ID để xóa nhân viên khỏi hệ thống (có bước xác nhận `y/n`).
- **Phím 4**: Hiển thị toàn bộ danh sách nhân viên kèm đầy đủ danh sách bằng cấp.
- **Phím 5**: Tra cứu nhân viên theo ID cụ thể.
- **Phím 6, 7, 8**: Lọc và hiển thị danh sách từng loại nhân viên (Intern, Experience, Fresher) áp dụng `instanceof` và Downcasting.
- **Phím 9**: Xem giá trị của biến tĩnh `Employee.employee_count`.
- **Phím 10**: Nạp thêm dữ liệu mẫu để thử nghiệm nhanh các tính năng.
- **Phím 0**: Thoát ứng dụng.

---

## 📖 6. Tài Liệu Học Tập Dành Cho Người Mới Bắt Đầu
Vui lòng đọc file [HUONG_DAN_CHI_TIET_12_YEU_CAU.md](file:///Users/tamnguyen/Projects/learning/java/baitap_java_canban_nhom2/HUONG_DAN_CHI_TIET_12_YEU_CAU.md) để xem giải thích cặn kẽ từng dòng code, nguyên lý OOP, cách bẫy ngoại lệ và bài học rút ra cho từng yêu cầu.
