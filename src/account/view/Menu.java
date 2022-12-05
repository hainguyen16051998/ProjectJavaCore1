package account.view;


import account.entity.IHandleGeneral;
import account.entity.User;
import account.handle.HandleAccount;
import school.entity.Clazz;
import school.entity.Student;
import school.entity.Subject;
import school.entity.Teacher;
import shop.entity.Shop;

import java.util.List;
import java.util.Scanner;

public class Menu implements IHandleGeneral {
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

    public void mainMenu(Scanner scanner, List<User> users, User user, Clazz clazzes, Subject subjects, Teacher teacher, Student student) {

       while (true){
           System.out.println("================ FPT =================");
           System.out.println("1. Đăng nhập");
           System.out.println("2. Đăng ký");
           System.out.println("0. Thoát");
           System.out.print("Mời chọn: ");
           int ch = chooseFunction(scanner, 2, 0);
           switch (ch) {
               case 1:
                   handleAccount.login(scanner, users, user, clazzes, subjects, teacher, student);
                   break;
               case 2:
                   handleAccount.registerAcc(scanner, users);
                   break;
               case 0:
                   return;
           }
       }
    }

    public void viewLogin(Scanner scanner, List<User> users, User user, Clazz clazzes, Subject subjects, Teacher teacher, Student student) {
        System.out.println("============== Đăng nhập ================");
        System.out.println("1. Đăng nhập lại");
        System.out.println("2. Quên mật khẩu");
        System.out.print("Mời chọn: ");
        int ch = chooseFunction(scanner, 2, 1);
        switch (ch) {
            case 1:
                handleAccount.login(scanner, users, user, clazzes, subjects, teacher, student);
                break;
            case 2:
                handleAccount.forgetPassword(scanner, users, user);
                break;
        }
    }

}
