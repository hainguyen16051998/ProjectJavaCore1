package shop.entity;

import account.entity.User;
import shop.constant.RoleConstant;

import java.util.Scanner;

public class Staff extends User {

    public Staff() {
        System.out.println("Nhập thông tin nhân viên: ");
    }

    public Staff(String username, String name, String email, String password) {
        super(username, name, email, password);
    }
}