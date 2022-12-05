package shop.entity;

import account.entity.IHandleGeneral;
import account.entity.User;


import java.util.List;
import java.util.Scanner;

public class Customer extends User implements IHandleGeneral {
    private double balance;


    public Customer() {
        super();
        this.role = "customer";


    }

//    public Customer(String username, String name, String email, String password) {
//        super(username, name, email, password);
//    }



    public void inputInfo(Scanner scanner,List<User> users) {
        super.inputInfo(scanner,users);
        System.out.println("Nhập số dư khả dụng:");
        this.balance = returnDouble(scanner);

    }



//    ==========

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


}
