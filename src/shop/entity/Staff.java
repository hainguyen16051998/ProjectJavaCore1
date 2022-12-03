package shop.entity;

import account.entity.User;
import shop.constant.RoleConstant;

import java.util.Scanner;

public class Staff extends User {

    public Staff() {
        this.id = autoID++;
        this.role = "staff";
    }

    public Staff(String username, String name, String email, String password) {
        super(username, name, email, password);
    }
}