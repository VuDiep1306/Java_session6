import java.util.Scanner;
import java.util.Arrays;

public class session6_3 {
    static Scanner sc = new Scanner(System.in);
    static String[] plates = new String[100];
    static int count = 0;

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("******************QUẢN LÝ BIỂN SỐ XE****************");
            System.out.println("1. Thêm các biển số xe");
            System.out.println("2. Hiển thị danh sách biển số xe");
            System.out.println("3. Tìm kiếm biển số xe (chính xác)");
            System.out.println("4. Tìm biển số theo mã tỉnh");
            System.out.println("5. Sắp xếp biển số xe tăng dần");
            System.out.println("6. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1 -> addPlate();
                case 2 -> showPlates();
                case 3 -> searchPlate();
                case 4 -> searchByProvince();
                case 5 -> sortPlates();
                case 6 -> System.out.println("Thoát chương trình!");
                default -> System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 6);
    }

    // 1.Thêm các biển số xe
    static void addPlate() {
        System.out.print("Nhập số lượng biển số muốn thêm: ");
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String plate;
            do {
                System.out.println("Nhập biển số xe " + (i + 1) + " (VD: 30F-123.45): ");
                plate = sc.nextLine().trim();
                if (!plate.matches("^[0-9]{2}[A-Z]-[0-9]{3}\\.[0-9]{2}$")) {
                    System.out.println("⚠ Biển số không hợp lệ! Nhập lại!");
                }
            } while (!plate.matches("^[0-9]{2}[A-Z]-[0-9]{3}\\.[0-9]{2}$"));
            plates[count++] = plate;
        }
        System.out.println("✔ Đã thêm thành công!");
    }

    // 2. Hiển thị danh sách biển số xe
    static void showPlates() {
        if (count == 0) {
            System.out.println("⚠ Chưa có dữ liệu!");
            return;
        }
        System.out.println("\n📌 Danh sách biển số xe:");
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". " + plates[i]);
        }
    }

    //3. Tìm kiếm biển số xe (chính xác)
    static void searchPlate() {
        System.out.print("Nhập biển số cần tìm: ");
        String key = sc.nextLine();
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (plates[i].equalsIgnoreCase(key)) {
                System.out.println("✔ Tìm thấy: " + plates[i]);
                found = true;
                break;
            }
        }
        if (!found) System.out.println("❌ Không tìm thấy!");
    }

    //4. Tìm biển số theo mã tỉnh
    static void searchByProvince() {
        System.out.println("Nhập mã tỉnh (VD: 30, 51): ");
        String code = sc.nextLine();
        boolean found = false;
        System.out.println("📍 Biển số thuộc tỉnh " + code + ":");
        for (int i = 0; i < count; i++) {
            if (plates[i].startsWith(code)) {
                System.out.println("- " + plates[i]);
                found = true;
            }
        }
        if (!found) System.out.println("❌ Không có biển số nào thuộc mã tỉnh này!");
    }

    // 5. Sắp xếp biển số xe tăng dần
    static void sortPlates() {
        if (count == 0) {
            System.out.println("⚠ Chưa có dữ liệu để sắp xếp!");
            return;
        }
        Arrays.sort(plates, 0, count);
        System.out.println("✔ Đã sắp xếp tăng dần!");
        showPlates();
    }
}