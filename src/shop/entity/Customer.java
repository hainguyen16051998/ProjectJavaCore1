package shop.entity;

import account.entity.User;


import java.util.List;
import java.util.Scanner;

public class Customer extends User {
    private double balance;
    private List<Order> orders;

    public Customer() {
    }

    public Customer(String username, String name, String email, String password) {
        super(username, name, email, password);
    }


    @Override
    public void inputInfo(Scanner scanner) {
        super.inputInfo(scanner);
        System.out.println("Nhập số dư khả dụng:");
////////////chua biet ai them so du
    }


    public void showInfo() {
        System.out.println("Mã tài khoản: " + this.id + ", Email: " + this.email);
        System.out.println("Họ tên: " + this.name + ", địa chỉ" + this.address + ", SĐT: " + this.phone+", Số dư: "+this.balance);
    }

//    ==========

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
