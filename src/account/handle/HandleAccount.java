package account.handle;


import account.entity.User;
import account.view.Menu;
import shop.entity.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HandleAccount {
    Menu menu;

    public HandleAccount(Menu menu) {
        this.menu = menu;
    }
//    // Kiểm tra trùng SĐT vs hệ thống
//    private void checkPhone(Scanner scanner) {             // Lỗi so sánh
//        ArrayList<User> users = new ArrayList<>();
//        String phone = scanner.nextLine();
//        for (User user : users) {
//            if (!user.getPhone().equals(phone)) {
//                this.phone = phone;
//                break;
//            }
//            System.out.print("SĐT này đã có trong hệ thống, vui lòng nhập SĐT khác ");
//        }
////    }
//    }

    /// đăng nhập
    public void login(Scanner scanner, List<User> users) {
        System.out.println("============ Đăng nhập ===============");
        while (true) {
            System.out.print("Username: ");
            String name = scanner.nextLine();
            System.out.print("Password: ");
            String password = scanner.nextLine();
            boolean check = false;
            for (User User : users) {
                if (User.getUsername().equals(name)) {
                    // nhập đúng username
                    check = true;
                    if (User.getPassword().equals(password)) {
                        //nhập đúng cả password
                        menu.viewFunction(scanner, users, User);
                    } else {
                        //sai pass
                        menu.viewLogin(scanner, users, User);
                    }
                }
            }
            if (check) {
                break;
            }
            System.out.println("Kiểm tra lại username!");
        }
    }

    // Đăng ky khách hàng ===> set luôn role customer
    public void registerAcc(Scanner scanner, List<User> users) {
        User user = new User();
        System.out.println("================ Đăng ký tài khoản ===============");
        user.setUsername(inputUsername(scanner, users));
        user.setEmail(inputEmail(scanner, users));
        user.setPassword(inputPassword(scanner));
        user.setRole("customer");
        users.add(user);
/// downcasting
//        Customer customer = (Customer) user;

    }

    // =======================quên mật khẩu=============
    public void forgetPassword(Scanner scanner, List<User> users, User user) {
        System.out.println("============ Quên mật khẩu ================");
        System.out.print("Email: ");
        String email = scanner.nextLine();
        if (user.getEmail().equals(email)) {
            String password = inputPassword(scanner);
            user.setPassword(password);
            Menu menu = new Menu();
            menu.viewFunction(scanner, users, user);
        }
        System.out.println("Tài khoản chưa tồn tại!");
    }


    //================================================ Thay đổi mật khẩu, email, usernmame==============================
    public void changeUsername(Scanner scanner, List<User> users, User user) {
        System.out.println("======= Thay đổi username ========");
        String newName = inputUsername(scanner, users);
        user.setUsername(newName);
    }

    public void changeEmail(Scanner scanner, List<User> users, User user) {
        System.out.println("======= Thay đổi email ========");
        String newMail = inputEmail(scanner, users);
        user.setEmail(newMail);
    }

    public void changePassword(Scanner scanner, User user) {

        System.out.println("======= Thay đổi mật khẩu ========");
        System.out.print("Mật khẩu hiện tại: ");
        String currentPass = scanner.nextLine();
        if (!currentPass.equals(user.getPassword())) {
            System.out.println("Sai mật khẩu!");
            return;
        }
        while (true) {
            System.out.print("Mật khẩu mới: ");
            String newPass = inputPassword(scanner);
            if (!newPass.equals(user.getPassword())) {
                user.setPassword(newPass);
                break;
            }
            System.out.print("Giống mật khẩu cũ! Nhập lại: ");
        }

    }

    ///============================================= kiểm tra pass, username, email=======================
//    kiểm tra mật khẩu
    public String inputPassword(Scanner scanner) {
//        String regex = "^(?=.*[A-Z])(?=.*[\\.;\\,_-])\\S{7,15}$";//// thay lại regxx sau
        String newPass;
        System.out.print("Password: ");
        while (true) {
            newPass = scanner.nextLine();
//            if (!newPass.matches(regex)) {
//                System.out.println("Mật khẩu dài 7-15 ký tự, chứa ít nhất 1 ký tự in hoa, 1 ký tự đặc biệt (. , - _ ;)! ");
//                continue;
//            }
            break;
        }
        return newPass;
    }

    /// kiểm tra email
    public String inputEmail(Scanner scanner, List<User> users) {
        String regex = "^([a-z0-9_\\.-]+)@([\\da-z\\.-]+)\\.([a-z\\.]{2,6})$";
        String newMail;
        System.out.print("Email: ");
        while (true) {
            newMail = scanner.nextLine();
            if (!newMail.matches(regex)) {
                System.out.print("Không đúng định dạng! Nhập lại: ");
                continue;
            }
            boolean check = true;
            for (User temp : users) {
                if (temp.getEmail().equals(newMail)) {
                    check = false;
                    System.out.print("Email đã tồn tại! Nhập lại: ");
                    break;
                }
            }
            if (check)
                break;
        }
        return newMail;
    }

    //kiểm tra username
    public String inputUsername(Scanner scanner, List<User> users) {
        String newName;
        System.out.print("Username: ");
        while (true) {
            newName = scanner.nextLine();
            boolean check = true;
            for (User temp : users) {
                if (temp.getUsername().equals(newName)) {
                    check = false;
                    System.out.print("Username đã tồn tại! Nhập lại: ");
                    break;
                }
            }
            if (check)
                break;
        }
        return newName;
    }
}