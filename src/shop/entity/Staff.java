package shop.entity;

import account.entity.User;

import java.util.Scanner;

public class Staff extends User {

    public Staff(String username, String name, String email, String address, String phone, String password, String role) {
        super(username, name, email, address, phone, password, role);
    }

    @Override
    public void inputInfo(Scanner scanner) {
        super.inputInfo(scanner);
    }


}