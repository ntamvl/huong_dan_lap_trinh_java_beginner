package util;

import exception.BirthDayException;
import exception.EmailException;
import exception.FullNameException;
import exception.PhoneException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * Lớp Validator chứa các phương thức tĩnh kiểm tra tính hợp lệ của dữ liệu đầu vào.
 * Áp dụng cho Yêu cầu 8 và Yêu cầu 12.
 */
public class Validator {

    // Biểu thức chính quy kiểm tra định dạng Email chuẩn
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
    
    // Biểu thức chính quy kiểm tra Số điện thoại (10 chữ số, bắt đầu bằng 0)
    private static final String PHONE_REGEX = "^0[0-9]{9}$";

    /**
     * Kiểm tra tính hợp lệ của Ngày sinh (định dạng dd/MM/yyyy).
     * Bắn ra BirthDayException nếu không đúng định dạng hoặc ngày không tồn tại trên lịch.
     *
     * @param birthday Ngày sinh nhập vào
     * @return Chuỗi ngày sinh đã chuẩn hóa nếu hợp lệ
     * @throws BirthDayException nếu ngày sinh không hợp lệ
     */
    public static String validateBirthday(String birthday) throws BirthDayException {
        if (birthday == null || birthday.trim().isEmpty()) {
            throw new BirthDayException("Lỗi: Ngày sinh không được để trống!");
        }

        birthday = birthday.trim();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false); // Bắt buộc kiểm tra chính xác ngày theo lịch (vd: 30/02 sẽ bị báo lỗi)

        try {
            Date date = sdf.parse(birthday);
            
            // Kiểm tra năm sinh hợp lý (từ năm 1900 đến năm hiện tại)
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            int year = cal.get(Calendar.YEAR);
            int currentYear = Calendar.getInstance().get(Calendar.YEAR);

            if (year < 1900 || year > currentYear) {
                throw new BirthDayException("Lỗi: Năm sinh phải từ 1900 đến " + currentYear + "!");
            }

            return birthday;
        } catch (ParseException e) {
            throw new BirthDayException("Lỗi: Ngày sinh '" + birthday + "' không đúng định dạng dd/MM/yyyy hoặc ngày không tồn tại!");
        }
    }

    /**
     * Kiểm tra tính hợp lệ của Email.
     * Bắn ra EmailException nếu định dạng email sai.
     *
     * @param email Địa chỉ email nhập vào
     * @return Chuỗi email nếu hợp lệ
     * @throws EmailException nếu email không hợp lệ
     */
    public static String validateEmail(String email) throws EmailException {
        if (email == null || email.trim().isEmpty()) {
            throw new EmailException("Lỗi: Email không được để trống!");
        }

        email = email.trim();
        if (!Pattern.matches(EMAIL_REGEX, email)) {
            throw new EmailException("Lỗi: Email '" + email + "' không hợp lệ! (Ví dụ đúng: example@company.com)");
        }

        return email;
    }

    /**
     * Kiểm tra tính hợp lệ của Số điện thoại.
     * Bắn ra PhoneException nếu số điện thoại không hợp lệ (cần 10 chữ số, bắt đầu bằng 0).
     *
     * @param phone Số điện thoại nhập vào
     * @return Chuỗi số điện thoại nếu hợp lệ
     * @throws PhoneException nếu số điện thoại sai định dạng
     */
    public static String validatePhone(String phone) throws PhoneException {
        if (phone == null || phone.trim().isEmpty()) {
            throw new PhoneException("Lỗi: Số điện thoại không được để trống!");
        }

        phone = phone.trim();
        if (!Pattern.matches(PHONE_REGEX, phone)) {
            throw new PhoneException("Lỗi: Số điện thoại '" + phone + "' không hợp lệ! (Phải gồm 10 chữ số và bắt đầu bằng số 0, vd: 0987654321)");
        }

        return phone;
    }

    /**
     * Kiểm tra tính hợp lệ của Họ tên nhân viên.
     * Bắn ra FullNameException nếu tên rỗng hoặc chứa ký tự đặc biệt/chữ số.
     *
     * @param fullName Họ tên nhập vào
     * @return Chuỗi họ tên đã chuẩn hóa nếu hợp lệ
     * @throws FullNameException nếu họ tên không hợp lệ
     */
    public static String validateFullName(String fullName) throws FullNameException {
        if (fullName == null || fullName.trim().isEmpty()) {
            throw new FullNameException("Lỗi: Họ và tên không được để trống!");
        }

        fullName = fullName.trim();
        // Cho phép chữ cái tiếng Việt có dấu, khoảng trắng
        String nameRegex = "^[a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s]+$";
        
        if (!Pattern.matches(nameRegex, fullName)) {
            throw new FullNameException("Lỗi: Họ và tên '" + fullName + "' chứa ký tự không hợp lệ (chỉ chấp nhận chữ cái và khoảng trắng)!");
        }

        return fullName;
    }
}
