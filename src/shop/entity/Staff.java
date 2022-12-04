package shop.entity;

import account.entity.User;
import shop.constant.RoleConstant;

import java.util.Scanner;

public class Staff extends User {
 private double balance;
    public Staff() {
        super();
        this.role = "staff";
    }

//    public Staff(String username, String name, String email, String password) {
//        super(username, name, email, password);
//    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Mức lương: "+this.balance);
    }

    @Override
    public void inputInfo(Scanner scanner) {
        super.inputInfo(scanner);
        System.out.print("Mức lương: ");
        this.balance = returnDouble(scanner);
    }
}