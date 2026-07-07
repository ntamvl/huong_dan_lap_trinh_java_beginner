# LỘ TRÌNH VÀ TÀI LIỆU HƯỚNG DẪN HỌC LẬP TRÌNH JAVA TOÀN DIỆN
> **Dành cho:** Người mới bắt đầu (Beginner)
> **Tác giả:** Chuyên gia Đào tạo Lập trình & Kỹ sư Phần mềm Cao cấp
> **Ngôn ngữ:** Tiếng Việt
> **Phiên bản Java đích:** Java 17 LTS / Java 21 LTS

---

## MỤC LỤC
* [PHẦN 1: Hướng dẫn cài đặt môi trường & Chạy chương trình](#phần-1-hướng-dẫn-cài-đặt-môi-trường--chạy-chương-trình-dành-cho-người-mới)
* [PHẦN 2: Lộ trình học Java Core (Cơ bản đến Khá)](#phần-2-lộ-trình-học-java-core-cơ-bản-đến-khá)
* [PHẦN 3: Lập trình Java nâng cao (Advanced Java)](#phần-3-lập-trình-java-nâng-cao-advanced-java)
* [PHẦN 4: Bài tập thực hành & Project nhỏ cuối khóa](#phần-4-bài-tập-thực-hành--project-nhỏ)

---

## PHẦN 1: HƯỚNG DẪN CÀI ĐẶT MÔI TRƯỜNG & CHẠY CHƯƠNG TRÌNH (DÀNH CHO NGƯỜI MỚI)

Để bắt đầu lập trình Java, bạn cần cài đặt **JDK (Java Development Kit)** - bộ công cụ phát triển phần mềm cung cấp trình biên dịch (`javac`) và môi trường thực thi (`jre`). Chúng tôi chọn **Java 17 LTS** hoặc **Java 21 LTS** vì đây là các phiên bản hỗ trợ dài hạn (Long-Term Support), cực kỳ ổn định trong môi trường doanh nghiệp.

### 1. Hướng dẫn cài đặt JDK

#### Trên hệ điều hành Windows
1. **Tải JDK:**
   - Truy cập trang chủ Eclipse Adoptium: [adoptium.net](https://adoptium.net) (khuyên dùng vì hoàn toàn miễn phí và mã nguồn mở - Temurin OpenJDK).
   - Chọn phiên bản **Java 17 (LTS)** hoặc **Java 21 (LTS)** cho Windows x64 và tải file cài đặt `.msi` hoặc `.exe`.
2. **Cài đặt:**
   - Chạy file tải về, bấm **Next**.
   - *Lưu ý quan trọng:* Trong quá trình cài đặt, tích chọn **"Set JAVA_HOME variable"** và **"Associate .jar files"** để bộ cài đặt tự động cấu hình.
3. **Cấu hình thủ công biến môi trường (Environment Variables) - Nếu cần:**
   - Mở **Start**, tìm kiếm `Environment Variables` và chọn **Edit the system environment variables**.
   - Nhấp vào nút **Environment Variables...**.
   - Tại mục **System Variables**:
     - Bấm **New...** để tạo biến `JAVA_HOME`:
       - *Variable name:* `JAVA_HOME`
       - *Variable value:* Đường dẫn đến thư mục cài đặt JDK (Ví dụ: `C:\Program Files\Eclipse Foundation\jdk-17.0.x.x-hotspot\`).
     - Tìm biến `Path`, chọn nó và bấm **Edit...**:
       - Bấm **New** và thêm dòng: `%JAVA_HOME%\bin`
       - Bấm **OK** để lưu lại tất cả.

#### Trên hệ điều hành Ubuntu (Terminal)
Bạn có thể dễ dàng cài đặt OpenJDK thông qua trình quản lý gói `apt`:
```bash
# 1. Cập nhật danh sách gói phần mềm
sudo apt update

# 2. Cài đặt OpenJDK 17 LTS (hoặc thay bằng openjdk-21-jdk nếu muốn dùng Java 21)
sudo apt install -y openjdk-17-jdk

# 3. Cấu hình biến môi trường JAVA_HOME trong file shell profile (~/.bashrc hoặc ~/.zshrc)
echo 'export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64' >> ~/.bashrc
echo 'export PATH=$PATH:$JAVA_HOME/bin' >> ~/.bashrc

# 4. Áp dụng các thay đổi mà không cần khởi động lại Terminal
source ~/.bashrc
```

#### Kiểm tra cài đặt thành công (Áp dụng cho cả Windows & Ubuntu)
Mở Command Prompt/PowerShell (Windows) hoặc Terminal (Ubuntu) và chạy hai lệnh sau:
```bash
java -version
javac -version
```
> **Kết quả mong đợi:** Màn hình hiển thị thông tin phiên bản Java tương tự như:
> `openjdk version "17.0.x" ...` hoặc `java version "21.x.x" ...`

---

### 2. Hướng dẫn chạy chương trình Java bằng Terminal / Command Line

Hiểu cách thực thi chương trình thông qua dòng lệnh là nền tảng cốt lõi giúp người mới hiểu rõ cơ chế hoạt động của máy ảo Java (JVM).

#### So sánh cách chạy Truyền thống vs Hiện đại

| Đặc điểm | Cách chạy Truyền thống (Trước Java 11) | Cách chạy Hiện đại (Từ Java 11 trở đi) |
| :--- | :--- | :--- |
| **Tên tính năng** | Biên dịch và thực thi 2 bước | Single-File Source-Code |
| **Quy trình** | **Bước 1:** Biên dịch sang Bytecode: `javac HelloWorld.java` tạo ra file `HelloWorld.class`. <br>**Bước 2:** Chạy file bytecode: `java HelloWorld` | Thực thi trực tiếp file mã nguồn bằng 1 câu lệnh duy nhất: `java HelloWorld.java`. |
| **File trung gian** | Có tạo ra file `.class` | **Không** tạo ra file `.class` vật lý trên ổ đĩa. |
| **Mục đích sử dụng** | Dành cho các ứng dụng thực tế, dự án lớn có nhiều file class liên kết với nhau. | Thích hợp cho việc test nhanh code, chạy các file script đơn lẻ của người mới học. |

#### Hướng dẫn thực hành từng bước
1. Mở một trình soạn thảo văn bản đơn giản (Notepad trên Windows hoặc Gedit/Nano trên Ubuntu).
2. Tạo một file mới và nhập đoạn code sau:
   ```java
   public class HelloWorld {
       public static void main(String[] args) {
           System.out.println("Xin chào Việt Nam! Chúc bạn học Java vui vẻ!");
       }
   }
   ```
3. Lưu file này với tên chính xác là `HelloWorld.java` (Lưu ý: Tên file phải trùng khớp hoàn toàn với tên `class` công khai và viết hoa chữ cái đầu).

##### Cách 1: Chạy theo kiểu truyền thống (2 bước)
Mở Terminal/CMD tại thư mục lưu file và gõ:
```bash
# Bước 1: Biên dịch (Tạo ra file HelloWorld.class)
javac HelloWorld.java

# Bước 2: Thực thi file class (Lưu ý không thêm đuôi .class vào sau tên class)
java HelloWorld
```

##### Cách 2: Chạy theo kiểu hiện đại (1 bước - Chỉ từ Java 11+)
```bash
java HelloWorld.java
```
*Kết quả đầu ra của cả 2 cách:*
```text
Xin chào Việt Nam! Chúc bạn học Java vui vẻ!
```

---

### 3. Hướng dẫn cài đặt và cấu hình IDE (Môi trường phát triển tích hợp)

Khi đã nắm vững dòng lệnh, bạn nên chuyển sang dùng IDE để tăng năng suất lập trình.

#### Visual Studio Code (VS Code)
1. Tải và cài đặt VS Code từ trang chủ: [code.visualstudio.com](https://code.visualstudio.com).
2. Mở VS Code, truy cập vào mục **Extensions** (phím tắt `Ctrl+Shift+X` hoặc `Cmd+Shift+X` trên macOS).
3. Tìm kiếm từ khóa `Extension Pack for Java` (do Microsoft phát triển) và bấm **Install**. Gói này tự động cài đặt các công cụ hỗ trợ nhưDebugger, Maven/Gradle support, IntelliCode...
4. Để chạy chương trình: Chỉ cần tạo file `.java`, VS Code sẽ tự hiện nút **Run | Debug** ngay phía trên hàm `main`. Click **Run** để chạy chương trình.

#### Eclipse IDE
1. Tải bản cài đặt Eclipse Installer từ: [eclipse.org/downloads](https://www.eclipse.org/downloads).
2. Mở Installer, chọn phiên bản **Eclipse IDE for Java Developers**.
3. Tiến hành cài đặt và khởi động Eclipse. Chọn một thư mục làm Workspace (nơi chứa các dự án).
4. **Tạo Java Project cơ bản:**
   - Chọn **File** -> **New** -> **Java Project**.
   - Đặt tên Project (Ví dụ: `HocJavaCoBan`), chọn JRE tương ứng và nhấn **Finish**.
   - Chuột phải vào thư mục `src` trong Project Explorer, chọn **New** -> **Class**.
   - Đặt tên Class là `App`, tích chọn ô `public static void main(String[] args)`, nhấn **Finish**.
   - Viết lệnh in ra màn hình và click chuột phải chọn **Run As** -> **Java Application** để thực thi.

#### IntelliJ IDEA (Khuyên dùng - IDE mạnh mẽ nhất cho Java)
1. **Tải phiên bản miễn phí:** Truy cập trang tải về của JetBrains: [jetbrains.com/idea/download](https://www.jetbrains.com/idea/download). Cuộn xuống phần **IntelliJ IDEA Community Edition** (phiên bản miễn phí dành cho học tập và phát triển cá nhân) và tải về.
2. **Cài đặt:**
   - **Windows:** Chạy file cài đặt `.exe`. Trong phần *Installation Options*, bạn nên tích chọn **Add "bin" folder to the PATH**, **Create Desktop Shortcut**, và **Associate .java files**.
   - **Ubuntu/Linux:** Bạn có thể cài đặt dễ dàng thông qua gói snap bằng lệnh:
     ```bash
     sudo snap install intellij-idea-community --classic
     ```
3. **Tạo dự án Java đầu tiên:**
   - Khởi động IntelliJ IDEA, nhấp chọn **New Project**.
   - Đặt tên Project (Ví dụ: `HocJavaIntelliJ`).
   - Tại mục **JDK**: IntelliJ sẽ tự động nhận diện JDK đã cài đặt trong máy. Nếu chưa có, bạn có thể bấm vào menu thả xuống và chọn **Download JDK** để IntelliJ tự động tải về phiên bản tương thích cực kỳ tiện lợi.
   - Bấm **Create** để khởi tạo dự án.
   - Trong giao diện làm việc, chuột phải vào thư mục `src` -> **New** -> **Java Class**, đặt tên là `Main`.
   - Gõ phím tắt `psvm` hoặc `main` rồi ấn `Tab` để IDE tự động sinh nhanh hàm `public static void main`.
   - Viết mã nguồn in màn hình: `System.out.println("Xin chào từ IntelliJ IDEA!");`.
   - Bấm vào nút tam giác màu xanh lá cây (**Run**) nằm cạnh hàm main hoặc ở góc trên bên phải để chạy ứng dụng.
---

## PHẦN 2: LỘ TRÌNH HỌC JAVA CORE (CƠ BẢN ĐẾN KHÁ)

---

### 1. Nhập môn Java: Cấu trúc chương trình, biến, kiểu dữ liệu, toán tử

Mỗi chương trình Java luôn bắt đầu bằng các class. Code thực thi nằm trong hàm entry-point `main`.

```java
package com.giaoduc.core; // Package dùng để phân nhóm các Class tránh xung đột tên

public class NhapMon { // Tên class trùng với tên file NhapMon.java

    public static void main(String[] args) { // Hàm main: Nơi JVM bắt đầu chạy chương trình

        // --- 1. Khai báo biến và các kiểu dữ liệu nguyên thủy (Primitive Types) ---
        int tuoi = 20;               // Kiểu số nguyên (4 bytes)
        double diem = 8.5;           // Kiểu số thực dấu phẩy động (8 bytes)
        char kyTu = 'A';             // Kiểu ký tự đơn (2 bytes, dùng nháy đơn)
        boolean laSinhVien = true;   // Kiểu logic (true/false)

        // --- 2. Kiểu dữ liệu đối tượng / tham chiếu (Reference Type) ---
        String ten = "Nguyễn Văn A"; // Chuỗi ký tự (dùng nháy kép)

        // --- 3. Sử dụng toán tử ---
        int namHienTai = 2026;
        int namSinh = namHienTai - tuoi; // Toán tử số học

        // In kết quả ra màn hình Console
        System.out.println("Tên: " + ten);
        System.out.println("Năm sinh: " + namSinh);
        System.out.println("Điểm số: " + diem + " | Đạt chuẩn: " + laSinhVien);
    }
}
```
> **Giải thích dòng code quan trọng:**
> - `package`: Định danh không gian tên của class, giúp quản lý mã nguồn khoa học hơn.
> - `public static void main(String[] args)`:
>   - `public`: Cho phép JVM gọi hàm này từ bên ngoài.
>   - `static`: Hàm thuộc về class, JVM có thể gọi mà không cần tạo đối tượng.
>   - `void`: Hàm không trả về giá trị.
>   - `String[] args`: Tham số đầu vào dạng mảng chuỗi nhận từ dòng lệnh.

---

### 2. Cấu trúc điều khiển & Vòng lặp

Điều khiển luồng chương trình bằng các điều kiện logic và lặp lại công việc khi điều kiện thỏa mãn.

```java
package com.giaoduc.core;

public class DieuKhienVongLap {
    public static void main(String[] args) {
        int diem = 78;

        // --- 1. Khối lệnh if-else ---
        if (diem >= 90) {
            System.out.println("Xếp loại: Xuất sắc");
        } else if (diem >= 70) {
            System.out.println("Xếp loại: Khá");
        } else {
            System.out.println("Xếp loại: Trung bình/Yếu");
        }

        // --- 2. Cấu trúc switch-case (Kiểu switch expression mới của Java hiện đại) ---
        String thu = "Thứ Hai";
        String loaiNgay = switch (thu) {
            case "Thứ Bảy", "Chủ Nhật" -> "Cuối tuần";
            default -> "Ngày trong tuần";
        };
        System.out.println(thu + " là: " + loaiNgay);

        // --- 3. Vòng lặp for ---
        System.out.print("Vòng lặp for: ");
        for (int i = 1; i <= 3; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        // --- 4. Vòng lặp while & break/continue ---
        int dem = 0;
        System.out.print("Vòng lặp while: ");
        while (dem < 10) {
            dem++;
            if (dem == 3) continue; // Bỏ qua số 3, nhảy sang vòng lặp tiếp theo
            if (dem > 5) break;     // Thoát hẳn vòng lặp khi dem vượt quá 5
            System.out.print(dem + " ");
        }
        System.out.println();
    }
}
```
> **Giải thích dòng code quan trọng:**
> - `switch (thu) { ... -> ... }`: Sử dụng cú pháp Switch Expression (Java 14+) giúp code ngắn gọn, không lo lỗi thiếu từ khóa `break` gây tràn (fall-through).
> - `continue`: Bỏ qua các dòng lệnh phía dưới nó trong vòng lặp và đi tới lượt lặp kế tiếp ngay lập tức.
> - `break`: Ngắt và dừng vòng lặp hiện tại ngay lập tức.

---

### 3. Mảng và Chuỗi (Array & String)

Quản lý danh sách phần tử cùng kiểu dữ liệu và xử lý văn bản một cách tối ưu.

```java
package com.giaoduc.core;

public class MangVaChuoi {
    public static void main(String[] args) {
        // --- 1. Mảng 1 chiều ---
        int[] danhSachSo = {2, 4, 6, 8};
        System.out.println("Phần tử thứ hai của mảng: " + danhSachSo[1]); // Index bắt đầu từ 0

        // --- 2. String (Tính chất bất biến - Immutability) ---
        String s1 = "Hello";
        String s2 = s1.concat(" World"); // Tạo ra đối tượng String mới trên vùng nhớ Heap
        System.out.println("s1 gốc vẫn là: " + s1); // Vẫn giữ nguyên "Hello"
        System.out.println("s2 mới: " + s2);

        // --- 3. StringBuilder (Mutable - Khuyên dùng khi sửa đổi chuỗi liên tục) ---
        StringBuilder sb = new StringBuilder("Java");
        sb.append(" Core");
        sb.insert(4, " 17");
        System.out.println("Chuỗi sau khi nối: " + sb.toString()); // Kết quả: Java 17 Core
    }
}
```
> **Giải thích dòng code quan trọng:**
> - `String s1 = "Hello"`: Đối tượng String trong Java là bất biến (immutable). Khi bạn thao tác cộng/nối chuỗi, Java không sửa trực tiếp vùng nhớ cũ mà tạo ra một đối tượng String hoàn toàn mới.
> - `StringBuilder`: Khác với String, StringBuilder cho phép sửa đổi nội dung chuỗi ngay trên chính vùng nhớ ban đầu (mutable). Điều này giúp tiết kiệm bộ nhớ, tăng hiệu năng đáng kể khi phải thao tác với chuỗi lớn trong vòng lặp. `StringBuffer` hoạt động tương tự nhưng có cơ chế đồng bộ hóa (Thread-safe), tốc độ chậm hơn `StringBuilder`.

---

### 4. Lập trình hướng đối tượng (OOP)

OOP là xương sống của Java. Java hỗ trợ 4 đặc tính quan trọng: Đóng gói, Kế thừa, Đa hình và Trừu tượng.

```java
package com.giaoduc.core;

// --- 1. Tính trừu tượng (Abstraction): Định nghĩa khung thiết kế qua lớp trừu tượng ---
abstract class DongVat {
    private String ten; // Tính đóng gói: Che giấu dữ liệu bằng private

    public DongVat(String ten) {
        this.ten = ten; // Từ khóa 'this': Tham chiếu đến thực thể hiện tại
    }

    public String getTen() { return ten; } // Getter công khai để đọc dữ liệu

    public abstract void phatAmThanh(); // Phương thức trừu tượng (không có thân hàm)
}

// --- 2. Tính kế thừa (Inheritance): Lớp con thừa hưởng từ lớp cha ---
class ConCho extends DongVat {
    public ConCho(String ten) {
        super(ten); // Từ khóa 'super': Gọi Constructor của lớp cha
    }

    // --- 3. Tính đa hình (Polymorphism) & Overriding: Ghi đè phương thức ---
    @Override
    public void phatAmThanh() {
        System.out.println(getTen() + " sủa: Gâu Gâu!");
    }
}

class ConMeo extends DongVat {
    public ConMeo(String ten) {
        super(ten);
    }

    @Override
    public void phatAmThanh() {
        System.out.println(getTen() + " kêu: Meo Meo!");
    }
}

public class OOPDemo {
    public static void main(String[] args) {
        // Đa hình thực tế: Một biến lớp cha tham chiếu đến đối tượng lớp con
        DongVat cho = new ConCho("Kiki");
        DongVat meo = new ConMeo("Mimi");

        cho.phatAmThanh(); // Kiki sủa: Gâu Gâu!
        meo.phatAmThanh(); // Mimi kêu: Meo Meo!
    }
}
```
> **Giải thích các từ khóa quan trọng:**
> - `this`: Đại diện cho đối tượng của lớp hiện tại. Dùng để phân biệt khi tham số truyền vào trùng tên với thuộc tính của Class.
> - `super`: Đại diện cho lớp cha trực tiếp của lớp hiện hành. Dùng để gọi Constructor hoặc phương thức của lớp cha.
> - `static`: Đánh dấu thuộc tính/phương thức thuộc về Class chứ không thuộc về từng đối tượng cụ thể (được dùng chung trên toàn hệ thống).
> - `final`: Khi dùng với biến sẽ biến nó thành hằng số; dùng với phương thức ngăn không cho ghi đè (override); dùng với Class ngăn không cho kế thừa.

---

### 5. Xử lý ngoại lệ (Exception Handling)

Exception dùng để kiểm soát các lỗi phát sinh trong thời gian chạy (Runtime) giúp chương trình không bị crash đột ngột.

```java
package com.giaoduc.core;

import java.io.FileReader;
import java.io.IOException;

public class XuLyNgoaiLe {

    // Checked Exception: Phải khai báo 'throws' hoặc xử lý try-catch ngay lúc viết code
    public static void docFile() throws IOException {
        FileReader file = new FileReader("khong_ton_tai.txt");
        file.read();
        file.close();
    }

    public static void main(String[] args) {
        // --- 1. Try-Catch-Finally ---
        try {
            int a = 10;
            int b = 0;
            int c = a / b; // Chia cho 0 gây ra ArithmeticException (Unchecked Exception)
            System.out.println("Kết quả: " + c);
        } catch (ArithmeticException e) {
            System.out.println("Lỗi toán học: Không thể chia cho số 0!");
        } finally {
            System.out.println("Khối finally luôn luôn được thực thi dù lỗi xảy ra hay không.");
        }

        // --- 2. Gọi hàm ném ra Checked Exception ---
        try {
            docFile();
        } catch (IOException e) {
            System.out.println("Lỗi file I/O: " + e.getMessage());
        }
    }
}
```
> **Phân biệt Checked và Unchecked Exception:**
> - **Checked Exception:** Là các ngoại lệ kế thừa trực tiếp từ `java.lang.Exception` (trừ `RuntimeException`). Trình biên dịch sẽ bắt buộc bạn phải xử lý (`try-catch`) hoặc ném đi tiếp (`throws`) tại thời điểm viết code (Compile-time). Ví dụ: `IOException`, `SQLException`.
> - **Unchecked Exception:** Kế thừa từ `java.lang.RuntimeException`. Trình biên dịch không bắt buộc khai báo. Thường xuất hiện do lỗi logic của lập trình viên. Ví dụ: `NullPointerException`, `ArrayIndexOutOfBoundsException`, `ArithmeticException`.

---

### 6. Java Collections Framework

Collections Framework cung cấp các cấu trúc dữ liệu dựng sẵn mạnh mẽ phục vụ lưu trữ và xử lý tập hợp đối tượng.

```java
package com.giaoduc.core;

import java.util.*;

public class CollectionDemo {
    public static void main(String[] args) {

        // --- 1. LIST: Có thứ tự, cho phép chứa phần tử trùng lặp ---
        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("Python");
        list.add("Java"); // Phần tử trùng lặp
        System.out.println("List: " + list); // Output: [Java, Python, Java]

        // --- 2. SET: Không chứa phần tử trùng lặp, không đảm bảo thứ tự ---
        Set<String> set = new HashSet<>();
        set.add("Java");
        set.add("Python");
        set.add("Java"); // Trùng lặp, sẽ bị bỏ qua
        System.out.println("Set: " + set); // Output: [Java, Python]

        // --- 3. MAP: Lưu trữ dạng Key - Value. Key không được trùng lặp ---
        Map<Integer, String> map = new HashMap<>();
        map.put(101, "Nguyễn Văn A");
        map.put(102, "Trần Thị B");
        map.put(101, "Lê Văn C"); // Ghi đè value của key 101 trước đó
        System.out.println("Map: " + map); // Output: {101=Lê Văn C, 102=Trần Thị B}
    }
}
```

#### Khi nào dùng Collection nào?
- **ArrayList:** Dùng khi cần truy xuất phần tử cực nhanh theo vị trí chỉ mục (index). Không thích hợp cho việc thêm/xóa phần tử ở giữa danh sách thường xuyên.
- **LinkedList:** Thích hợp khi chương trình yêu cầu thêm, xóa phần tử liên tục ở đầu hoặc cuối danh sách.
- **HashSet:** Cực nhanh khi cần kiểm tra phần tử có tồn tại hay không và loại bỏ các phần tử trùng lặp.
- **TreeSet:** Giống Set nhưng tự động sắp xếp các phần tử theo thứ tự tăng dần.
- **HashMap:** Dùng khi lưu trữ dữ liệu dạng cặp ánh xạ (từ khóa - giá trị), ví dụ: Tra cứu thông tin người dùng bằng mã ID.

---

## PHẦN 3: LẬP TRÌNH JAVA NÂNG CAO (ADVANCED JAVA)

---

### 1. Java 8+ New Features: Lambda, Stream & Optional

Java 8 đánh dấu kỷ nguyên mới của Java với việc hỗ trợ lập trình hàm (Functional Programming).

```java
package com.giaoduc.advanced;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Java8PlusDemo {
    public static void main(String[] args) {
        List<String> lapTrinhVien = Arrays.asList("JavaCoder", "PythonDev", "JSDeveloper", "RubyDev", "KotlinCoder");

        // --- 1. Lambda Expression & Stream API ---
        // Lọc lập trình viên có tên chứa chữ "Coder", viết hoa hết và thu thập lại vào List mới
        List<String> ketQua = lapTrinhVien.stream()
                .filter(name -> name.contains("Coder"))                  // Lọc (Lambda Expression)
                .map(String::toUpperCase)                               // Chuyển đổi (Method Reference)
                .collect(Collectors.toList());                          // Thu gom kết quả

        System.out.println("Danh sách Coder: " + ketQua); // Output: [JAVACODER, KOTLINCODER]

        // --- 2. Optional để chống NullPointerException ---
        String tenNull = null;
        Optional<String> optionalName = Optional.ofNullable(tenNull);

        // Tránh viết if (name != null) rườm rà
        String ketQuaTen = optionalName.orElse("Tên mặc định không tồn tại");
        System.out.println("Tên nhận được: " + ketQuaTen);
    }
}
```
> **Giải thích dòng code quan trọng:**
> - `stream()`: Mở một luồng dữ liệu (Stream) từ tập hợp để xử lý tuần tự mà không làm thay đổi dữ liệu gốc.
> - `filter(name -> name.contains("Coder"))`: Sử dụng biểu thức Lambda để viết nhanh phương thức lọc. Ký tự `->` phân tách giữa tham số đầu vào và phần thực thi.
> - `Optional.ofNullable(tenNull)`: Bọc đối tượng có nguy cơ bị `null` vào một chiếc hộp an toàn. Lệnh `.orElse(...)` trả về giá trị mặc định được chỉ định nếu đối tượng bên trong hộp bị `null`.

---

### 2. Đa luồng (Multithreading & Concurrency)

Đa luồng cho phép ứng dụng của bạn làm nhiều công việc cùng một lúc để tận dụng tối đa sức mạnh của CPU đa nhân.

```java
package com.giaoduc.advanced;

class TaiKhoanNganHang {
    private int soDu = 1000;

    // Sử dụng từ khóa 'synchronized' để đảm bảo Thread Safety (Tránh Race Condition)
    public synchronized void rutTien(String tenThread, int soTien) {
        if (soDu >= soTien) {
            System.out.println(tenThread + " chuẩn bị rút tiền...");
            try { Thread.sleep(100); } catch (InterruptedException e) {} // Giả lập xử lý ngân hàng
            soDu -= soTien;
            System.out.println(tenThread + " rút thành công! Số dư còn lại: " + soDu);
        } else {
            System.out.println(tenThread + " rút thất bại! Không đủ số dư. Hiện tại: " + soDu);
        }
    }
}

public class MultiThreadingDemo {
    public static void main(String[] args) {
        TaiKhoanNganHang tk = new TaiKhoanNganHang();

        // Tạo 2 luồng rút tiền cùng lúc trên cùng 1 tài khoản
        Runnable rutTienTask = () -> {
            String threadName = Thread.currentThread().getName();
            tk.rutTien(threadName, 700);
        };

        Thread t1 = new Thread(rutTienTask, "Người chồng");
        Thread t2 = new Thread(rutTienTask, "Người vợ");

        t1.start(); // Khởi chạy luồng 1
        t2.start(); // Khởi chạy luồng 2
    }
}
```
> **Giải thích dòng code quan trọng:**
> - `synchronized`: Khi một phương thức được khai báo `synchronized`, tại một thời điểm chỉ có duy nhất một Thread được phép truy cập và thực thi mã nguồn bên trong phương thức đó trên cùng một đối tượng. Các Thread khác phải xếp hàng chờ đợi.
> - Nếu bỏ từ khóa `synchronized`, cả hai vợ chồng có thể cùng thấy số dư là 1000 và cùng rút 700 thành công, khiến tài khoản bị âm (-400) - Đây là lỗi logic kinh điển có tên **Race Condition** trong lập trình song song.

---

### 3. File I/O và Serialization

Lưu trữ dữ liệu chương trình vĩnh viễn xuống ổ đĩa cứng (Persistence) thông qua tập tin.

```java
package com.giaoduc.advanced;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

// Khai báo implements Serializable để Java cho phép chuyển đổi đối tượng này thành dạng nhị phân
class NguoiDung implements Serializable {
    private static final long serialVersionUID = 1L; // Mã định danh phiên bản Serializable
    String username;
    transient String password; // Từ khóa 'transient': Thuộc tính này sẽ BỊ BỎ QUA khi ghi vào file

    public NguoiDung(String username, String password) {
        this.username = username;
        this.password = password;
    }
}

public class FileIOSerializationDemo {
    public static void main(String[] args) throws Exception {
        String txtFile = "data.txt";
        String objFile = "user.ser";

        // --- 1. Ghi/Đọc File dạng text thông dụng (Sử dụng Java NIO Files mới) ---
        Path path = Paths.get(txtFile);
        Files.writeString(path, "Học Java rất thú vị!\nĐây là dòng thứ 2."); // Ghi file cực nhanh từ Java 11

        List<String> lines = Files.readAllLines(path); // Đọc toàn bộ dòng trong file
        System.out.println("Đọc file văn bản:");
        lines.forEach(System.out.println);

        // --- 2. Serialization: Ghi đối tượng đối tượng NguoiDung ra File nhị phân ---
        NguoiDung user = new NguoiDung("admin", "secret123");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(objFile))) {
            oos.writeObject(user);
        }

        // --- 3. Deserialization: Đọc ngược dữ liệu nhị phân lên thành đối tượng Java ---
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(objFile))) {
            NguoiDung userDocDuoc = (NguoiDung) ois.readObject();
            System.out.println("Đọc đối tượng đã Serialize:");
            System.out.println("Username: " + userDocDuoc.username);
            System.out.println("Password (đã bị bỏ qua nhờ transient): " + userDocDuoc.password); // Output: null
        }
    }
}
```
> **Giải thích dòng code quan trọng:**
> - `transient`: Là một bổ nghĩa (modifier) áp dụng cho thuộc tính của Class. Nó thông báo cho JVM biết thuộc tính này chứa dữ liệu nhạy cảm hoặc không cần thiết, không cần ghi ra file nhị phân trong quá trình Serialization.
> - `Serializable`: Một interface đánh dấu (marker interface - không chứa bất kỳ phương thức nào). Nếu một Class không implements interface này, JVM sẽ ném ra `NotSerializableException` khi cố ghi đối tượng.

---

### 4. Kết nối Cơ sở dữ liệu (JDBC Overview)

Làm quen với việc giao tiếp dữ liệu giữa Java và các hệ quản trị cơ sở dữ liệu quan hệ (RDBMS).

```java
package com.giaoduc.advanced;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCDemo {
    // Cấu hình URL kết nối Database (Ví dụ cơ sở dữ liệu MySQL)
    private static final String DB_URL = "jdbc:mysql://localhost:3006/hoc_java_db";
    private static final String USER = "root";
    private static final String PASS = "password123";

    public static void main(String[] args) {
        String insertSql = "INSERT INTO hoc_vien (ten, email) VALUES (?, ?)";
        String selectSql = "SELECT id, ten, email FROM hoc_vien";

        // Sử dụng Try-with-resources để tự động đóng Connection & PreparedStatement
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement insertStmt = conn.prepareStatement(insertSql);
             PreparedStatement selectStmt = conn.prepareStatement(selectSql)) {

            // --- 1. CREATE (Thêm mới dữ liệu) ---
            insertStmt.setString(1, "Trần Văn Học");
            insertStmt.setString(2, "vanhoc@gmail.com");
            int rowsInserted = insertStmt.executeUpdate();
            System.out.println("Đã thêm mới " + rowsInserted + " dòng.");

            // --- 2. READ (Đọc dữ liệu) ---
            try (ResultSet rs = selectStmt.executeQuery()) {
                System.out.println("Danh sách học viên từ CSDL:");
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String ten = rs.getString("ten");
                    String email = rs.getString("email");
                    System.out.println("ID: " + id + " | Tên: " + ten + " | Email: " + email);
                }
            }

        } catch (SQLException e) {
            System.err.println("Lỗi kết nối cơ sở dữ liệu JDBC: " + e.getMessage());
        }
    }
}
```
> **Giải thích dòng code quan trọng:**
> - `PreparedStatement`: Giúp bảo mật chương trình khỏi lỗi tấn công **SQL Injection** nổi tiếng nhờ cơ chế gán tham số thông qua dấu chấm hỏi `?` thay vì cộng chuỗi SQL thủ công. Nó cũng giúp tối ưu hiệu năng vì câu lệnh SQL chỉ được biên dịch một lần duy nhất tại Database.
> - `DriverManager.getConnection(...)`: Tạo lập kết nối vật lý thực tế tới Cơ sở dữ liệu.
> - `Try-with-resources`: Khai báo các đối tượng tài nguyên bên trong ngoặc tròn `try(...)`. Các tài nguyên này (như Connection, Statement, ResultSet) bắt buộc phải implements interface `AutoCloseable`. Khi khối `try` kết thúc, Java sẽ tự động gọi phương thức `.close()` cho bạn, ngăn ngừa triệt để lỗi rò rỉ bộ nhớ (Resource Leak).

---

## PHẦN 4: BÀI TẬP THỰC HÀNH & PROJECT NHỎ

Để rèn luyện tư duy logic giải quyết vấn đề và ghép nối tất cả các mảnh ghép lý thuyết ở trên lại với nhau, học viên hãy lần lượt tự xây dựng các Project Console thực tế dưới đây.

---

### Project 1: Hệ thống Quản lý Sinh viên (Console)
* **Độ khó:** Dễ
* **Kiến thức áp dụng:** OOP cơ bản, ArrayList, Đọc/Ghi file text đơn giản.
* **Mô tả bài toán:** Xây dựng chương trình quản lý thông tin sinh viên hiển thị menu chọn chức năng trên Console.
* **Các bước triển khai:**
  1. Thiết kế lớp `SinhVien` chứa các thuộc tính: `maSV`, `hoTen`, `tuoi`, `diemTB`.
  2. Tạo lớp `QuanLySinhVien` chứa danh sách sinh viên `ArrayList<SinhVien>`.
  3. Viết các hàm thực thi chức năng tương ứng:
     - **Thêm sinh viên:** Nhập từ bàn phím và add vào danh sách.
     - **Hiển thị danh sách:** Duyệt qua list sinh viên và in thông tin định dạng đẹp mắt.
     - **Tìm kiếm sinh viên:** Tìm theo mã sinh viên (`maSV`).
     - **Xóa sinh viên:** Tìm kiếm và loại bỏ sinh viên khỏi danh sách.
     - **Sắp xếp:** Sắp xếp sinh viên theo thứ tự điểm trung bình giảm dần.
     - **Đọc/Ghi File:** Ghi toàn bộ dữ liệu ra file `sinhvien.txt` khi thoát và tự động tải lại dữ liệu khi khởi động chương trình.
  4. Viết hàm `main` chứa vòng lặp `while(true)` và cấu trúc `switch-case` tạo bảng menu tùy chọn.

---

### Project 2: Ứng dụng Mini Bank (Ngân hàng mini)
* **Độ khó:** Trung bình
* **Kiến thức áp dụng:** Tính đóng gói (Encapsulation), HashMap, Xử lý Exception tự chế (Custom Exception), Đọc/Ghi File Serialization.
* **Mô tả bài toán:** Mô phỏng các chức năng của một cây ATM rút tiền và quản lý tài khoản khách hàng.
* **Các bước triển khai:**
  1. Tạo class `TaiKhoan` chứa: `soTaiKhoan` (Key), `tenChuTaiKhoan`, `matKhau`, `soDu`.
  2. Tạo Class Exception tự chế tên là `SoDuKhongDuException` và `SaiMatKhauException`.
  3. Xây dựng dịch vụ ngân hàng:
     - Lưu trữ danh sách tài khoản bằng `HashMap<String, TaiKhoan>` để tra cứu nhanh bằng mã số tài khoản.
     - **Đăng nhập:** Người dùng nhập số tài khoản và mật khẩu. Ném ra `SaiMatKhauException` nếu mật khẩu không đúng.
     - **Gửi tiền / Rút tiền:** Tăng/Giảm số dư tài khoản. Khi rút tiền, nếu số dư hiện tại nhỏ hơn số tiền rút, ném ra lỗi `SoDuKhongDuException` và bắt lỗi ở Controller để in cảnh báo an toàn.
     - **Chuyển tiền:** Trừ tiền từ tài khoản nguồn, cộng tiền vào tài khoản đích (Sử dụng kiểm tra chặt chẽ).
  4. Lưu trữ toàn bộ trạng thái hệ thống ngân hàng xuống file `bank_data.ser` bằng Serialization.

---

### Project 3: Quản lý Công việc (To-Do List) Nâng cao
* **Độ khó:** Khá
* **Kiến thức áp dụng:** Java 8+ (Lambda, Stream API), LocalDate/LocalDateTime (Date Time API), File NIO.
* **Mô tả bài toán:** Quản lý các đầu việc cần làm của cá nhân có phân loại mức độ ưu tiên và ngày hết hạn.
* **Các bước triển khai:**
  1. Tạo class `CongViec` với các trường dữ liệu: `id`, `tieuDe`, `mucDoUuTien` (ENUM: LOW, MEDIUM, HIGH), `ngayHetHan` (`LocalDate`), `daHoanThanh` (`boolean`).
  2. Sử dụng Stream API để làm các chức năng lọc báo cáo thông minh:
     - In ra danh sách công việc trễ hạn nhưng chưa hoàn thành (`ngayHetHan` nhỏ hơn ngày hiện tại).
     - Nhóm và đếm số lượng công việc theo từng mức độ ưu tiên (Sử dụng `Collectors.groupingBy`).
     - Lọc ra 3 công việc quan trọng nhất (HIGH) sắp đến ngày hết hạn nhất để nhắc nhở (Sử dụng `.filter()`, `.sorted()`, `.limit(3)`).
  3. Sử dụng `Files.writeString(...)` của Java NIO để xuất báo cáo công việc hàng tuần đẹp mắt dưới định dạng file Markdown (`BaoCaoCongViec.md`).

---

### Project 4: Hệ thống Đặt Vé Xem Phim Song Song (Multithreading Ticket Booking)
* **Độ khó:** Nâng cao
* **Kiến thức áp dụng:** Multithreading, Thread Safety, synchronized, Concurrency Locks.
* **Mô tả bài toán:** Giả lập hệ thống bán vé trực tuyến của rạp chiếu phim khi hàng ngàn khách hàng truy cập đặt vé cùng một giây. Tránh tình trạng 1 ghế bị bán trùng cho 2 khách hàng khác nhau.
* **Các bước triển khai:**
  1. Tạo Class `GheXemPhim` chứa: `soGhe` (Ví dụ: "A1", "A2"), `daCoNguoiDat` (`boolean`), `tenKhachHang`.
  2. Tạo Class `RapChieuPhim` quản lý mảng/danh sách các `GheXemPhim`.
  3. Viết phương thức `synchronized boolean datGhe(String soGhe, String tenKhach)`:
     - Duyệt tìm ghế trong danh sách.
     - Nếu ghế chưa được đặt, chuyển trạng thái `daCoNguoiDat = true`, lưu tên khách và trả về `true`.
     - Nếu ghế đã được đặt, trả về `false`.
  4. Trong hàm `main`, khởi tạo danh sách ghế của rạp. Tạo 10 đến 20 Threads khác nhau đại diện cho các khách hàng cùng thực hiện hành vi gọi hàm đặt cùng một số ghế (Ví dụ: Tranh nhau đặt ghế VIP "H10").
  5. Chạy chương trình nhiều lần để quan sát log xem tính năng đồng bộ hóa `synchronized` đã giữ an toàn cho giao dịch đặt ghế hoạt động chính xác hay chưa.

---

Chúc các bạn học tập tốt và làm chủ ngôn ngữ Java! Hãy kiên trì thực hành viết code mỗi ngày để nâng cao kỹ năng tư duy lập trình của bản thân.
