package account.entity;

import account.handle.HandleAccount;

import java.util.List;
import java.util.Scanner;


public class User implements IHandleGeneral {
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

    public User(String username, String name, String email, String password) {
        this.id = autoID++;
        this.username = username;
        this.name = name;
        this.email = email;
        this.password = password;
    }


    //Nhập thông tin user
    // quả menu dở hơi
    public void inputInfo(Scanner scanner, List<User> users) {
        HandleAccount handleAccount = new HandleAccount();
        System.out.println("================ Tạo tài khoản ===============");
        this.username = handleAccount.inputUsername(scanner, users);
        this.password = handleAccount.inputPassword(scanner);
        System.out.print("Nhập họ tên: ");
        this.name = scanner.nextLine();
        System.out.print("Nhập địa chỉ: ");
        this.address = scanner.nextLine();
        this.email = handleAccount.inputEmail(scanner, users);
        this.phone = handleAccount.inputPhone(scanner, users);

    }

    public void showInfo() {
        System.out.println("Mã tài khoản: " + this.id + ", Username: " + this.username + ", Email: " + this.email);
        System.out.println("Họ tên: " + this.name + ", Địa chỉ: " + this.address + ", SĐT: " + this.phone);
    }

    public void editInfo(List<User> users, User user, Scanner scanner) {
        HandleAccount handleAccount = new HandleAccount();
        user.showInfo();
        System.out.println("\nLựa chọn thay đổi thông tin: ");
        while (true) {
            System.out.println("1. Thay đổi họ tên ");
            System.out.println("2. Thay đổi địa chỉ ");
            System.out.println("3. Thay đổi SĐT");
            System.out.println("4. Thay đổi email");
            System.out.println("5. Thay đổi username ");
            System.out.println("6. Thay đổi password");
            System.out.println("0. Thoát ");
            System.out.print("Chọn chức năng: ");
            int changeInfoChoice = chooseFunction(scanner, 6, 0);
            switch (changeInfoChoice) {
                case 1:
                    System.out.println("============ Thay đổi họ tên ================");
                    System.out.print("Họ tên mới: ");
                    user.setName(scanner.nextLine());
                    break;
                case 2:
                    System.out.println("============ Thay đổi địa chỉ ================");
                    System.out.print("Địa chỉ mới: ");
                    user.setAddress(scanner.nextLine());
                    break;
                case 3:
                    System.out.println("============ Thay đổi SĐT ================");
                    System.out.print("SĐT mới: ");
                    handleAccount.changePhone(scanner, users, user);
                    break;
                case 4:
                    handleAccount.changeEmail(scanner, users, user);
                    break;
                case 5:
                    handleAccount.changeUsername(scanner, users, user);
                    break;
                case 6:
                    handleAccount.changePassword(scanner, user);
                    break;
                case 0:
                    return;
            }
        }
    }

    //    =====
    public int getId() {
        return id;
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


}
