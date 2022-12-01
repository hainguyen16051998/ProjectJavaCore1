package account.entity;

import shop.constant.RoleConstant;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

public class User extends ArrayList<User> {
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

    public User(String name, String address, String email, String phone, String username, String password, String role) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.username = username;
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

    //Nhập thông tin user
    public void inputInfo(Scanner scanner) {
        User users = new User();
        System.out.print("Mời nhập họ tên: ");
        this.name = scanner.nextLine();
        System.out.print("Mời nhập địa chỉ: ");
        this.address = scanner.nextLine();
        System.out.print("Mời nhập SĐT: ");
        checkPhone(scanner);
        System.out.print("Mời nhập username: ");
        checkUsername(scanner, users);
        System.out.print("Mời nhập password: ");
        checkPassword(scanner);
        System.out.print("Mời nhập email: ");
        checkEmail(scanner, users);
        this.role = RoleConstant.Cutstomer.value;
    }


    // Kiểm tra trùng EMAIL vs hệ thống
    private void checkEmail(Scanner scanner, User users) {        // Lỗi so sánh
        String email;
        String regex = "^[a-zA-Z0-9\\.]+@[a-zA-Z]+(\\.[a-zA-Z]+)$";
        while (true) {
            email = scanner.nextLine();
            if (!email.matches(regex)) {
                System.out.println("Không đúng định dạng! Nhập lại ");
            } else
                break;
        }
        for (User user : users) {
            if (!email.equals(user.getUsername())) {
                this.email = email;
                break;
            } else {
                System.out.print("Email này đã được sử dụng, vui lòng tạo Email khác ");
            }
        }
    }


    // Kiểm tra Password
    private void checkPassword(Scanner scanner) {
        String regex = "^(?=.*[A-Z])(?=.*[\\.;\\,_-])\\S{7,15}$";
        String password;
        while (true) {
            password = scanner.nextLine();
            if (password.matches(regex)) {
                this.password = password;
                break;
            } else
                System.out.println("Không đúng định dạng! Password dài từ 7 đến 15 ký tự, chứa ít nhất 1 ký tự in hoa, 1 ký tự đặc biệt, Nhập lại ");
        }


    }


    // Kiểm tra trùng USERNAME vs hệ thống
    private void checkUsername(Scanner scanner, ArrayList<User> users) { // Lỗi so sánh
        String username = scanner.nextLine();
        for (User user : users) {
            if (!username.equals(user.getUsername())) {
                this.username = username;
                break;
            } else {
                System.out.print("Username này đã được sử dụng, vui lòng tạo Username khác ");
            }
        }
    }


    // Kiểm tra trùng SĐT vs hệ thống
    private void checkPhone(Scanner scanner) {             // Lỗi so sánh
        ArrayList<User> users = new ArrayList<>();
        String phone = scanner.nextLine();
        for (User user : users) {
            if (!user.getPhone().equals(phone)) {
                this.phone = phone;
                break;
            }
            System.out.print("SĐT này đã có trong hệ thống, vui lòng nhập SĐT khác ");
        }
    }

}
