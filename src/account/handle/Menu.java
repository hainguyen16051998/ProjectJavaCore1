package account.handle;

import account.entity.User;
import shop.view.MenuAdmin;
import shop.view.MenuCustomer;
import shop.view.MenuStaff;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    // Menu ban đầu
    //có nên luôn cho return không ??
    public void displayMenu(Scanner scanner, ArrayList<User> users) {
        System.out.println("------MẢNG BÁN HÀNG-----");
        System.out.println("1. Đăng nhập");
        System.out.println("2. Đăng ký khách hàng");
        System.out.println("0. Thoát");
        System.out.print("Mời bạn chọn: ");
        int choice ;
        do {
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice == 1 || choice == 2 || choice == 0)
                    break;
                System.out.println("Nhập sai, nhập lại: ");

            } catch (Exception e) {
                System.out.println("Nhập số, nhập lại: ");
            }
        } while (true);
        switch (choice) {
            case 1:
                login(scanner, users);                // Đăng nhập
                break;
            case 2:
                registerCutsomer(scanner, users);     // Đăng ký
                break;
            case 0:
                return;
        }
    }

    private void login(Scanner scanner, ArrayList<User> users) {
        System.out.print("Mời nhập username: ");
        String username = scanner.nextLine();
        boolean check = false;
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                check = true;
            }
            if (!check) {
                System.out.println("Username không tồn tại, nhập lại: ");
                login(scanner, users);
            }

        }
    }

    private void registerCutsomer(Scanner scanner, ArrayList<User> users) {
        User user = new User();
        user.inputInfo(scanner);
        users.add(user);
        System.out.println(user);
        displayMenu(scanner, users);
    }

//    public void login(Scanner scanner, ArrayList<User> users) {
//        System.out.print("Mời nhập username: ");
//        String username = scanner.nextLine();
//        boolean check = false;
//        for (User user : users) {
//            if (user.getUsername().equals(username)) {
//                check = true;
//                System.out.print("Mời nhập passwword: ");
//                String passwword = scanner.nextLine();
//                if (user.getPassword().equals(passwword)) {
//                    if (user.getRole().equals("Admin")) {
//                        MenuAdmin admin = new MenuAdmin();
//                        admin.showMenu();
//                    } else if (user.getRole().equals("Staff")) {
//                        MenuStaff staff = new MenuStaff();
//                        staff.showMenu(scanner);
//                    } else if (user.getRole().equals("Customer")) {
//                        MenuCustomer customer = new MenuCustomer();
//                        customer.showMenu(scanner);
//                    }
//                } else {
//                    relogin(scanner, users);
//                    break;
//                }
//            }
//            if (!check) {
//                System.out.println("Username không tồn tại, nhập lại: ");
//                login(scanner, users);
//            }
//        }
//    }



    public void relogin(Scanner scanner, ArrayList<User> users) {
        System.out.println(" Bạn đã nhập sai mật khẩu: ");
        System.out.println("1 - Đăng nhập lại");
        System.out.println("2 - Quên mật khẩu");
        System.out.print("Mời chọn: ");
        int choice;
        do {
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice == 1 || choice == 2)
                    break;
                System.out.println("Nhập lại ");
            } catch (Exception e) {
                System.out.println("Nhập sai, nhập lại");
            }
        } while (true);
        switch (choice) {
            case 1:
                login(scanner, users);                    // Đăng nhập lại
                break;
            case 2:
                forgotPassword(scanner, users, users);    // Quên mật khẩu
                displayMenu(scanner, users);
        }
    }

    private void forgotPassword(Scanner scanner, ArrayList<User> users, ArrayList<User> user) {
        System.out.print("Mời bạn nhập Email: ");
        String email = scanner.nextLine();
        for (User user1 : users) {
            if (user1.getEmail().equals(email)) {
                System.out.println("Bạn được phép đổi mật khẩu");
                System.out.print("Mật khẩu mới là: ");
                String newpass1;
                do {
                    newpass1 = scanner.nextLine();
                    if (!user1.getPassword().equals(newpass1))
                        break;
                    System.out.println("Bạn phải nhập mật khẩu mới khác với các mật khẩu bạn đã từng dùng, Nhập lại: ");
                } while (true);
                do {
                    System.out.print("Kiểm tra lại mật khẩu: ");
                    String newpass2 = scanner.nextLine();
                    if (newpass1.equals(newpass2))
                        break;
                    System.out.println("Mật khẩu k trùng khớp, mời nhập lại: ");
                } while (true);
                user1.setPassword(newpass1);
            } else {
                System.out.println("Email không tồn tại, vui lòng thử lại");
                forgotPassword(scanner, users, user);
            }
            System.out.println("Tài khoản mới là: " + user1);
            break;                                                                  // đang ??
        }
    }
}
