package account.view;

import account.entity.IChooseFunction;
import account.entity.User;
import account.handle.HandleAccount;
import shop.entity.Shop;

import java.util.List;
import java.util.Scanner;

public class MenuAdmin implements IChooseFunction {
    private Shop shop;
    private Menu menu;
    private HandleAccount handleAccount;

    public MenuAdmin(Shop shop) {
        this.shop = shop;

    }

    public void showMenu(Scanner scanner, User user) {

        System.out.println("===== Xin chào quản trị viên ======");
        System.out.println("1. Quản lý nhân viên");
        System.out.println("2. Quản lý khách hàng");
        System.out.println("3. Chỉnh sửa thông tin cá nhân");
        System.out.println("0. Đăng xuất");
        int ch = chooseFunction(scanner, 3);
        switch (ch) {
            case 1:
                ;
                break;
            case 2:
                break;
            case 3:
                break;
            case 0:
                return;
        }
    }

    public void showMenuManager(Scanner scanner, User user) {
        System.out.println("===== Xin chào quản trị viên ======");
        System.out.println("1. Chỉnh sửa tài khoản");
        System.out.println("2. Tạo tài khoản");
        System.out.println("3. Xóa tài khoản");
        System.out.println("0. Thoát");
        int ch = chooseFunction(scanner, 3);
        switch (ch) {
            case 1:

                break;
            case 2:
                break;
            case 3:
                break;
            case 0:
                return;
        }

    }

    public void viewChangeInfo(Scanner scanner, List<User> users, User user) {
        while (true) {
            System.out.println("===================== Thay đổi thông tin  =============================");
            System.out.println("1. Thay đổi username");
            System.out.println("2. Thay đổi mật khẩu");
            System.out.println("3. Thay đổi email");
            System.out.println("4. Thay đổi số điện thoại");
            System.out.println("0. Đăng xuất");
            System.out.print("Mời chọn: ");
            int ch = chooseFunction(scanner, 4);
            switch (ch) {
                case 1:
                    handleAccount.changeUsername(scanner, users, user);
                    break;
                case 2:
                    handleAccount.changeEmail(scanner, users, user);
                    break;
                case 3:
                    handleAccount.changePassword(scanner, user);
                    break;
                case 4:
                    return;
            }
        }
    }


}
