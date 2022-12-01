package shop.view;

import java.util.Scanner;

public class MenuAdmin {
    public void showMenu() {
        System.out.println("---------------------------------------");

        System.out.println("Xin chào ADMIN");
        System.out.println("Xin mời chọn chức năng");
        System.out.println("1. Chỉnh sửa thông tin nhân viên");
        System.out.println("2. Chỉnh sửa thông tin khác hàng");
        System.out.println("3. Thoát");
    }

    public void chooseFunction(Scanner scanner) {
        System.out.print("Chọn chức năng: ");
        int choice = 0;
        try {
            do {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice == 1 || choice == 2 || choice == 3)
                    break;
                System.out.print("Vui lòng chọn chức năng hợp lệ: ");
            } while (true);
        } catch (Exception e) {
            System.out.print("Vui lòng chọn chức năng hợp lệ ");
        }
        switch (choice) {
            case 1:
                break;
            case 2:
                break;
            case 3: // Quay lại  menu đăng nhập
                return;
        }
    }
}
