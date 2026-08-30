# Task 1-1: Làm bài tập Java như mô tả bên dưới
Đây là bài tập nhóm về lập trình Java căn bản, giao diện CLI, tương tác từ dòng lệnh
- Tạo dự án Phần mềm quản lý nhân viên của công ty theo như mô tả ở phần Nội dung yêu cầu phần mềm
- Dạng hướng dẫn làm dự án từng bước 1, có giải thích rõ ràng, dễ hiểu
- Sử dụng ngôn ngữ Java
- Tạo file hướng dẫn làm từng bước dạng step by step cho người mới học để thực hiện các yêu cầu bên dưới gồm yêu cầu 1, 2, 3, đến yêu cầu 12
  - Hướng dẫn từng bước, có giải thích dễ hiểu để thực hiện từng yêu cầu
- Cấu trúc code tổ chức rõ ràng, dễ hiểu như entity, exception, service
- Tạo hướng dẫn sử dụng, hướng dẫn chạy chương trình
- Kiến thức học viên đã học gồm có kiến thức căn bản Java, class, lập trình hướng đối tượng OOP
- Cấu trúc dự án rõ ràng như entity, exception, service,...


## Nội dung yêu cầu phần mềm:
Phần mềm quản lý nhân viên của công ty được mô tả nghiệp vụ như sau:
Mỗi nhân viên (Employee) được công ty chia thành 3 loại sau: Nhân viên có kinh nghiệm lâu năm (Experience), nhân viên mới ra trường (Fresher), Nhân viên thực tập (Intern)
Tất cả các Employee đều có các thuộc tính là: ID, FullName, BirthDay, Phone, Email, Employee_type, Employee_count và phương thức là ShowInfo để hiển thị thông tin của nhân viên đó (hiển thị thông tin nhân viên ra màn hình console).

Trong đó :
Emplovee type: có giá trị tương ứng là 0: Experience, 1: Fresher , 2: Intern (tùy vào người dùng nhập vào ứng viên loại
Emplovee count: dùng để người dùng đếm số lượng nhân viên trong một đợt người dùng nhập nhân viên mới vào cơ sở dữ liệu. (mỗi lần người dùng nhập thêm mới nhân viên thì thuộc tính Emelovee count của class Employee sẽ tăng lên 1)

Ngoài ra:
Đối với nhân viên Experience có thêm thuộc tính: Số năm kinh nghiệm (ExpInYear), Kỹ năng chuyên môn (ProSkill)
Đối với nhân việnn Fresher có thêm thuộc tính: Thời gian tốt nghiệp (Graduation date), Xếp loại tốt nghiệp (Graduation rank), Trường tốt nghiệp (Education)
Đổi với nhân viên Intern có thêm thuộc tính: Chuyên ngành đang học (Majors), Học kì đang học (Semester), Tên trường đang học (University_name)

Lưu ý: Tùy mỗi loại nhân viên, phương thức ShowInfo sẽ được bổ sung thêm các thuộc tính của riêng loại nhân viên đó.

Ngoài ra mỗi nhân viên khi vào làm cần phải nộp bằng cấp nghề nghiệp đi kèm, bộ phận tuyển dụng cần quản lý các bằng cấp này. Một nhân viên có thể có nhiều bằng cấp (Certificate)
Với mỗi bằng cấp có các thông tin bao gồm : CertificatedID, CertificateName, CertificateRank, CertificatedDate.

**Yêu cầu**
1. Hãy thiết kế và viết code của chương trình trên làm sao để tuân thủ theo đúng mô hình OOP đã học, áp dụng đầy đủ 4 tính chất: Đóng gói (encapsulation), kế thừa (inheritance), đa hình (polymorphism), trừu tượng (abstraction).
2. Xác định và viết code constructor cho tất cả các class.
3. Xác đinh và viết code cho các abstract method, abstract class, override/overload method, static field.
4. Xác định Is A, Has A relationship trong phần thiết kế code đã viết ở trên.
5. Sử dụng và giải thích được ý nghĩa của 2 keyword: super, this trong phần thiết kế code ở trên.
6. Hãy giải thích ý nghĩa của toán tử instanceof, và ứng dụng instangeof để downcasting 1 object Employee trở thành các object Experience, Fresher hoặc intern trong các yêu
cầu bên dưới.
7. Viết class EmployeeManager có chức năng cho phép thêm, sửa (Nhập ID để xác định một nhân viên, nếu tồn tại cho phép người dùng chỉnh sửa thông tin của nhân viên), xóa (xóa theo ID) các loại nhân viên trên.
8. Viết các hàm kiểm tra tính hợp lệ của ngày sinh, email, tên và số điện thoại của nhân viên. Áp dụng các hàm này vào chức
năng
9. Viết chương trình tìm tất cả các nhân viên intern.
10. Viết chương trình tìm tất cả các nhân viên experience
11. Viết chương trình tìm tất cả các nhân viên fresher
12. Tạo ra các BirthDayException, PhoneException, EmailException


Cập nhật lại tổ chức code dạng đơn giản hơn như:
- src
  - entity/       # Chứa các lớp thực thể (Employee, Experience, Fresher, Intern, Certificate)
  - exception/    # Chứa các ngoại lệ tự định nghĩa (BirthDayException, EmailException, PhoneException, FullNameException)
  - util/         # Chứa các hàm tiện ích kiểm tra tính hợp lệ dữ liệu (Validator)
  - service/      # Chứa lớp xử lý nghiệp vụ quản lý (EmployeeManager)
  - main/         # Chứa giao diện dòng lệnh tương tác Menu CLI (Main)

- bỏ phân cấp com/company
- cập nhật lại file hướng dẫn và file README
