import java.util.Scanner;

public class session6_2 {
    static Scanner sc = new Scanner(System.in);
    static String fullName = "";
    static String email = "";
    static String phone = "";
    static String password = "";
    public  static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n******************QUẢN LÝ NGƯỜI DÙNG****************");
            System.out.println("1. Nhập thông tin người dùng");
            System.out.println("2. Chuẩn hóa họ tên");
            System.out.println("3. Kiểm tra email hợp lệ");
            System.out.println("4. Kiểm tra số điện thoại hợp lệ");
            System.out.println("5. Kiểm tra mật khẩu hợp lệ");
            System.out.println("6. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    inputUser();
                    break;
                case 2:
                    normalizeName();
                    break;
                case 3:
                    checkEmail();
                    break;
                case 4:
                    checkPhone();
                    break;
                case 5:
                    checkPassword();
                    break;
                case 6:
                    System.out.println("Thoát chương trình!");
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (true);
    }
    //1. Nhap thong tin nguoi dung
    static void inputUser() {
        System.out.println("Nhap ho va ten: ");
        fullName = sc.nextLine();
        System.out.println("Nhap email: ");
        email = sc.nextLine();
        System.out.println("Nhap so dien thoai: ");
        phone = sc.nextLine();
        System.out.println("Nhap mat khau: ");
        password = sc.nextLine();
        System.out.println("Da nhap xong thong tin nguoi dung.");
    }
    //2.Chuan hoa ho ten
    static void normalizeName() {
        if (fullName.isEmpty()) {
            System.out.println("Chua co ho ten!");
            return;
        }
        String [] parts = fullName.trim().toLowerCase().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (String p : parts) {
            sb.append(Character.toLowerCase(p.charAt(0)))
                    .append(p.substring(1))
                    .append(" ");
        }
        fullName = sb.toString().trim();
        System.out.println("Ho va ten sau khi chuan hoa: " + fullName);
    }
    //3. Kiem tra email
    static void checkEmail() {
        String regex = "^[a-zA-Z0-9._]+@[a-zA-Z0-9]+(\\.[a-zA-Z]{2,6})+$";
        if (email.matches(regex)) {
            System.out.println("Email hợp lệ");
        } else {
            System.out.println("Email không hợp lệ");
        }
    }

    // 4. Kiểm tra số điện thoại VN
    static void checkPhone() {
        String regex = "^(0|\\+84)[0-9]{9}$";
        if (phone.matches(regex)) {
            System.out.println("Số điện thoại hợp lệ");
        } else {
            System.out.println("Số điện thoại không hợp lệ");
        }
    }

    // 5. Kiểm tra mật khẩu
    static void checkPassword() {
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$!%]).{8,}$";
        if (password.matches(regex)) {
            System.out.println("Mật khẩu hợp lệ");
        } else {
            System.out.println("Mật khẩu không hợp lệ");
        }
    }
}
