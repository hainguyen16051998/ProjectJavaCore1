package account.entity;

import java.util.Scanner;

public class User {
    protected static int autoID = 1;
    protected int id;
    protected String username;
    protected String name;
    protected String email;
    protected String address;
    protected String phone;
    protected String password;
    protected String role;

    public User() {
        this.id = autoID++;
    }

    public User(String username, String name, String email, String address, String phone, String password, String role) {
        this.username = username;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.password = password;
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    //Nhập thông tin user
    public void inputInfo(Scanner scanner) {
        System.out.print("Mời nhập username: ");
        this.username = scanner.nextLine();
        System.out.print("Mời nhập họ tên: ");
        this.name = scanner.nextLine();
        System.out.print("Mời nhập email: ");
        this.email = scanner.nextLine();   ///Bổ sung regex
        System.out.print("Mời nhập địa chỉ: ");
        this.address = scanner.nextLine();
        System.out.print("Mời nhập số điện thoại: ");
        this.phone = scanner.nextLine();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
