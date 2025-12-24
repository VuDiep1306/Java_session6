import java.util.Scanner;

public class session6_1 {
    static Scanner sc = new Scanner(System.in);
    static double[] scores = new double[100];
    static int n = 0;
    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n******************QUẢN LÝ ĐIỂM SV****************");
            System.out.println("1. Nhập danh sách điểm sinh viên");
            System.out.println("2. In danh sách điểm");
            System.out.println("3. Tính điểm trung bình của các sinh viên");
            System.out.println("4. Tìm điểm cao nhất và thấp nhất");
            System.out.println("5. Đếm số lượng sinh viên đạt và trượt");
            System.out.println("6. Sắp xếp điểm tăng dần");
            System.out.println("7. Thống kê số lượng sinh viên giỏi và xuất sắc");
            System.out.println("8. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    inputScores();
                    break;
                case 2:
                    printScores();
                    break;
                case 3:
                    averageScore();
                    break;
                case 4:
                    findMaxMin();
                    break;
                case 5:
                    countPassFail();
                    break;
                case 6:
                    sortAscending();
                    break;
                case 7:
                    statisticsGoodExcellent();
                    break;
                case 8:
                    System.out.println("Thoát chương trình!");
                    break;
                default:
                    System.out.println("Chức năng không hợp lệ!");
            }
        } while (choice != 8);
    }
    // 1. Nhập danh sách điểm
    static void inputScores() {
        System.out.print("Nhập số lượng sinh viên: ");
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            do {
                System.out.print("Nhập điểm SV " + (i + 1) + ": ");
                scores[i] = sc.nextDouble();
                if (scores[i] < 0 || scores[i] > 10) {
                    System.out.println("Điểm không hợp lệ (0-10). Nhập lại!");
                }
            } while (scores[i] < 0 || scores[i] > 10);
        }
    }
    // 2. In danh sách điểm
    static void printScores() {
        if (n == 0) {
            System.out.println("Chưa có dữ liệu!");
            return;
        }
        System.out.println("Danh sách điểm:");
        for (int i = 0; i < n; i++) {
            System.out.println("SV " + (i + 1) + ": " + scores[i]);
        }
    }
    // 3. Tính điểm trung bình
    static void averageScore() {
        if (n == 0) {
            System.out.println("Chưa có dữ liệu!");
            return;
        }
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += scores[i];
        }
        System.out.println("Điểm trung bình: " + (sum / n));
    }
    // 4. Tìm max và min
    static void findMaxMin() {
        if (n == 0) {
            System.out.println("Chưa có dữ liệu!");
            return;
        }
        double max = scores[0];
        double min = scores[0];
        int indexMax = 0;
        int indexMin = 0;
        for (int i = 1; i < n; i++) {
            if (scores[i] > max) {max = scores[i]; indexMax = i;}
            if (scores[i] < min) {min = scores[i];indexMin = i;}
        }
        System.out.println("Điểm cao nhất: " + max + " (SV " + (indexMax + 1) + ")");
        System.out.println("Điểm thấp nhất: " + min + " (SV " + (indexMin + 1) + ")");
    }
    // 5. Đếm đạt và trượt
    static void countPassFail() {
        if (n == 0) {
            System.out.println("Chưa có dữ liệu!");
            return;
        }
        int pass = 0, fail = 0;
        for (int i = 0; i < n; i++) {
            if (scores[i] >= 5)
                pass++;
            else
                fail++;
        }
        System.out.println("Số SV đạt: " + pass);
        System.out.println("Số SV trượt: " + fail);
    }
    // 6. Sắp xếp tăng dần (Bubble Sort)
    static void sortAscending() {
        if (n == 0) {
            System.out.println("Chưa có dữ liệu!");
            return;
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (scores[j] > scores[j + 1]) {
                    double temp = scores[j];
                    scores[j] = scores[j + 1];
                    scores[j + 1] = temp;
                }
            }
        }
        System.out.println("Đã sắp xếp điểm tăng dần!");
        for (int i = 0; i < n; i++) {
            System.out.println("SV " + (i + 1) + ": " + scores[i]);
        }
    }

    // 7. Thống kê giỏi & xuất sắc
    static void statisticsGoodExcellent() {
        if (n == 0) {
            System.out.println("Chưa có dữ liệu!");
            return;
        }
        int good = 0, excellent = 0;
        for (int i = 0; i < n; i++) {
            if (scores[i] >= 8 && scores[i] < 9)
                good++;
            else if (scores[i] >= 9)
                excellent++;
        }
        System.out.println("Số SV giỏi (8 - <9): " + good);
        System.out.println("Số SV xuất sắc (>=9): " + excellent);
    }
}
