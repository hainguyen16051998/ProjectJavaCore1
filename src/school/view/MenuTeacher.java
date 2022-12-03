package school.view;

import account.entity.IChooseFunction;
import account.entity.User;
import shop.entity.Customer;
import shop.handle.HandleCustomer;

import java.util.List;
import java.util.Scanner;

public class MenuTeacher implements IChooseFunction {
    public void showMenu(Scanner scanner, List<User> users, User user) {

        while (true) {
            System.out.println("Xin mời chọn chức năng ");
            System.out.println("1. Xem thông tin các môn học ");
            System.out.println("2. Xem thông tin học viên");
            System.out.println("3. Chỉnh sửa điểm học viên ");
            System.out.println("4. Xem và chỉnh sửa thông tin cá nhân ");
            System.out.println("0. Đăng xuất ");
            System.out.print("Chọn chức năng: ");
            int choice = chooseFunction(scanner, 4, 0);
            try {
                switch (choice) {
                    case 1:

                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                    case 4:

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

