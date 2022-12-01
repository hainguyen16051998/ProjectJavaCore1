package shop.entity;

import account.entity.User;


import java.util.List;
import java.util.Scanner;

public class Customer extends User {
    private double balance;
    private List<shop.entity.Order> orders;

    public Customer() {
        this.role = "customer";                       // có nên tạo enum role ko nhỉ?
    }

    public Customer(String username, String name, String email, String address, String phone, String password, String role, double balance) {
        super(username, name, email, address, phone, password, role);
        this.balance = balance;
    }

    @Override
    public void inputInfo(Scanner scanner) {
        super.inputInfo(scanner);
        System.out.println("Nhập số dư khả dụng:");

    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<shop.entity.Order> getOrders() {
        return orders;
    }

    public void setOrders(List<shop.entity.Order> orders) {
        this.orders = orders;
    }

    public void showInfo() {
        System.out.println("Mã tài khoản: " + this.id + ", Email: " + this.email);
        System.out.println("Họ tên: " + this.name + ", địa chỉ" + this.address + ", SĐT: " + this.phone);
    }
}
