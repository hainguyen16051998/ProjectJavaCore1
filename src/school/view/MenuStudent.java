package school.view;

import account.entity.IChooseFunction;
import account.entity.User;

import java.util.List;
import java.util.Scanner;

public class MenuStudent implements IChooseFunction {
    public void showMenu(Scanner scanner, List<User> users, User user) {

        while (true) {
            System.out.println("Xin mời chọn chức năng ");
            System.out.println("1. Xem thông tin các môn học ");
            System.out.println("2. Xem thông tin giảng viên");
            System.out.println("3. Xem và chỉnh sửa thông tin cá nhân ");
            System.out.println("0. Đăng xuất ");
            System.out.print("Chọn chức năng: ");
            int choice = chooseFunction(scanner, 3, 0);
            try {
                switch (choice) {
                    case 1:

                        break;
                    case 2:

                        break;
                    case 3:

                        break;

                    case 0:
                        return;
                }
            } catch (Exception e) {
                System.out.println("Chưa có dữ liệu!");
            }

        }
    }
}
