package account.handle;


import account.entity.User;
import account.view.Menu;
import account.view.MenuAdmin;
import school.entity.School;
import school.entity.Student;
import school.entity.Teacher;
import school.view.MenuStudent;
import school.view.MenuTeacher;
import shop.entity.Customer;
import shop.entity.Shop;
import shop.view.MenuCustomer;
import shop.view.MenuStaff;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HandleAccount {
    private Menu menu;
    private Shop shop;
    private School school;

    public HandleAccount(Menu menu, Shop shop, School school) {
        this.menu = menu;
        this.shop = shop;
        this.school = school;
    }

    public HandleAccount() {

    }


    /// đăng nhập
    public void login(Scanner scanner, List<User> users) {
        System.out.println("============ Đăng nhập ===============");
        while (true) {
            System.out.print("Username: ");
            String name = scanner.nextLine();
            System.out.print("Password: ");
            String password = scanner.nextLine();
            boolean check = false;
            for (User user : users) {
                if (user.getUsername().equals(name)) {
                    // nhập đúng username
                    check = true;
                    if (user.getPassword().equals(password)) {
                        //nhập đúng cả password
                        // check role
                        checkRole(scanner, users, user);
                    } else {
                        //sai pass
                        menu.viewLogin(scanner, users, user);
                    }
                }
            }
            if (check) {
                break;
            }
            System.out.println("Đăng nhập không thành công!");
        }
    }

    /// check role
    public void checkRole(Scanner scanner, List<User> users, User user) {
        if (user.getRole().equals("admin")) {
            MenuAdmin menuAdmin = new MenuAdmin(this.shop,this.school);
            menuAdmin.showMenuManager(scanner, users, user);
        } else if (user.getRole().equals("customer")) {
            MenuCustomer menuCustomer = new MenuCustomer(this.shop);
            menuCustomer.showMenu(scanner, users, user);
        } else if (user.getRole().equals("staff")) {
            MenuStaff menuStaff = new MenuStaff(this.shop);
            menuStaff.showMenu(scanner, users, user);
        } else if (user.getRole().equals("teacher")) {
            MenuTeacher menuTeacher = new MenuTeacher(this.school);
            menuTeacher.showMenu(scanner,users, (Teacher) user);
        } else {
            MenuStudent menuStudent = new MenuStudent(this.school);
            menuStudent.showMenu(scanner,users, (Student) user);
        }
    }

    // Đăng ky khách hàng ===> set luôn role customer
    public void registerAcc(Scanner scanner, List<User> users) {
        Customer customer = new Customer();
        System.out.println("================ Đăng ký tài khoản ===============");
        customer.setUsername(inputUsername(scanner, users));
        customer.setEmail(inputEmail(scanner, users));
        customer.setPassword(inputPassword(scanner));
        customer.setPhone(inputPhone(scanner, users));
        this.shop.getCustomers().add(customer);
//        users.add((User) customer);


    }

    // =======================quên mật khẩu=============
    public void forgetPassword(Scanner scanner, List<User> users, User user) {
        System.out.println("============ Quên mật khẩu ================");
        System.out.print("Email: ");
        String email = scanner.nextLine();
        if (user.getEmail().equals(email)) {
            String password = inputPassword(scanner);
            user.setPassword(password);
        } else {
            System.out.println("Email của tài khoản không đúng");
        }
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

    public void changePhone(Scanner scanner, List<User> users, User user) {
        System.out.println("======= Thay đổi SĐT ========");
        String newSĐT = inputPhone(scanner, users);
        user.setPhone(newSĐT);
    }

    ///============================================= kiểm tra pass, username, email=======================
//    kiểm tra mật khẩu

    public String inputPassword(Scanner scanner) {
        String regex = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$";////
        String newPass;
        System.out.print("Password: ");
        while (true) {
            newPass = scanner.nextLine();
            if (!newPass.matches(regex)) {
                System.out.println("Mật khẩu tối thiểu 8 ký tự, gồm chữ cái, số và ký tự đặc biệt: ");
                continue;
            }
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

    ///kiểm tra sđt
    public String inputPhone(Scanner scanner, List<User> users) {
        String regex = "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$";
        String newSĐT;
        System.out.print("SĐT: ");
        while (true) {
            newSĐT = scanner.nextLine();
            if (!newSĐT.matches(regex)) {
                System.out.print("Không đúng định dạng! Nhập lại: ");
                continue;
            }
            boolean check = true;
            for (User temp : users) {
               if (temp.getPhone()!=null){
                   if (temp.getPhone().equals(newSĐT)) {
                       check = false;
                       System.out.print("SĐT đã tồn tại! Nhập lại: ");
                       break;
                   }
               }
            }
            if (check)
                break;
        }
        return newSĐT;
    }
}