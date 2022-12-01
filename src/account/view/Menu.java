package account.view;


import account.entity.User;
import account.handle.HandleAccount;
import shop.entity.Shop;

import java.util.List;
import java.util.Scanner;

public class Menu {
    private HandleAccount handleAccount;
    private Shop shop;

    public HandleAccount getHandleAccount() {
        return handleAccount;
    }

    public void setHandleAccount(HandleAccount handleAccount) {
        this.handleAccount = handleAccount;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public void mainMenu(Scanner scanner, List<User> users) {
        System.out.println("================ FPT =================");
        System.out.println("1. Đăng nhập");
        System.out.println("2. Đăng ký");
        System.out.println("0. Thoát");
        System.out.print("Mời chọn: ");
        int ch;
        while (true) {
            try {
                ch = Integer.parseInt(scanner.nextLine());
                if (ch < 0 || ch > 2) {
                    throw new Exception();
                }
                break;
            } catch (Exception e) {
                System.out.print("Mời chọn lại: ");
            }
        }
        switch (ch) {
            case 1:
                handleAccount.login(scanner, users);
                break;
            case 2:
                handleAccount.registerAcc(scanner, users);
                break;
            case 0:
                System.exit(0);
        }
    }

    public void viewLogin(Scanner scanner, List<User> users, User user) {
        System.out.println("============== Đăng nhập ================");
        System.out.println("1. Đăng nhập lại");
        System.out.println("2. Quên mật khẩu");
        System.out.print("Mời chọn: ");
        int ch;
        while (true) {
            try {
                ch = Integer.parseInt(scanner.nextLine());
                if (ch < 1 || ch > 2) {
                    throw new Exception();
                }
                break;
            } catch (Exception e) {
                System.out.print("Mời chọn lại: ");
            }
        }

        switch (ch) {
            case 1:
                handleAccount.login(scanner, users);
                break;
            case 2:
                handleAccount.forgetPassword(scanner, users, user);
                break;
        }
    }

    public void viewFunction(Scanner scanner, List<User> users, User user) {
        while (true) {
            System.out.println("===================== Chức năng người dùng =============================");
            System.out.println("Chào mừng " + user.getUsername() + ", bạn có thể thực hiện các công việc sau:");
            System.out.println("1. Thay đổi username");
            System.out.println("2. Thay đổi email");
            System.out.println("3. Thay đổi mật khẩu");
            System.out.println("4. Đăng xuất");
            System.out.print("Mời chọn: ");
            int ch;
            while (true) {
                try {
                    ch = Integer.parseInt(scanner.nextLine());
                    if (ch < 1 || ch > 4) {
                        throw new Exception();
                    }
                    break;
                } catch (Exception e) {
                    System.out.print("Mời chọn lại: ");
                }
            }
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
